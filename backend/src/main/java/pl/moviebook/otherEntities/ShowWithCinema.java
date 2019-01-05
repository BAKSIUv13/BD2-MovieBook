package pl.moviebook.otherEntities;

import java.sql.Timestamp;

public class ShowWithCinema {

	Timestamp dateTime;
	String cinemaName;
	String city;
	
	public ShowWithCinema(Timestamp dateTime, String cinemaName, String city) {
		this.dateTime = dateTime;
		this.cinemaName = cinemaName;
		this.city = city;
	}

	public Timestamp getDateTime() {
		return dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}

	public String getCinemaName() {
		return cinemaName;
	}

	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
