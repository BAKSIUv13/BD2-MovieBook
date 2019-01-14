package pl.moviebook.otherEntities;

import java.sql.Timestamp;

public class ShowWithCinema {

	long dateTime;
	String cinemaName;
	String city;
	
	public ShowWithCinema(long dateTime, String cinemaName, String city) {
		this.dateTime = dateTime;
		this.cinemaName = cinemaName;
		this.city = city;
	}

	public long getDateTime() {
		return dateTime;
	}

	public void setDateTime(long dateTime) {
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
