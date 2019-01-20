package pl.moviebook.dbEntities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Artist_has_ArtistType")
public class Artist_has_ArtistType implements Serializable {

	private static final long serialVersionUID = -1697861408965468437L;
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="Artist_idArtist")
	private int idArtist;
	
	@Column(name="ArtistType_name")
	private String type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdArtist() {
		return idArtist;
	}

	public void setIdArtist(int idArtist) {
		this.idArtist = idArtist;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	

}