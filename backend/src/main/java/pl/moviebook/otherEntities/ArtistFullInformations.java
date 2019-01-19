package pl.moviebook.otherEntities;

import java.util.List;

import pl.moviebook.dbEntities.Prize;

public class ArtistFullInformations {

	private int id;
	private String surname;
	private String name;
	private String origin;
	private String birthDate;
	private String pictureUrl;
	private List<String> types;
    List<Prize> prizes;
    List<ArtistTypeAndFilms> typeAndFilms;
    
	public ArtistFullInformations(int id, String surname, String name, String origin, String date, String pictureUrl,
			List<String> types, List<Prize> prizes,  List<ArtistTypeAndFilms> typeAndFilms) {
		super();
		this.id = id;
		this.surname = surname;
		this.name = name;
		this.origin = origin;
		this.birthDate = date;
		this.pictureUrl = pictureUrl;
		this.types = types;
		this.prizes = prizes;
		this.typeAndFilms = typeAndFilms;
	}
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setDateTime(String date) {
		this.birthDate = date;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	public List<String> getTypes() {
		return types;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}
	public List<Prize> getPrizes() {
		return prizes;
	}
	public void setPrizes(List<Prize> prizes) {
		this.prizes = prizes;
	}

	public List<ArtistTypeAndFilms> getTypeAndFilms() {
		return typeAndFilms;
	}

	public void setTypeAndFilms(List<ArtistTypeAndFilms> typeAndFilms) {
		this.typeAndFilms = typeAndFilms;
	}
	
}
