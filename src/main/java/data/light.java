package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class light {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private int intensity_level;
	
	public light(){
		super();
	}
	
	
	public light(int intensity_level) {
		super();
		this.intensity_level = intensity_level;
	}
	
	public light(int id, int intensity_level) {
		super();
		this.id = 1;
		this.intensity_level = intensity_level;
		
	}
	
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIntensity_level() {
		return intensity_level;
	}

	public void setIntensity_level(int intensity_level) {
		this.intensity_level = intensity_level;
	}

	public String toString() {
		return ""+this.id + this.intensity_level;
	}
}
