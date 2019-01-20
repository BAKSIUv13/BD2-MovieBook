package pl.moviebook.dbEntities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Movie_has_Artist")
public class Movie_has_Artist implements Serializable {

	private static final long serialVersionUID = -4988500367449163663L;

	@Id
	@Column(name="Movie_idMovie")
	private int idMovie;
	
	@Id
	@Column(name="Artist_has_ArtistType_id")
	private int idArtistType;
	
	@Column(name="Role")
	private String role;

	public int getIdMovie() {
		return idMovie;
	}

	public void setIdMovie(int idMovie) {
		this.idMovie = idMovie;
	}

	public int getIdArtistType() {
		return idArtistType;
	}

	public void setIdArtistType(int idArtistType) {
		this.idArtistType = idArtistType;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}