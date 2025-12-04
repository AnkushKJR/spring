package com.zepto.password.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.zepto.password.entity.PasswordHistory;
import com.zepto.password.entity.User;
import com.zepto.password.util.HibernateUtil;

@Repository
public class PasswordDAOImpl implements PasswordDAO{

	@Override
	public List<String> getPasswordByUserId(String userId) {
		
		SessionFactory sessionFactory = HibernateUtil.provideSessionFactory();
		Session session = sessionFactory.openSession();		
		Transaction txn = null;
	    List<String> passwords = null;
		try {
			txn = session.beginTransaction();
			String hql = "SELECT ph.old_password FROM PasswordHistory ph WHERE ph.userId = :userId";
			passwords =  session.createQuery(hql, String.class)
												.setParameter("userId", userId)
												.list();
			
			txn.commit();
		}catch (RuntimeException e) {
			if (txn != null) txn.rollback();
	        throw e;
		}finally {
	        session.close();
	    }
		
		return passwords;
		
	}

	@Override
	public void updateUserPassword(User user) {
		
		SessionFactory sessionFactory = HibernateUtil.provideSessionFactory();
		Session session = sessionFactory.openSession();		
		Transaction txn = null;
		try {
			txn = session.beginTransaction();
			session.update(user);
			txn.commit();
		}catch (RuntimeException e) {
            if (txn != null) {
                txn.rollback();
            }
            System.err.println("Error updating password: " + e.getMessage());
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }		
		
	}
	

	@Override
    public void updatePasswordInOneTransaction(String userId, String currentPassword, String newPassword) {
        SessionFactory sessionFactory = HibernateUtil.provideSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction txn = null;

        try {
            txn = session.beginTransaction();

       
            PasswordHistory newHistoryEntry = new PasswordHistory();
            newHistoryEntry.setUserId(userId);
            newHistoryEntry.setOld_password(currentPassword);
            newHistoryEntry.setCreatedAt(new Date()); 
            session.save(newHistoryEntry);
            
     
            deleteExtraHistoryRecordsNative(session, userId);
            

            String hqlUpdate = "UPDATE User u SET u.password = :newPassword WHERE u.userId = :userId";
            session.createQuery(hqlUpdate)
                   .setParameter("newPassword", newPassword)
                   .setParameter("userId", userId)
                   .executeUpdate();

            txn.commit(); 

        } catch (RuntimeException e) {
            if (txn != null) txn.rollback(); 
            throw e; 
        } finally {
            if (session != null) session.close();
        }
    }

  
    private void deleteExtraHistoryRecordsNative(Session session, String userId) {
        String nativeSql = """
            DELETE FROM password_history 
            WHERE id NOT IN (
                SELECT id FROM (
                    SELECT id FROM password_history 
                    WHERE user_id = :userId 
                    ORDER BY created_at DESC 
                    LIMIT 3
                ) as T
            ) AND user_id = :userId
        """;
        
        session.createNativeQuery(nativeSql)
               .setParameter("userId", userId)
               .executeUpdate();
    }

    @Override
    public String getCurrentUserPassword(String userId) {
        SessionFactory sessionFactory = HibernateUtil.provideSessionFactory();
        Session session = sessionFactory.openSession();
        String currentPassword = null;
        try {
          
            String hql = "SELECT u.password FROM User u WHERE u.userId = :userId";
            currentPassword = session.createQuery(hql, String.class)
                                     .setParameter("userId", userId)
                                     .uniqueResult(); 
        } catch (RuntimeException e) {
            throw e;
        } finally {
            session.close();
        }
        return currentPassword;
    }

 }
