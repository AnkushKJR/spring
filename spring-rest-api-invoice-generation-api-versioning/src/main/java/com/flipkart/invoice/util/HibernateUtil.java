package com.flipkart.invoice.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	static SessionFactory sessionFactory;
	
	static {
		Configuration cfg = new Configuration();
		cfg.configure("\\com\\flipkart\\invoice\\config\\hibernate.cfg.xml");
		sessionFactory = cfg.buildSessionFactory();
	}
	
	public static SessionFactory provideSessionFactory() {
		return sessionFactory;
	}

}
