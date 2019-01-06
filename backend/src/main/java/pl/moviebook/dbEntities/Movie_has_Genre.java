package pl.moviebook.dbEntities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Movie_has_Genre")
public class Movie_has_Genre implements Serializable {

	private static final long serialVersionUID = 60120192L;

    @Id
	@Column(name="Movie_idMovie")
    private int Movie_idMovie;
    
    @Id
	@Column(name="Genre_name")
    private String Genre_name;

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
     * @return the genre_name
     */
    public String getGenre_name() {
        return Genre_name;
    }

    /**
     * @param genre_name the genre_name to set
     */
    public void setGenre_name(String genre_name) {
        Genre_name = genre_name;
    }
}
