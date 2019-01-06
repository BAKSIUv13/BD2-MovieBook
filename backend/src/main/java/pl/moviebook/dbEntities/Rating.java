package pl.moviebook.dbEntities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Rating")
public class Rating implements Serializable {

	private static final long serialVersionUID = 60120191L;

    @Id
	@Column(name="User_login")
	private String User_login;
    
    @Id
	@Column(name="Movie_idMovie")
    private int Movie_idMovie;

    @Column(name="rate")
    private int rate;

    /**
     * @return the user_login
     */
    public String getUser_login() {
        return User_login;
    }

    /**
     * @param user_login the user_login to set
     */
    public void setUser_login(String user_login) {
        User_login = user_login;
    }

    /**
     * @return the movie_idMovie
     */
    public int getMovie_idMovie() {
        return Movie_idMovie;
    }

    /**
     * @param movie_idMovie the movie_idMovie to set
     */
    public void setMovie_idMovie(int movie_idMovie) {
        Movie_idMovie = movie_idMovie;
    }

    /**
     * @return the rate
     */
    public int getRate() {
        return rate;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(int rate) {
        this.rate = rate;
    }
}
