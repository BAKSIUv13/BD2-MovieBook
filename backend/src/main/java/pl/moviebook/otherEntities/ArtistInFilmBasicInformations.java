package pl.moviebook.otherEntities;

public class ArtistInFilmBasicInformations {

	private int idArtist;
	private String name;
	private String surname;
	private String pictureUrl;
	private String artistType;
	private String role;
	
	public ArtistInFilmBasicInformations(int idArtist, String name, String surname, String pictureUrl, 
			String artistType, String role) {
		this.idArtist = idArtist;
		this.name = name;
		this.surname = surname;
		this.pictureUrl = pictureUrl;
		this.artistType = artistType;
		this.role = role;
	}
	
	public int getIdArtist() {
		return idArtist;
	}
	public void setIdArtist(int idArtist) {
		this.idArtist = idArtist;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	public String getArtistType() {
		return artistType;
	}
	public void setArtistType(String artistType) {
		this.artistType = artistType;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
