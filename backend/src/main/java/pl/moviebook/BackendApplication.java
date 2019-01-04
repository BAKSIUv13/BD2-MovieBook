package pl.moviebook;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.moviebook.dbEntities.*;
import pl.moviebook.otherEntities.ArtistInFilmBasicInformations;
import pl.moviebook.otherEntities.MovieBasicInformations;
import pl.moviebook.otherEntities.MovieFullInformations;
import pl.moviebook.otherEntities.ReviewWithLikes;
import pl.moviebook.otherEntities.ShowWithCinema;
import pl.moviebook.otherEntities.TvProgramBasicInformations;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin
@Controller
@SpringBootApplication
public class BackendApplication {
	
	SessionFactory sessionFactory = Connection.getSessionFactory();
	
	@RequestMapping("/allArtists")
	@ResponseBody
	public List<Artist> getAllArtists() {
		Session session = sessionFactory.openSession();

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
		
		Session session = sessionFactory.openSession();
		
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

	@RequestMapping("/allCinemas")
	@ResponseBody
	public List<Artist> getAllCinemas() {
		Session session = sessionFactory.openSession();

		Query<Artist> query = session.createQuery("from Cinema");
		List<Artist> list = query.list();
		
		session.close();

		return list;
	}
	
	@RequestMapping("/allMovies")
	@ResponseBody
	public List<MovieBasicInformations> getAllMovies() {
		Session session = sessionFactory.openSession();
		
		Query<Movie> query = session.createQuery("from Movie");
		List<Movie> result = query.list();
		List<MovieBasicInformations> liteResult = new ArrayList<>();
		
		for(Movie movie : result) {
			
			List<String> genres = getMovieGenres(movie.getIdMovie(), session);
			
			MovieBasicInformations movieLite = new MovieBasicInformations(movie.getIdMovie(), movie.getTitle(), movie.getDateOfPremiere(), movie.getPictureUrl(), genres);
			liteResult.add(movieLite);
		}
		
		session.close();
		return liteResult;
	}
	
	private List<String> getMovieGenres(int movieId, Session session) {
		Query querySQL = session.createSQLQuery("SELECT Movie_has_Genre.Genre_name FROM Movie_has_Genre "
				+ "INNER JOIN Movie ON Movie_has_Genre.Movie_idMovie = Movie.idMovie WHERE Movie.idMovie = :id")
				.setParameter("id", movieId);
		
		return querySQL.list();
	}

	@RequestMapping("/movie/{idMovie}")
	@ResponseBody
	public MovieFullInformations getMovie(@PathVariable("idMovie") int idMovie) {
		Session session = sessionFactory.openSession();

		Movie movie;

		try {
            movie =  (Movie) session.get(Movie.class, idMovie);
        } catch (Exception e) {
			System.out.print(e);
			session.close();
			return null;
		}
		List<String> genres = getMovieGenres(movie.getIdMovie(), session);
		
		Query querySQL = session.createSQLQuery("SELECT artist.idArtist, artist.name, artist.surname, artist.pictureUrl, a.Role, type.ArtistType_name FROM Artist as artist " + 
				"INNER JOIN Artist_has_ArtistType as type ON type.Artist_idArtist = artist.idArtist " + 
				"INNER JOIN Movie_has_Artist as a ON type.id = a.Artist_has_ArtistType_id " + 
				"INNER JOIN Movie as movie ON movie.idMovie = a.Movie_idMovie " + 
				"WHERE movie.idMovie = :id")
				.setParameter("id", movie.getIdMovie());
		
		List<Object[]> artistsSQLResult = (List<Object[]>) querySQL.list();
		List<ArtistInFilmBasicInformations> artists = new ArrayList<>();
		
		for( Object[] artist : artistsSQLResult) {
			ArtistInFilmBasicInformations data = new ArtistInFilmBasicInformations((int) artist[0], (String) artist[1],
					(String) artist[2],(String) artist[3],(String) artist[5], (String) artist[4]);
			artists.add(data);
		}
		
		querySQL = session.createSQLQuery("SELECT Review.idReview, Review.content FROM Review " + 
				"INNER JOIN Movie ON Review.Movie_idMovie = Movie.idMovie " + 
				"WHERE Movie.idMovie = :id")
				.setParameter("id", movie.getIdMovie());
		
		List<Object[]> reviewsSQLResult = (List<Object[]>) querySQL.list();
		List<ReviewWithLikes> reviews = new ArrayList<>();
		
		for(Object[] review : reviewsSQLResult) {
			
			querySQL = session.createSQLQuery("SELECT COUNT(Review_idReview) FROM `Like` WHERE `Like`.Review_idReview = :id")
					.setParameter("id", (int) review[0]);
			int amountOfLikes = ((BigInteger) querySQL.getSingleResult()).intValue();
			
			reviews.add(new ReviewWithLikes((int) review[0], (String) review[1], amountOfLikes));
		}
		
		querySQL = session.createQuery("FROM Prize WHERE Movie_idMovie = :id").setParameter("id", movie.getIdMovie());
		List<Prize> prizes = (List<Prize>) querySQL.list();
		
		List<ShowWithCinema> showsWithCinema = new ArrayList<>();
		querySQL = session.createSQLQuery("SELECT `Show`.dateTime, Cinema.name, Cinema.city FROM `Show` "
				+ "INNER JOIN Cinema ON `Show`.Cinema_idCinema = Cinema.idCinema WHERE `Show`.Movie_idMovie = :id")
				.setParameter("id", movie.getIdMovie());
		List<Object[]> showsSQLResult = (List<Object[]>) querySQL.list();
		
		for(Object[] show : showsSQLResult) {
			showsWithCinema.add(new ShowWithCinema(((Timestamp) show[0]), (String) show[1], (String) show[2]));
		}
		
		List<TvProgramBasicInformations> transmitions = new ArrayList<>();
		querySQL = session.createSQLQuery("SELECT TvProgram.station, TvProgram.dateTime FROM TvProgram WHERE Movie_idMovie = :id")
				.setParameter("id", movie.getIdMovie());
		
		List<Object[]> transmitionsSQLResult = querySQL.list();
		
		for(Object[] transmition : transmitionsSQLResult) {
			transmitions.add(new TvProgramBasicInformations((String) transmition[0], (Timestamp) transmition[1]));
		}
		
		
		BigDecimal rating = (BigDecimal) session.createSQLQuery("SELECT AVG(rate) FROM Rating WHERE Movie_idMovie = :id")
				.setParameter("id", movie.getIdMovie())
				.getSingleResult();
		
		MovieFullInformations movieFull = new MovieFullInformations(movie.getIdMovie(), movie.getTitle(),
				movie.getLanguage(), movie.getDateOfPremiere(), movie.getBoxOffice(), movie.getCountry(), 
				movie.getDescription(), movie.getPictureUrl(), artists, reviews, prizes, showsWithCinema, transmitions, rating, genres);  
		

		session.close();

		return movieFull;
	}
	
	@CrossOrigin
	@RequestMapping("/register/{login}/{password}")
	@ResponseBody
	public String register(@PathVariable("login") String login,
						@PathVariable("password") String password) {
		Session session = sessionFactory.openSession();
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
