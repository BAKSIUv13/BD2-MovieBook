package pl.moviebook.dbEntities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ToWatch")
public class ToWatch implements Serializable {

	private static final long serialVersionUID = 1034138L;

	@Id
	@Column(name="User_login")
	private String login;
	
	@Column(name="Movie_idMovie")
	private int idMovie;


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
