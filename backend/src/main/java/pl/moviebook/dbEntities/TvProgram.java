package pl.moviebook.dbEntities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TvProgram")
public class TvProgram implements Serializable {

	private static final long serialVersionUID = -1989492899512090951L;

	@Id
	@Column(name="idTvProgram")
	private int idTvProgram;
	
	@Column(name="Station_name")
	private String station;
	
	@Column(name="dateTime")
	private Timestamp dateTime;
	
	@Column(name="Movie_idMovie")
	private int idMovie;

	/**
	 * @return the idTvProgram
	 */
	public int getIdTvProgram() {
		return idTvProgram;
	}

	/**
	 * @param idTvProgram the idTvProgram to set
	 */
	public void setIdTvProgram(int idTvProgram) {
		this.idTvProgram = idTvProgram;
	}

	/**
	 * @return the station
	 */
	public String getStation() {
		return station;
	}

	/**
	 * @param station the station to set
	 */
	public void setStation(String station) {
		this.station = station;
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
	 * @return the idMovie
	 */
	public int getIdMovie() {
		return idMovie;
	}

	/**
	 * @param idMovie the idMovie to set
	 */
	public void setIdMovie(int idMovie) {
		this.idMovie = idMovie;
	}
	
}
