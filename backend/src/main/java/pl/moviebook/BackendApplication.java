package pl.moviebook;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Controller
@SpringBootApplication
public class BackendApplication {

	@RequestMapping("/")
	@ResponseBody
	String home() {
    	
			SessionFactory sessionFactory;
			Configuration con = new Configuration().configure("hibernate.cfg.xml");
			sessionFactory = con.buildSessionFactory();	
			System.out.println("DB context created");
			Session ses = sessionFactory.openSession();
    	
			int result = (int) ses.createNativeQuery("SELECT idCinema FROM  `Cinema`").getSingleResult();
			
		return Integer.toString(result);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}



