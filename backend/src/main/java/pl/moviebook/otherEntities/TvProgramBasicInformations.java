package pl.moviebook.otherEntities;

import java.sql.Timestamp;

public class TvProgramBasicInformations {

	String station;
	long dateTime;
	
	public TvProgramBasicInformations(String station, long dateTime) {
		this.station = station;
		this.dateTime = dateTime;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public long getDateTime() {
		return dateTime;
	}

	public void setDateTime(long dateTime) {
		this.dateTime = dateTime;
	}	
	
	
}
