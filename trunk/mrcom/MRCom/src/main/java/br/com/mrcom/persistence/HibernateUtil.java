package br.com.mrcom.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Environment;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {
		sessionFactory = new AnnotationConfiguration()
		.setProperty(Environment.DIALECT, "org.hibernate.dialect.Oracle10gDialect")
		.setProperty(Environment.DRIVER, "oracle.jdbc.driver.OracleDriver")
		
		.setProperty(Environment.URL,"jdbc:oracle:thin:@localhost:1521:xe")
		
		.setProperty(Environment.USER, "apphibernate")
		.setProperty(Environment.PASS, "apphibernate")
		.setProperty(Environment.SHOW_SQL, "true")
//		.setProperty(Environment.SHOW_SQL, "false")
		.setProperty(Environment.FORMAT_SQL, "true")
		//para corrigir o problema do  No CurrentSessionContext configured!
		.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread")
		

		.buildSessionFactory();
	}

	public static SessionFactory getSessionFactory(){

		return sessionFactory;
	}
}
