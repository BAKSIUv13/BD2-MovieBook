package pl.moviebook.otherEntities;

public class MoviesStatistics {
	private int idMovie;
	private String title;
	private long dateOfPremiere;
	private String pictureUrl;
	private int amountOfRatings;
	
	public MoviesStatistics(int idMovie, String title, long dateOfPremiere, String pictureUrl, int amountOfRatings) {
		this.idMovie = idMovie;
		this.title = title;
		this.dateOfPremiere = dateOfPremiere;
		this.pictureUrl = pictureUrl;
		this.amountOfRatings = amountOfRatings;
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
	public long getDateOfPremiere() {
		return dateOfPremiere;
	}
	public void setDateOfPremiere(long dateOfPremiere) {
		this.dateOfPremiere = dateOfPremiere;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	public int getAmountOfRatings() {
		return amountOfRatings;
	}
	public void setAmountOfRatings(int amountOfRatings) {
		this.amountOfRatings = amountOfRatings;
	}
}
