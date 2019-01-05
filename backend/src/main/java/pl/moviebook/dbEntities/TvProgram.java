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
	
	@Column(name="station")
	private String station;
	
	@Column(name="dateTime")
	private Timestamp dateTime;
	
	@Column(name="Movie_idMovie")
	private int idMovie;
	
}
