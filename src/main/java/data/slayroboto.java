package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class slayroboto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int base_speed;
	private int cycle;
	private float safety_distance;
	private int linecolor;
	
	public slayroboto() {
		super();
	}
	
	public slayroboto(int base_speed, int cycle, float safety_distance, int linecolor) {
		super();
		this.base_speed = base_speed;
		this.cycle = cycle;
		this.safety_distance = safety_distance;
		this.linecolor = linecolor;
	}

	public int getBase_speed() {
		return base_speed;
	}

	public void setBase_speed(int base_speed) {
		this.base_speed = base_speed;
	}

	public int getCycle() {
		return cycle;
	}

	public void setCycle(int cycle) {
		this.cycle = cycle;
	}

	public float getSafety_distance() {
		return safety_distance;
	}

	public void setSafety_distance(float safety_distance) {
		this.safety_distance = safety_distance;
	}

	public int getLinecolor() {
		return linecolor;
	}

	public void setLinecolor(int linecolor) {
		this.linecolor = linecolor;
	}
	
	//For printing out the values
	
		public String toString() {
			return "Base Speed: " + this.base_speed + "Cycle: " + this.cycle + "safety_distance: " + this.safety_distance + "Linecolor: " + this.linecolor;
		}


}
