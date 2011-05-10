package com.gis.server.persist;

import org.hibernate.Session;

import com.gis.server.beans.User;


public class Main {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		
		User u = new User();
		
		u.setId(1l);
		u.setName("Robson");
		u.setPassword("Robson");
		
		session.save(u);
		
		session.getTransaction().commit();
		
	}
}
