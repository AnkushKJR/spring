package com.flipkart.invoice.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.flipkart.invoice.entity.Invoice;
import com.flipkart.invoice.util.HibernateUtil;

@Repository
public class InvoiceDAOImpl implements InvoiceDAO {
	

	@Override
	public void saveInvoice(Invoice invoice) {
		
		SessionFactory sessionFactory = HibernateUtil.provideSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction txn = session.beginTransaction();
		
		session.save(invoice);
		
		txn.commit();
		
		session.close();

	}

}
