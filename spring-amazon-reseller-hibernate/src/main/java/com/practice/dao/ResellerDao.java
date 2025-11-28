package com.practice.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.practice.config.HibernateUtil;
import com.practice.model.Reseller;

public class ResellerDao {
	
	public void register(Reseller r) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = s.beginTransaction();
		s.save(r);
		txn.commit();
		s.close();
	}
	
	public Reseller login(String username, String password) {
	    Session s = HibernateUtil.getSessionFactory().openSession();

	    Query<Reseller> q = s.createQuery("from Reseller where username=:u and password=:p");
	    q.setParameter("u", username);
	    q.setParameter("p", password);

	    List<Reseller> list = q.list();
	    s.close();

	    if(list.isEmpty())
	        return null;     // invalid login
	    else
	        return list.get(0);
	}
	
}
