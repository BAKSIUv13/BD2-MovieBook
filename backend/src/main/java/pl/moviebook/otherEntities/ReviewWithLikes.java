package pl.moviebook.otherEntities;

public class ReviewWithLikes {

	private int idReview;
	private String content;
	private int amountOfLikes;
	private String login;
	
	public ReviewWithLikes(int idReview, String content, int amountOfLikes, String login) {
		this.idReview = idReview;
		this.content = content;
		this.amountOfLikes = amountOfLikes;
		this.login = login;
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
	public int getAmountOfLikes() {
		return amountOfLikes;
	}
	public void setAmountOfLikes(int amountOfLikes) {
		this.amountOfLikes = amountOfLikes;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}
