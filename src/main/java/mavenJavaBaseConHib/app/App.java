package mavenJavaBaseConHib.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import mavenJavaBaseConHib.configuration.JavaConfiguration;
import mavenJavaBaseConHib.entity.Employee;

public class App {

	public static void main(String[] args) {
		Employee pa = new Employee(1,"anu","female",25000);
		
		SessionFactory sessionfactory = JavaConfiguration.getSessionFactory();
		Session session = sessionfactory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.persist(pa);
		tx.commit();
		session.close();
	}

}
