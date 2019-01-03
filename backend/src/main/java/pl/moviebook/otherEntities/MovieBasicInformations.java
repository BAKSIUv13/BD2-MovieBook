package pl.moviebook.otherEntities;

import java.sql.Date;
import java.util.List;

public class MovieBasicInformations {
	
	 	private int idMovie;
	    private String title;
	    private Date dateOfPremiere;
	    private String pictureUrl;
	    private List<String> genre;
	    
	    public MovieBasicInformations(int id, String title, Date premiere, String url, List<String> genre) {
	    	this.idMovie = id;
	    	this.title = title;
	    	this.dateOfPremiere = premiere;
	    	this.pictureUrl = url;
	    	this.genre = genre;
	    }

		public int getIdMovie() {
			return idMovie;
		}

		public void setIdMovie(int idMovie) {
			this.idMovie = idMovie;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public Date getDateOfPremiere() {
			return dateOfPremiere;
		}

		public void setDateOfPremiere(Date dateOfPremiere) {
			this.dateOfPremiere = dateOfPremiere;
		}

		public String getPictureUrl() {
			return pictureUrl;
		}

		public void setPictureUrl(String pictureUrl) {
			this.pictureUrl = pictureUrl;
		}

		public List<String> getGenre() {
			return genre;
		}

		public void setGenre(List<String> genre) {
			this.genre = genre;
		}
}
