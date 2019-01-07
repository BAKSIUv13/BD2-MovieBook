package pl.moviebook.dbEntities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Issue")
public class Issue implements Serializable {

	private static final long serialVersionUID = 15503L;

	@Id
	@Column(name="description")
	private String description;
	
	@Column(name="Movie_idMovie")
	private int idMovie;	

	@Column(name="dateTime")
	private Date issueDateTime;

	@Column(name="User_login")
	private String login;

	public Date getIssueDateTime() {
		return issueDateTime;
	}

	public void setIssueDateTime(Date issueDateTime) {
		this.issueDateTime = issueDateTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getIdMovie() {
		return idMovie;
	}

	public void setIdMovie(int idMovie) {
		this.idMovie = idMovie;
	}
}
