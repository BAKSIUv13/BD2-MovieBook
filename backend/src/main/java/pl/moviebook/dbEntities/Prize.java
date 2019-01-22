package pl.moviebook.dbEntities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Prize")
public class Prize implements Serializable {

	private static final long serialVersionUID = -6855473353113894342L;

	@Id
	@Column(name="idPrize")
	private int idPrize;
	
	@Column(name="name")
	private String prizeName;
	
	@Column(name="whatFor")
	private String whatFor;
	
	@Column(name="date")
	private int date;
	
	@Column(name="Artist_idArtist")
	private Integer idArtist;
	
	@Column(name="Movie_idMovie")
	private Integer idMovie;

	public int getIdPrize() {
		return idPrize;
	}

	public void setIdPrize(int idPrize) {
		this.idPrize = idPrize;
	}

	public String getPrizeName() {
		return prizeName;
	}

	public void setPrizeName(String prizeName) {
		this.prizeName = prizeName;
	}

	public String getWhatFor() {
		return whatFor;
	}

	public void setWhatFor(String whatFor) {
		this.whatFor = whatFor;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public Integer getIdArtist() {
		return idArtist;
	}

	public void setIdArtist(Integer idArtist) {
		this.idArtist = idArtist;
	}

	public Integer getIdMovie() {
		return idMovie;
	}

	public void setIdMovie(Integer idMovie) {
		this.idMovie = idMovie;
	}
	
}
