package com.zepto.search.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.zepto.search.entity.Product;
import com.zepto.search.exception.ProductNotFound;
import com.zepto.search.request.ProductRequest;
import com.zepto.search.util.HibernateUtil;

@Repository
public class SearchDAOImpl implements SearchDAO{

	@Override
	public Product findByNameAndCategory(ProductRequest productRequest) {
		
		SessionFactory sessionFactory = HibernateUtil.provideSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction txn = session.beginTransaction();
		
		String name = productRequest.getName();
		String category = productRequest.getCategory();
		
		String hql = "FROM Product p WHERE p.name = :name AND p.category = :category";
		
		Product p = session.createQuery(hql, Product.class)
					        .setParameter("name", name)
					        .setParameter("category", category)
					        .uniqueResult();
		
		txn.commit();
		
		if(p == null) {
			throw new ProductNotFound("product not available in db"); 
		}
		
		return p;
	}

}
