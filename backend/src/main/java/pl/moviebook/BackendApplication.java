package pl.moviebook;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Calendar;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import pl.moviebook.dbEntities.*;
import pl.moviebook.otherEntities.*;

@CrossOrigin
@Controller
@SpringBootApplication
public class BackendApplication {

    SessionFactory sessionFactory = Connection.getSessionFactory();

    private Date getDateRiGCZFormat(int year, int month, int day)
	{
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DAY_OF_MONTH, day);

		return new Date(cal.getTime().getTime());
	}
	private Date getDateTimeRiGCZFormat(int year, int month, int day, int hour, int minute, int second)
	{
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DAY_OF_MONTH, day);

		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, minute);
		cal.set(Calendar.SECOND, second);

		return new Date(cal.getTime().getTime());
	}

    @CrossOrigin
    @RequestMapping("/addToWatch/{Movie_idMovie}/{User_login}")
    @ResponseBody
    public String addToWatch(@PathVariable("Movie_idMovie") int idMovie,
                        @PathVariable("User_login") String User_login) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        ToWatch towatch = new ToWatch();
        towatch.setMovie_idMovie(idMovie);
        towatch.setUser_login(User_login);
        session.save(towatch);
        try{
            session.getTransaction().commit();
        } catch(Exception e) {
            session.close();
            return "Unsuccessful";
        }
        session.close();
        return "Successful";
    }

    @CrossOrigin
    @RequestMapping("/removeToWatch/{Movie_idMovie}/{User_login}")
    @ResponseBody
    public String removeToWatch(@PathVariable("Movie_idMovie") int idMovie,
                        @PathVariable("User_login") String User_login) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        ToWatch towatch = new ToWatch();
        towatch.setMovie_idMovie(idMovie);
        towatch.setUser_login(User_login);
        session.delete(towatch);
        try{
            session.getTransaction().commit();
        } catch(Exception e) {
            session.close();
            return "Unsuccessful";
        }
        session.close();
        return "Successful";


    }

    @CrossOrigin
    @RequestMapping("/addIssue/{Movie_idMovie}/{User_login}/{description}")
    @ResponseBody
    public String addIssue(@PathVariable("Movie_idMovie") int idMovie,
                        @PathVariable("User_login") String User_login,
                        @PathVariable("description") String description) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Issue issue = new Issue();
        issue.setIdMovie(idMovie);
        issue.setLogin(User_login);
        java.util.Date utilDate= new java.util.Date();
        issue.setIssueDateTime(new java.sql.Timestamp(utilDate.getTime()));
        issue.setDescription(description);
        session.save(issue);
        try{
            session.getTransaction().commit();
        } catch(Exception e) {
            session.close();
            return "Unsuccessful<br />" + e.getMessage();
        }
        session.close();
        return "Successful";


    }
    
    @CrossOrigin
    @RequestMapping("/getFilmsToWatch/{login}")
    @ResponseBody
    public List<MovieBasicInformations> getFilmsToWatch(@PathVariable("login") String login) {
        Session session = sessionFactory.openSession();
        Query query = session.createSQLQuery("SELECT ToWatch.Movie_idMovie From ToWatch WHERE ToWatch.User_login = :login")
                .setParameter("login", login);
        
        List<Integer> filmsIds = query.list();
        List<MovieBasicInformations> filmsToWatch = new ArrayList<>();
        
        for(Integer id : filmsIds) {
            List<String> genres = getMovieGenres(id, session);
            query = session.createSQLQuery("SELECT Movie.title, Movie.dateOfPremiere, Movie.pictureUrl From Movie WHERE Movie.idMovie = :id")
                    .setParameter("id", id);
            Object[] result = (Object[]) query.getSingleResult();
            filmsToWatch.add(new MovieBasicInformations(id, (String) result[0], (Date) result[1], (String) result[2], genres));
        }
        
        return filmsToWatch;
    }


    @CrossOrigin
    @RequestMapping("/addReview/{Movie_idMovie}/{User_login}/{content}")
    @ResponseBody
    public String addReview(@PathVariable("Movie_idMovie") int idMovie,
                        @PathVariable("User_login") String User_login,
                        @PathVariable("content") String content) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Review review = new Review();
        review.setIdMovie(idMovie);
        review.setLogin(User_login);
        review.setContent(content);
        java.util.Date utilDate= new java.util.Date();
        review.setDate(new java.sql.Date(utilDate.getTime()));
        session.save(review);
        try{
            session.getTransaction().commit();
        } catch(Exception e) {
            session.close();
            return "Unsuccessful";
        }
        session.close();
        return "Successful";

    }

    @CrossOrigin
    @RequestMapping("/allArtists")
    @ResponseBody
    public List<Artist> getAllArtists() {
        Session session = sessionFactory.openSession();

        // HQL syntax - createQuery
        // SQL syntax - createSQLQery
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

        Query query = session.createSQLQuery(
            "SELECT UserType_name FROM User " +
            "WHERE login = :login AND password = :password")
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
    
    @RequestMapping("/allStations")
    @ResponseBody
    public List<Station> getAllStations() {
        Session session = sessionFactory.openSession();

        Query<Station> query = session.createQuery("from Station");
        List<Station> list = query.list();
        
        session.close();

        return list;
    }
    
    @CrossOrigin
    @RequestMapping("/getTransmitions/{station}")
    @ResponseBody
    public List<TransmitionOnStation> getTransmitionOnStation(@PathVariable("station") String station) {
        Session session = sessionFactory.openSession();
        
        List<TransmitionOnStation> transmitions = new ArrayList<>();
        Query querySQL = session.createSQLQuery("SELECT TvProgram.dateTime, Movie.title, Movie.idMovie FROM TvProgram "
                + "INNER JOIN Movie ON TvProgram.Movie_idMovie = Movie.idMovie WHERE TvProgram.Station_name = :id "
                + "GROUP BY TvProgram.dateTime ASC")
                .setParameter("id", station);
        List<Object[]> transmitionsSQLResult = (List<Object[]>) querySQL.list();
        
        for(Object[] transmition : transmitionsSQLResult) {
            transmitions.add(new TransmitionOnStation((((Timestamp) transmition[0]).getTime()), (String) transmition[1], (int) transmition[2]));
        }
        
        return transmitions;
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
    
    @RequestMapping("/getShows/{idCinema}")
    @ResponseBody
    public List<FilmInCinema> getFilmInCinema(@PathVariable("idCinema") int idCinema) {
        Session session = sessionFactory.openSession();
        
        List<FilmInCinema> filmsInCinema = new ArrayList<>();
        Query querySQL = session.createSQLQuery("SELECT `Show`.dateTime, Movie.title, Movie.idMovie FROM `Show` "
                + "INNER JOIN Movie ON `Show`.Movie_idMovie = Movie.idMovie WHERE `Show`.Cinema_idCinema = :id "
                + "GROUP BY `Show`.dateTime ASC")
                .setParameter("id", idCinema);
        List<Object[]> showsSQLResult = (List<Object[]>) querySQL.list();
        
        for(Object[] show : showsSQLResult) {
            filmsInCinema.add(new FilmInCinema((((Timestamp) show[0]).getTime()), (String) show[1], (int) show[2]));
        }
        
        return filmsInCinema;
    }
    
    @RequestMapping("/getCinemaName/{idCinema}")
    @ResponseBody
    public String getCinemaName(@PathVariable("idCinema") int idCinema) {
        Session session = sessionFactory.openSession();
        
        Query querySQL = session.createSQLQuery("SELECT Cinema.name, Cinema.city FROM Cinema WHERE Cinema.idCinema = :id")
                .setParameter("id", idCinema);
        
        Object[] cinemaSQLResult = (Object[]) querySQL.getSingleResult();
        
        return (String) cinemaSQLResult[0] + " " + (String) cinemaSQLResult[1];
        
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
            
            MovieBasicInformations movieLite = new MovieBasicInformations(
                movie.getIdMovie(), movie.getTitle(), movie.getDateOfPremiere(), 
                movie.getPictureUrl(), genres);
            liteResult.add(movieLite);
        }
        
        session.close();
        return liteResult;
    }
    
    private List<String> getMovieGenres(int movieId, Session session) {
        Query querySQL = session.createSQLQuery(
            "SELECT Movie_has_Genre.Genre_name FROM Movie_has_Genre "
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
        
        querySQL = session.createSQLQuery("SELECT Review.idReview, Review.content, Review.User_login FROM Review " + 
                "WHERE Review.Movie_idMovie = :id")
                .setParameter("id", movie.getIdMovie());
        
        List<Object[]> reviewsSQLResult = (List<Object[]>) querySQL.list();
        List<ReviewWithLikes> reviews = new ArrayList<>();
        
        for(Object[] review : reviewsSQLResult) {
            
            querySQL = session.createSQLQuery("SELECT COUNT(Review_idReview) FROM `Like` WHERE `Like`.Review_idReview = :id")
                    .setParameter("id", (int) review[0]);
            int amountOfLikes = ((BigInteger) querySQL.getSingleResult()).intValue();
            
            reviews.add(new ReviewWithLikes((int) review[0], (String) review[1], amountOfLikes, (String) review[2] ));
        }
        
        querySQL = session.createQuery("FROM Prize WHERE Movie_idMovie = :id").setParameter("id", movie.getIdMovie());
        List<Prize> prizes = (List<Prize>) querySQL.list();
        
        List<ShowWithCinema> showsWithCinema = new ArrayList<>();
        querySQL = session.createSQLQuery("SELECT `Show`.dateTime, Cinema.name, Cinema.city FROM `Show` "
                + "INNER JOIN Cinema ON `Show`.Cinema_idCinema = Cinema.idCinema WHERE `Show`.Movie_idMovie = :id")
                .setParameter("id", movie.getIdMovie());
        List<Object[]> showsSQLResult = (List<Object[]>) querySQL.list();
        
        for(Object[] show : showsSQLResult) {
            showsWithCinema.add(new ShowWithCinema(((Timestamp) show[0]).getTime(), (String) show[1], (String) show[2]));
        }
        
        List<TvProgramBasicInformations> transmitions = new ArrayList<>();
        querySQL = session.createSQLQuery("SELECT TvProgram.Station_name, TvProgram.dateTime FROM TvProgram WHERE Movie_idMovie = :id")
                .setParameter("id", movie.getIdMovie());
        
        List<Object[]> transmitionsSQLResult = querySQL.list();
        
        for(Object[] transmition : transmitionsSQLResult) {
            transmitions.add(new TvProgramBasicInformations((String) transmition[0], ((Timestamp) transmition[1]).getTime()));
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

    @CrossOrigin
    @RequestMapping("/changeRating/{User_login}/{Movie_idMovie}/{rate}")
    @ResponseBody
    public String changeRating(
        @PathVariable("User_login") String User_login, 
        @PathVariable("Movie_idMovie") int Movie_idMovie,
        @PathVariable("rate") int rate) {
        
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Rating rating = new Rating();
        rating.setUser_login(User_login);
        rating.setMovie_idMovie(Movie_idMovie);
        rating.setRate(rate);
        java.util.Date utilDate= new java.util.Date();
        rating.setDate(new java.sql.Date(utilDate.getTime()));

        session.saveOrUpdate(rating);
        try{
            session.getTransaction().commit();
        } catch(Exception e) {
            session.close();
            return "Unsuccessful";
        }
        
        session.close();
        
        return "Successful";
    }

    @CrossOrigin
    @RequestMapping("/allMoviesOfTheGenre/{name}")
    @ResponseBody
    public List<MovieBasicInformations> getAllMoviesOfTheGenre(
        @PathVariable("name") String name) {
        
        Session session = sessionFactory.openSession();
    
        Query query = session.createQuery(
            "select movie " + 
            "from Movie as movie, Movie_has_Genre as movie_has_Genre " + 
            "where movie.idMovie = movie_has_Genre.Movie_idMovie " + 
            "and movie_has_Genre.Genre_name = :name"
        ).setParameter("name", name);

        List<Movie> movies = query.list();

        List<MovieBasicInformations> basicMovies = new ArrayList<>();
        for(Movie movie : movies) {
            
            List<String> genres = getMovieGenres(movie.getIdMovie(), session);
            
            MovieBasicInformations movieLite = new MovieBasicInformations(
                movie.getIdMovie(), movie.getTitle(), movie.getDateOfPremiere(), 
                movie.getPictureUrl(), genres);
            basicMovies.add(movieLite);
        }
        
        session.close();
        return basicMovies;
    }

    @CrossOrigin
    @RequestMapping("/addMovie/{title}/{language}/" +
                    "{dayOfPremiere}/{monthOfPremiere}/{yearOfPremiere}/" +
                    "{boxOffice}/{country}/{description}/{pictureUrl}")
    @ResponseBody
    public String addMovie(
        @PathVariable("title") String title,
        @PathVariable("language") String language,
        @PathVariable("dayOfPremiere") int dayOfPremiere,
        @PathVariable("monthOfPremiere") int monthOfPremiere,
        @PathVariable("yearOfPremiere") int yearOfPremiere,
        @PathVariable("boxOffice") int boxOffice,
        @PathVariable("country") String country,
        @PathVariable("description") String description,
        @PathVariable("pictureUrl") String pictureUrl) {
            
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Movie movie = new Movie();

        movie.setTitle(title);
        movie.setLanguage(language);
        movie.setDateOfPremiere(getDateRiGCZFormat(yearOfPremiere, 
            monthOfPremiere, dayOfPremiere));
        movie.setBoxOffice(boxOffice);
        movie.setCountry(country);
        movie.setDescription(description);
        movie.setPictureUrl(pictureUrl);
            
        session.save(movie);
        try{
            session.getTransaction().commit();
        } catch(Exception e) {
            session.close();
            return "Unsuccessful";
        }
        
        session.close();
        
        return "Successful";

    }

    @CrossOrigin
    @RequestMapping("/addLikeToReview/{Review_idReview}/{User_login}")
    @ResponseBody
    public String addLikeToReview(
        @PathVariable("Review_idReview") int Review_idReview,
        @PathVariable("User_login") String User_login) {
        
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();
        
        Like like = new Like();
        like.setReview_idReview(Review_idReview);
        like.setUser_login(User_login);
        java.util.Date utilDate= new java.util.Date();
        like.setDate(new java.sql.Date(utilDate.getTime()));

        session.saveOrUpdate(like);
        try{
        session.getTransaction().commit();
        } catch(Exception e) {
        session.close();
        return "Unsuccessful";
        }
        
        session.close();
        
        return "Successful";
    }

    @CrossOrigin
    @RequestMapping("/removeLikeFromReview/{Review_idReview}/{User_login}")
    @ResponseBody
    public String removeLikeFromReview(
        @PathVariable("Review_idReview") int Review_idReview,
        @PathVariable("User_login") String User_login) {
        
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();
        
        Like like = new Like();
        like.setReview_idReview(Review_idReview);
        like.setUser_login(User_login);

        session.remove(like);
        try{
        session.getTransaction().commit();
        } catch(Exception e) {
        session.close();
        return "Unsuccessful";
        }
        
        session.close();
        
        return "Successful";
    }

    @CrossOrigin
    @RequestMapping("/getToWatchList/{User_login}")
    @ResponseBody
    public List<MovieBasicInformations> getToWatchList(
        @PathVariable("User_login") String User_login) {
        
        Session session = sessionFactory.openSession();
    
            
        Query query = session.createQuery(
            "select movie " + 
            "from Movie as movie, ToWatch as toWatch " + 
            "where :User_login = toWatch.User_login " + 
            "and movie.idMovie = toWatch.Movie_idMovie "
        ).setParameter("User_login", User_login);

        List<Movie> movies = query.list();

        List<MovieBasicInformations> basicMovies = new ArrayList<>();
        for(Movie movie : movies) {
            
            List<String> genres = getMovieGenres(movie.getIdMovie(), session);
            
            MovieBasicInformations movieLite = new MovieBasicInformations(
                movie.getIdMovie(), movie.getTitle(), movie.getDateOfPremiere(), 
                movie.getPictureUrl(), genres);
            basicMovies.add(movieLite);
        }
        
        session.close();
        return basicMovies;
    }

    @CrossOrigin
    @RequestMapping("/allBasicArtists")
    @ResponseBody
    public List<BasicArtist> getAllBasicArtists() {
        Session session = sessionFactory.openSession();

        Query<Artist> query = session.createQuery("from Artist");
        List<Artist> list = query.list();
        session.close();

        List<BasicArtist> basicArtists = new ArrayList<>();

        for (Artist artist : list) {
            BasicArtist basicArtist = new BasicArtist();
            basicArtist.setId(artist.getId());
            basicArtist.setName(artist.getName());
            basicArtist.setSurname(artist.getSurname());
            basicArtist.setPictureUrl(artist.getPictureUrl());

            basicArtists.add(basicArtist);
        }


        return basicArtists;
    }
       
    @CrossOrigin
    @RequestMapping("/getArtist/{idArtist}")
    @ResponseBody
    public ArtistFullInformations getArtist(
        @PathVariable("idArtist") int idArtist) {
        
    	Session session = sessionFactory.openSession();
    	
        Artist artist;

        try {
            artist =  (Artist) session.get(Artist.class, idArtist);
        } catch (Exception e) {
            System.out.print(e);
            session.close();
            return null;
        }
        
        Query query = session.createSQLQuery("SELECT ArtistType_name FROM Artist_has_ArtistType "
        		+ "WHERE Artist_idArtist = :id")
        		.setParameter("id", idArtist);
        
        List<String> types = query.list();
        
        query = session.createQuery("FROM Prize WHERE Artist_idArtist = :id").setParameter("id", idArtist);
        List<Prize> prizes = (List<Prize>) query.list();
        
        List<ArtistTypeAndFilms> typeAndFilms = new ArrayList<>();
        
        for( String type : types) {
        	List<MovieBasicInformations> movies = new ArrayList<>();
        	
        	query = session.createSQLQuery("SELECT film.idMovie, film.title, film.dateOfPremiere, film.pictureUrl FROM Artist_has_ArtistType as type \n" + 
        			"INNER JOIN Movie_has_Artist as a ON type.id = a.Artist_has_ArtistType_id\n" + 
        			"INNER JOIN Movie as film ON a.Movie_idMovie = film.idMovie\n" + 
        			"WHERE type.Artist_idArtist = :id AND type.Artisttype_name = :type")
        			.setParameter("id", idArtist)
        			.setParameter("type", type);
            List<Object[]> result = query.list();
            
            for(Object[] data : result) {
            	List<String> genres = getMovieGenres((int) data[0], session);
                movies.add( new MovieBasicInformations((int) data[0], (String) data[1], (Date) data[2],
                		(String) data[3], genres));
            }
            
            typeAndFilms.add(new ArtistTypeAndFilms(type, movies));
        }
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        
        return new ArtistFullInformations(artist.getId(), artist.getSurname(), artist.getName(),
        		artist.getOrigin(), df.format(artist.getDate()), artist.getPictureUrl(), types, prizes, typeAndFilms);
    	
    
    }
    
    // ok
    @CrossOrigin
    @RequestMapping("/updateShow/{idShow}/{day}/{month}/{year}/"
                    + "{Cinema_idCinema}/{Movie_idMovie}")
    @ResponseBody
    public String updateShow(
        @PathVariable("idShow") int idShow,
        @PathVariable("day") int day,
        @PathVariable("month") int month,
        @PathVariable("year") int year,
        @PathVariable("Cinema_idCinema") int Cinema_idCinema,
        @PathVariable("Movie_idMovie") int Movie_idMovie) {
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        Show show = new Show();
        show.setIdShow(idShow);
        show.setDateTime(getDateRiGCZFormat(year, month, day));
        show.setCinema_idCinema(Cinema_idCinema);
        show.setMovie_idMovie(Movie_idMovie);

        session.saveOrUpdate(show);
        try{
            session.getTransaction().commit();
        } catch(Exception e) {
            session.close();
            return "Unsuccessful";
        }
        session.close();
        
        return "Successful";
    }
    
    // not idArtist because of autoincrement
    @CrossOrigin
    @RequestMapping("/addArtist/{name}/{surname}/{origin}"
                    + "/{dayOfBirth}/{monthOfBirth}/{yearOfBirth}/{pictureUrl}")
    @ResponseBody
    public String addArtist(
        @PathVariable("name") String name,
        @PathVariable("surname") String surname,
        @PathVariable("origin") String origin,
        @PathVariable("dayOfBirth") int dayOfBirth,
        @PathVariable("monthOfBirth") int monthOfBirth,
        @PathVariable("yearOfBirth") int yearOfBirth,
        @PathVariable("pictureUrl") String pictureUrl) {
        
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();
        
        Artist artist = new Artist();
        artist.setName(name);
        artist.setSurname(surname);
        artist.setOrigin(origin);
        artist.setDate(getDateRiGCZFormat(yearOfBirth, 
                                          monthOfBirth, 
                                          dayOfBirth));
        artist.setPictureUrl(pictureUrl);

        session.saveOrUpdate(artist);
        try{
            session.getTransaction().commit();
        } catch(Exception e) {
            session.close();
            return "Unsuccessful";
        }
        session.close();
        
        return "Successful";
    }
    
    
    @RequestMapping("/addShow/{day}/{month}/{year}/"
                + "{Cinema_idCinema}/{Movie_idMovie}")
    @ResponseBody
    public String addShow(
        @PathVariable("day") int day,
        @PathVariable("month") int month,
        @PathVariable("year") int year,
        @PathVariable("Cinema_idCinema") int Cinema_idCinema,
        @PathVariable("Movie_idMovie") int Movie_idMovie) {
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        Show show = new Show();
        show.setDateTime(getDateRiGCZFormat(year, month, day));
        show.setCinema_idCinema(Cinema_idCinema);
        show.setMovie_idMovie(Movie_idMovie);

        session.save(show);
        try{
            session.getTransaction().commit();
        } catch(Exception e) {
            session.close();
            return "Unsuccessful";
        }
        session.close();
        
        return "Successful";
    }

    @RequestMapping(value = "/updateArtist/{idArtist}/{name}/{surname}/{origin}"
                    + "/{date}/{pictureUrl}")
    @ResponseBody
    public String addArtist(
        @PathVariable("idArtist") int idArtist,
        @PathVariable("name") String name,
        @PathVariable("surname") String surname,
        @PathVariable("origin") String origin,
        @PathVariable("date") String date,
        @PathVariable("pictureUrl") String pictureUrl) {
        
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();
        
        String changedUrl = pictureUrl.replace("_", "%");
        
        Artist artist = new Artist();
        if(idArtist >= 0)
        	artist.setIdArtist(idArtist);
        
        artist.setName(name);
        artist.setSurname(surname);
        artist.setOrigin(origin);
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
			artist.setDate(new Date(df.parse(date).getTime()));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

        try {
			artist.setPictureUrl(URLDecoder.decode(changedUrl, "UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

        session.saveOrUpdate(artist);

        try{
            session.getTransaction().commit();
        } catch(Exception e) {
            session.close();
            return "Unsuccessful";
        }
        session.close();
        
        return "Successful";
    }
    
    @CrossOrigin
    @RequestMapping("/updateMovie/{idMovie}/{title}/{language}/" +
                    "{dayOfPremiere}/{monthOfPremiere}/{yearOfPremiere}/" +
                    "{boxOffice}/{country}/{description}/{pictureUrl}")
    @ResponseBody
    public String updateMovie(
        @PathVariable("idMovie") int idMovie,
        @PathVariable("title") String title,
        @PathVariable("language") String language,
        @PathVariable("dayOfPremiere") int dayOfPremiere,
        @PathVariable("monthOfPremiere") int monthOfPremiere,
        @PathVariable("yearOfPremiere") int yearOfPremiere,
        @PathVariable("boxOffice") int boxOffice,
        @PathVariable("country") String country,
        @PathVariable("description") String description,
        @PathVariable("pictureUrl") String pictureUrl) {
            
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Movie movie = new Movie();
        
        movie.setIdMovie(idMovie);
        movie.setTitle(title);
        movie.setLanguage(language);
        movie.setDateOfPremiere(getDateRiGCZFormat(yearOfPremiere, 
            monthOfPremiere, dayOfPremiere));
        movie.setBoxOffice(boxOffice);
        movie.setCountry(country);
        movie.setDescription(description);
        movie.setPictureUrl(pictureUrl);
            
        session.saveOrUpdate(movie);
        try{
            session.getTransaction().commit();
        } catch(Exception e) {
            session.close();
            return "Unsuccessful";
        }
        
        session.close();
        
        return "Successful";

    }
    
    @CrossOrigin
    @RequestMapping("/removeReview/{idReview}")
    @ResponseBody
    public String addReview(
        @PathVariable("idReview") int idReview){
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        Review review = new Review();
        review.setIdReview(idReview);
        session.remove(review);
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
