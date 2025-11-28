package com.practice.zepto.login.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.practice.zepto.login.entity.User;
import com.practice.zepto.login.util.HibernateUtil;

@Repository
public class LoginDAO {
	
	public void saveUser(User user) {
		System.out.println("LoginDAO:::saveUser");
		
		Session session = HibernateUtil.provideSessionFactory().openSession();
		Transaction txn = session.beginTransaction();
		session.save(user);
		txn.commit();		
		
	}
	
	public User getUserByUsername(String username) {
        Session session = null;
        User user = null;
        try {
            // 1. Get a new session from your manual utility
            session = HibernateUtil.provideSessionFactory().openSession();
            
            // 2. Begin a transaction (needed for most DB operations)
            session.beginTransaction();
            
            // 3. Write a Hibernate Query Language (HQL) query
            // Assuming your User entity has a field named 'username'
            String hql = "FROM User u WHERE u.username = :username";
            
            // 4. Create the query object and set the parameter value
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("username", username);
            
            // 5. Execute the query and get a unique result
            user = query.uniqueResult();
            
            // 6. Commit the transaction (even for reads, if configured that way)
            session.getTransaction().commit();
            
        } catch (Exception e) {
            if (session != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            // 7. Crucial: Manually close the session
            if (session != null) {
                session.close();
            }
        }
        
        return user;
    }
	
}
