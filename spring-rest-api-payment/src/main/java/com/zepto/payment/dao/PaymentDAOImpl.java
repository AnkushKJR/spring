package com.zepto.payment.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.zepto.payment.entity.Payment;
import com.zepto.payment.util.HibernateUtil;

@Repository
public class PaymentDAOImpl implements PaymentDAO{

	@Override
	public void savePayment(Payment payment) {
		
		SessionFactory sessionFactory = HibernateUtil.provideSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction txn = session.beginTransaction();
		
		session.save(payment);
		
		txn.commit();
	
	}

}
