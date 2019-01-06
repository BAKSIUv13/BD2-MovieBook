package pl.moviebook;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Connection {
	
	public static SessionFactory getSessionFactory() { 
		Configuration configuration = new Configuration()
									      .configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		return sessionFactory;
	}
}
