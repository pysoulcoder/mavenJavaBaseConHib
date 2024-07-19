package mavenJavaBaseConHib.configuration;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.hibernate.cfg.Environment;

public class JavaConfiguration {
	public static SessionFactory getSessionFactory() {
		Properties ps = new Properties();
		
		ps.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
		ps.put(Environment.URL, "jdbc:mysql://localhost:3306/javaproject1");
		ps.put(Environment.USER, "root");
		ps.put(Environment.PASS, "Yadav@96");
		ps.put(Environment.HBM2DDL_AUTO, "create");
		ps.put(Environment.SHOW_SQL, "true");
		ps.put(Environment.FORMAT_SQL, "true");
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().applySettings(ps).build();
		MetadataSources metadatasource = new MetadataSources(ssr);
		metadatasource.addAnnotatedClass(mavenJavaBaseConHib.entity.Employee.class);
		
		SessionFactory sf = metadatasource.getMetadataBuilder().build().buildSessionFactory();
		
		return sf;
	}
}
