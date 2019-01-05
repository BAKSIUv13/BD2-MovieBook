package pl.moviebook.dbEntities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Cinema")
public class Cinema implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="idCinema")
    private int idCinema;

    @Column(name="name")
    private String name;

    @Column(name="city")
    private String city;

    /**
     * @return the idCinema
     */
    public int getIdCinema() {
        return idCinema;
    }

    /**
     * @param idCinema the idCinema to set
     */
    public void setIdCinema(int idCinema) {
        this.idCinema = idCinema;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

}
