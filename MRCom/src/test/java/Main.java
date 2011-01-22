
import org.hibernate.Session;

import br.com.mrcom.domain.bean.Cfop;
import br.com.mrcom.persistence.HibernateUtil;


public class Main {

	public static void main(String[] args) {
		
	
		System.out.println("Main.main()1");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(new Cfop(3,"Marcio Robson"));
		session.getTransaction().commit();
		
		
		System.out.println("Main.main()2");
		
	}
}
