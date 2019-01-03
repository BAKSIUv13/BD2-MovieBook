package pl.moviebook.dbEntities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Review")
public class Review implements Serializable {

	private static final long serialVersionUID = 6523085131453554304L;

	@Id
	@Column(name="idReview")
	private int idReview;
	
	@Column(name="content")
	private String content;
	
	@Column(name="Movie_idMovie")
	private int idMovie;
	
	@Column(name="User_login")
	private String login;

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

	public int getIdMovie() {
		return idMovie;
	}

	public void setIdMovie(int idMovie) {
		this.idMovie = idMovie;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}
