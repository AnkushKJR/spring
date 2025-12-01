package com.practice.zepto.order.login.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.practice.zepto.order.login.entity.User;
import com.practice.zepto.order.login.util.HibernateUtil;

@Repository
public class LoginDAOImpl implements LoginDAO{

	@Override
	public void saveUser(User user) {
		System.out.println("LoginDAOImpl::::saveUser");
		Session session = HibernateUtil.provideSessionFactory().openSession();
		
		Transaction txn = session.beginTransaction();
		
		session.save(user);
		
		txn.commit();
		
	}
	
	public User getUserByUsername(String username) {
		System.out.println("LoginDAOImpl::::getUserByUsername");
		Session session = HibernateUtil.provideSessionFactory().openSession();
		
		Transaction txn = session.beginTransaction();
		
		String hql = "FROM User u WHERE u.username = :username";
		
		Query<User> query = session.createQuery(hql, User.class);
        query.setParameter("username", username);
        
        User user = query.uniqueResult();
        
        txn.commit();
        
        return user;
	}

}
