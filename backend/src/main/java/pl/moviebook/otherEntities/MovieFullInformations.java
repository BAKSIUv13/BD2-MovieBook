package pl.moviebook.otherEntities;

import java.sql.Date;
import java.util.List;

import pl.moviebook.dbEntities.Genre;
import pl.moviebook.dbEntities.Prize;
import pl.moviebook.dbEntities.TvProgram;

public class MovieFullInformations {
	
		private int idMovie;
	    private String title;
	    private String language;
	    private Date dateOfPremiere;
	    private int boxOffice;
	    private String country;
	    private String description;
	    private String pictureUrl;
	    private List<String> genres;
	    
	    List<ArtistInFilmBasicInformations> artists;
	    List<ReviewWithLikes> reviews;
	    List<Prize> prizes;
	    List<ShowWithCinema> shows;
	    List<TvProgram> transmitions;
	    double rating;
	    
	    public MovieFullInformations(int idMovie, String title, String language, Date dateOfPremiere, int boxOffice,String country,
	    	String description, String pictureUrl, List<ArtistInFilmBasicInformations> artists, List<ReviewWithLikes> reviews,
	    	List<Prize> prizes, List<ShowWithCinema> shows, List<TvProgram> transmitions, double rating, List<String> genres) {
		this.idMovie = idMovie;
		this.title = title;
		this.language = language;
		this.dateOfPremiere = dateOfPremiere;
		this.boxOffice = boxOffice;
		this.country = country;
		this.description = description;
		this.pictureUrl = pictureUrl;
		this.artists = artists;
		this.reviews = reviews;
		this.prizes = prizes;
		this.shows = shows;
		this.transmitions = transmitions;
		this.rating = rating;
		this.genres = genres;
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
		public String getLanguage() {
			return language;
		}
		public void setLanguage(String language) {
			this.language = language;
		}
		public Date getDateOfPremiere() {
			return dateOfPremiere;
		}
		public void setDateOfPremiere(Date dateOfPremiere) {
			this.dateOfPremiere = dateOfPremiere;
		}
		public int getBoxOffice() {
			return boxOffice;
		}
		public void setBoxOffice(int boxOffice) {
			this.boxOffice = boxOffice;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getPictureUrl() {
			return pictureUrl;
		}
		public void setPictureUrl(String pictureUrl) {
			this.pictureUrl = pictureUrl;
		}
		public List<ArtistInFilmBasicInformations> getArtists() {
			return artists;
		}
		public void setArtists(List<ArtistInFilmBasicInformations> artists) {
			this.artists = artists;
		}
		public List<ReviewWithLikes> getReviews() {
			return reviews;
		}
		public void setReviews(List<ReviewWithLikes> reviews) {
			this.reviews = reviews;
		}
		public List<Prize> getPrizes() {
			return prizes;
		}
		public void setPrizes(List<Prize> prizes) {
			this.prizes = prizes;
		}
		public List<ShowWithCinema> getShows() {
			return shows;
		}
		public void setShows(List<ShowWithCinema> shows) {
			this.shows = shows;
		}
		public List<TvProgram> getTransmitions() {
			return transmitions;
		}
		public void setTransmitions(List<TvProgram> transmitions) {
			this.transmitions = transmitions;
		}
		public double getRating() {
			return rating;
		}
		public void setRating(double rating) {
			this.rating = rating;
		}

		public List<String> getGenres() {
			return genres;
		}

		public void setGenres(List<String> genres) {
			this.genres = genres;
		}
	    
}
