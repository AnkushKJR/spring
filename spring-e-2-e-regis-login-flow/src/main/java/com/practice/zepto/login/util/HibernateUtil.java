package com.practice.zepto.login.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	static SessionFactory sessionFactory;
	
	static {
		Configuration cfg = new Configuration();
		cfg.configure("\\com\\practice\\zepto\\login\\config\\hibernate.cfg.xml");
		sessionFactory = cfg.buildSessionFactory();
	}
	
	public static SessionFactory provideSessionFactory() {
		return sessionFactory;
	}

}
