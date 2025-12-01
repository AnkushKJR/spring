package com.zepto.search.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.zepto.search.entity.Product;
import com.zepto.search.util.HibernateUtil;

@Repository
public class ProductDAOImpl implements ProductDAO{

	@Override
	public void saveProduct(Product product) {
		
		SessionFactory sessionFactory = HibernateUtil.provideSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction txn = session.beginTransaction();
		
		session.save(product);
		
		txn.commit();
		
	}
	
	

}
