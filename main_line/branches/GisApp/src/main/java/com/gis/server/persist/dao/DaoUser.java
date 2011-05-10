package com.gis.server.persist.dao;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;

import com.gis.server.beans.User;

@Named("daoUser")
public class DaoUser  {

	@Inject
	private	SessionFactory sessionFactory ;
	
//	private Session session;

//	@PostConstruct
//	public void init() {
//		session = sessionFactory.openSession();
//		System.out.println("DaoUser.init()");
//	}

	public void saveBean(User user){
		sessionFactory.getCurrentSession().save(user); 
	}
}
