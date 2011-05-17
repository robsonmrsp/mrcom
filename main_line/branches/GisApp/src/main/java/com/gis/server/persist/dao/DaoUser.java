package com.gis.server.persist.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;

import com.gis.server.beans.User;

@Named("daoUser")
public class DaoUser  {

	@Inject
	private	SessionFactory sessionFactory ;

	public void saveBean(User user){
		sessionFactory.getCurrentSession().save(user); 
	}
	
	@SuppressWarnings("unchecked")
	public List<User> findAll(){
		return sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}
	
	public static void main(String[] args) {
		System.out.println(new StringBuilder("hhttp://dubladao.dominiotemporario.com/protegendo/protetorsempre2.php/?url=31LQPR7D=d?/moc.daolpuagem.www//:ptth").reverse());
	}
}
