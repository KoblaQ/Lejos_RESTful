package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class light {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int id;
	private int intensityLevel;
	
	public light(){
		super();
	}
	
//	public light(int id) {
//		super();
//		this.id = id;
//	}
	
	public light(int intensityLevel) {
		super();
		this.intensityLevel = intensityLevel;
	}
	
	public light(int id, int intensityLevel) {
		super();
		this.intensityLevel = intensityLevel;
		this.id = id;
	}


	public int getIntensityLevel() {
		return intensityLevel;
	}

	public void setIntensityLevel(int intensityLevel) {
		this.intensityLevel = intensityLevel;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString() {
		return "Line Color: " + this.id + "/ " + this.intensityLevel;
	}
}
