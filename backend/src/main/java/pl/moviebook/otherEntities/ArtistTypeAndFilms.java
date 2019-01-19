package pl.moviebook.otherEntities;

import java.util.List;

public class ArtistTypeAndFilms {

	private String type;
	private List<MovieBasicInformations> films;
	
	public ArtistTypeAndFilms(String type, List<MovieBasicInformations> films) {
		this.type = type;
		this.films = films;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<MovieBasicInformations> getFilms() {
		return films;
	}

	public void setFilms(List<MovieBasicInformations> films) {
		this.films = films;
	}
}
