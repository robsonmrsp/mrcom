package com.gis.server.persist;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Environment;

import com.gis.server.beans.User;

public class HibernateUtil {

	public static SessionFactory sessionFactory ;
	static {
		sessionFactory = new AnnotationConfiguration()
		
		.setProperty(Environment.DIALECT, "org.hibernatespatial.postgis.PostgisDialect")
		.setProperty(Environment.DRIVER, "org.postgresql.Driver")

		.setProperty(Environment.URL,"jdbc:postgresql://localhost:5432/postgis")

		.setProperty(Environment.USER, "postgres")
		.setProperty(Environment.PASS, "robson78")
		.setProperty(Environment.SHOW_SQL, "true")
		.setProperty(Environment.FORMAT_SQL, "true")
		.setProperty(Environment.HBM2DDL_AUTO, "create")

		//para corrigir o problema do  No CurrentSessionContext configured!
		.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread")

		.addAnnotatedClass(User.class)
		.buildSessionFactory();
	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	public static Session getSession(){
		return getSessionFactory().openSession();
	}

}
