package pl.moviebook.dbEntities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Movie")
public class Movie implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @Column(name="idMovie")
    private int idMovie;

    @Column(name="title")
    private String title;

    @Column(name="language")
    private String language;

    @Column(name="dateOfPremiere")
    private Date dateOfPremiere;

    @Column(name="boxOffice")
    private int boxOffice;

    @Column(name="country")
    private String country;

    @Column(name="description")
    private String description;

    @Column(name="pictureUrl")
    private String pictureUrl;

	/**
	 * @return the idMovie
	 */
	public int getIdMovie() {
		return idMovie;
	}

	/**
	 * @param idMovie the idMovie to set
	 */
	public void setIdMovie(int idMovie) {
		this.idMovie = idMovie;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return the dateOfPremiere
	 */
	public Date getDateOfPremiere() {
		return dateOfPremiere;
	}

	/**
	 * @param dateOfPremiere the dateOfPremiere to set
	 */
	public void setDateOfPremiere(Date dateOfPremiere) {
		this.dateOfPremiere = dateOfPremiere;
	}

	/**
	 * @return the boxOffice
	 */
	public int getBoxOffice() {
		return boxOffice;
	}

	/**
	 * @param boxOffice the boxOffice to set
	 */
	public void setBoxOffice(int boxOffice) {
		this.boxOffice = boxOffice;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the pictureUrl
	 */
	public String getPictureUrl() {
		return pictureUrl;
	}

	/**
	 * @param pictureUrl the pictureUrl to set
	 */
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
}
