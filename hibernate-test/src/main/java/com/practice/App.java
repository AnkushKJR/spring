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
    	
    	Transaction transaction = session.beginTransaction();
    	
    	Product p = new Product();
    	
    	p.setName("kitkat chocolate");
    	p.setDescription("dark chocolate");
    	p.setPrice(100);
    	p.setQuantity(9);
    	
    	session.save(p);
    	
    	transaction.commit();
    	
    	session.close();
    	
    }
}
