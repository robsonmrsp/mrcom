package com.teste.veiculo;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.orm.hibernate3.HibernateTransactionManager;

import com.springteste.interfaces.GreetingService;

public class Main {
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("resource/beans-app.xml"));
		Oficina oficina = (Oficina) factory.getBean("oficina");
		Engrenagem e = oficina.getCarro().getCaixaMarcha().getEngrenagem(); 
		
		System.out.println(e.getRangendo());
//		HibernateTransactionManager
	}
}
