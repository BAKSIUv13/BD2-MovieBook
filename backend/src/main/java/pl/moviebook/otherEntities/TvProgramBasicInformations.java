package pl.moviebook.otherEntities;

import java.sql.Timestamp;

public class TvProgramBasicInformations {

	String station;
	Timestamp dateTime;
	
	public TvProgramBasicInformations(String station, Timestamp dateTime) {
		this.station = station;
		this.dateTime = dateTime;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public Timestamp getDateTime() {
		return dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}	
	
	
}
