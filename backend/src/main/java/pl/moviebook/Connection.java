package pl.moviebook;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Connection {
	
	private SessionFactory sessionFactory;
	private Date lastConnection;
	
	public Connection() {
		lastConnection = new Date();
		sessionFactory = getSessionFactory();
	}
	
	public SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration()
			      .configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		return sessionFactory;
	}
	
	public Session openSession() {
		Date actualDate = new Date();
		long seconds = (actualDate.getTime() - lastConnection.getTime())/1000;
		if(seconds >= 110)
			sessionFactory = getSessionFactory();
		lastConnection = new Date();
		Session session = sessionFactory.openSession();
		return session;
	}
}
