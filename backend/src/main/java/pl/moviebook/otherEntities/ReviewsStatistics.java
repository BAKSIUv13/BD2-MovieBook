package pl.moviebook.otherEntities;

public class ReviewsStatistics {

	private int idReview;
	private String content;
	private long date;
	private String author;
	private int amount;
	private int idMovie;
	private String title;
	
	public ReviewsStatistics(int idReview, String content, long date, String author, int amount, int idMovie,
			String title) {
		this.idReview = idReview;
		this.content = content;
		this.date = date;
		this.author = author;
		this.amount = amount;
		this.idMovie = idMovie;
		this.title = title;
	}
	
	public int getIdReview() {
		return idReview;
	}
	public void setIdReview(int idReview) {
		this.idReview = idReview;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
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
}
