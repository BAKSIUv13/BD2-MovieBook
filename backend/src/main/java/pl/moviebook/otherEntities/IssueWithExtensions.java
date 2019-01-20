package pl.moviebook.otherEntities;

public class IssueWithExtensions {

	private int idIssue;
	private String description;
	private int idMovie;
	private long issueDateTime;
	private String login;
	private String title;
	
	public IssueWithExtensions(int idIssue, String description, int idMovie, long issueDateTime, String login,
			String title) {
		this.idIssue = idIssue;
		this.description = description;
		this.idMovie = idMovie;
		this.issueDateTime = issueDateTime;
		this.login = login;
		this.title = title;
	}
	
	public int getIdIssue() {
		return idIssue;
	}
	public void setIdIssue(int idIssue) {
		this.idIssue = idIssue;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getIdMovie() {
		return idMovie;
	}
	public void setIdMovie(int idMovie) {
		this.idMovie = idMovie;
	}
	public long getIssueDateTime() {
		return issueDateTime;
	}
	public void setIssueDateTime(long issueDateTime) {
		this.issueDateTime = issueDateTime;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

}
