package com.practice.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.practice.config.HibernateUtil;
import com.practice.model.Product;

public class ProductDao {
	
	public void save(Product p) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(p);
        tx.commit();
        s.close();
    }
	
	public List<Product> list(int resellerId) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("from Product where resellerId=:id");
        q.setParameter("id", resellerId);
        List<Product> list = q.list();
        s.close();
        return list;
    }
	
	public Product get(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(Product.class, id);
    }
	
	public void update(Product p) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.update(p);
        tx.commit();
        s.close();
    }
	
	public void delete(int id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        Product p = s.get(Product.class, id);
        s.delete(p);
        tx.commit();
        s.close();
    }
	
}
