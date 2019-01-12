package pl.moviebook.otherEntities;

import java.sql.Timestamp;

public class TransmitionOnStation {

	long dateTime;
	String title;
	int idMovie;
	
	public TransmitionOnStation(long dateTime, String title, int idMovie) {
		this.dateTime = dateTime;
		this.title = title;
		this.idMovie = idMovie;
	}
	
	public long getDateTime() {
		return dateTime;
	}
	public void setDateTime(long dateTime) {
		this.dateTime = dateTime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public int getIdMovie() {
		return idMovie;
	}

	public void setIdMovie(int idMovie) {
		this.idMovie = idMovie;
	}
	
	
}