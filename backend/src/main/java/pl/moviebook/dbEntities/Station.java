package pl.moviebook.dbEntities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Station")
public class Station implements Serializable{
	
	private static final long serialVersionUID = -3038458778923247550L;
	@Id
	@Column(name="name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}


