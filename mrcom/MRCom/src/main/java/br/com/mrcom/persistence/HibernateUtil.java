package br.com.mrcom.persistence;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Environment;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {
		sessionFactory = new AnnotationConfiguration()

		.setProperty(Environment.DIALECT, org.hibernate.dialect.PostgreSQLDialect.class.getCanonicalName())
		.setProperty(Environment.DRIVER, org.postgresql.Driver.class.getCanonicalName())
		
		.setProperty(Environment.URL,"jdbc:postgresql://localhost:5432/mrcom")
		.setProperty(Environment.USER, "postgres")
		.setProperty(Environment.PASS, "robson78")
		.setProperty(Environment.SHOW_SQL, "true")
		.setProperty(Environment.FORMAT_SQL, "true")
		.setProperty(Environment.HBM2DDL_AUTO, "update")
		//para corrigir o problema do  No CurrentSessionContext configured!d
		.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread")
		.addAnnotatedClass(br.com.mrcom.domain.bean.Bairro.class)
		.addAnnotatedClass(br.com.mrcom.domain.bean.Cfop.class)
		.addAnnotatedClass(br.com.mrcom.domain.bean.Cidade.class)
		.addAnnotatedClass(br.com.mrcom.domain.bean.Cliente.class)
		.addAnnotatedClass(br.com.mrcom.domain.bean.Endereco.class)
		.addAnnotatedClass(br.com.mrcom.domain.bean.Estado.class)
		
		.buildSessionFactory();

	}

	public static SessionFactory getSessionFactory(){

		return sessionFactory;
	}
}
