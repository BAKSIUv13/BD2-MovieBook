package pl.moviebook.dbEntities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`29209262_bd2`.`Show`")
public class Show implements Serializable {

	private static final long serialVersionUID = 190120191L;

	@Id
	@Column(name="idShow")
	private int idShow;
	
	@Column(name="dateTime")
	private Timestamp dateTime;
    
    @Column(name="Cinema_idCinema")
    private int Cinema_idCinema;
    
    @Column(name="Movie_idMovie")
    private int Movie_idMovie;

    /**
     * @return the idShow
     */
    public int getIdShow() {
        return idShow;
    }

    /**
     * @param idShow the idShow to set
     */
    public void setIdShow(int idShow) {
        this.idShow = idShow;
    }

    /**
     * @return the dateTime
     */
    public Timestamp getDateTime() {
        return dateTime;
    }

    /**
     * @param dateTime the dateTime to set
     */
    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * @return the cinema_idCinema
     */
    public int getCinema_idCinema() {
        return Cinema_idCinema;
    }

    /**
     * @param cinema_idCinema the cinema_idCinema to set
     */
    public void setCinema_idCinema(int cinema_idCinema) {
        Cinema_idCinema = cinema_idCinema;
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

}
