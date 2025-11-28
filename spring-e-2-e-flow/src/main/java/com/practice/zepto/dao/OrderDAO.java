package com.practice.zepto.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practice.zepto.entity.Order;

@Repository
public class OrderDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public int saveOrder(Order orderEntity) {
		
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		Integer response = (Integer) session.save(orderEntity);
		txn.commit();
		System.out.println(response);
		session.close();
		return response;
	}
	
}
