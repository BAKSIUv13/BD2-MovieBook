package pl.moviebook;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.query.Query;
import org.hibernate.Session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.moviebook.entities.Artist;
import pl.moviebook.entities.User;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin
@Controller
@SpringBootApplication
public class BackendApplication {
	
	@RequestMapping("/allArtists")
	@ResponseBody
	public List<Artist> getAllArtists() {
		
		Session session = Connection.getSession();
		Query<Artist> query = session.createQuery("from Artist");
		List<Artist> list = query.list();
		session.close();
		return list;
	}
	
	@CrossOrigin
	@RequestMapping("/login/{login}/{password}")
	@ResponseBody
	public String login(@PathVariable("login") String login,
						@PathVariable("password") String password) {
		
		Session session = Connection.getSession();
		Query query = session.createSQLQuery("SELECT UserType_name FROM User WHERE login = :login AND password = :password")
				.setParameter("login", login)
				.setParameter("password", password);
		
		String userTypeResult;
		
		try {
			userTypeResult = (String) query.getSingleResult();
		} catch (Exception e) {
			System.out.print(e);
			userTypeResult = null;
		}
		session.close();
		
		return userTypeResult;
	}
	
	@CrossOrigin
	@RequestMapping("/register/{login}/{password}")
	@ResponseBody
	public String register(@PathVariable("login") String login,
						@PathVariable("password") String password) {
		Session session = Connection.getSession();
		session.beginTransaction();
		User user = new User();
		user.setLogin(login);
		user.setPassword(password);
		user.setUserType("User");
		session.save(user);
		try{
			session.getTransaction().commit();
		} catch(Exception e) {
			session.close();
			return "Unsuccessful";
		}
		session.close();
		return "Successful";
		
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}



