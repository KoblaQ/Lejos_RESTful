package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class obstacle_detected {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private int distance;
	
	
	public obstacle_detected() {
		super();
	}
	
	public obstacle_detected ( int distance) {
		super();
		this.distance = distance;
	}
	
	public obstacle_detected (int id, int distance) {
		super();
		this.id = id;
		this.distance = distance;
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
	
	
	
	//For printing out the values
	
	public String toString() {
		return this.id + ": " + this.distance;
	}

}
