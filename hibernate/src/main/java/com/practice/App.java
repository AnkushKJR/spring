package com.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.practice.entity.Product;

public class App 
{
    public static void main( String[] args )
    {
        
    	Configuration cfg = new Configuration();
    	cfg.configure("\\com\\practice\\config\\hibernate-cfg.xml");
    	
    	SessionFactory sessionFactory = cfg.buildSessionFactory();
    	
    	Session session = sessionFactory.openSession();
    	
    	Transaction txn = session.beginTransaction();
    	
    	Product product = new Product();
    	product.setName("Dettol soap 2");
    	product.setDescription("bathing soap bar");
    	product.setPrice(55);
    	product.setQuantity(10);
    	
    	session.save(product);
    	
    	txn.commit();
    	
    }
}
