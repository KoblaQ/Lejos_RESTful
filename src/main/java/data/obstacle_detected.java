package data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class obstacle_detected {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private int distance;
	private String time;
	
	
	public obstacle_detected() {
		super();
	}
	public obstacle_detected (int id, String time) {
		super();
		this.id = id;
		this.time = time;
	}
	
	public obstacle_detected (int id, int distance, String time) {
		super();
		this.id = id;
		this.distance = distance;
		this.time = time;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	
	//For printing out the values
	
	public String toString() {
		return this.id + ": " + this.distance + ": " + this.time;
	}

}
