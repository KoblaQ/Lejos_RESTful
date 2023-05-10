package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class celebrations {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	
	private int id ;
	private String name;
//	private int selectedValue;


	public celebrations() {
		super();
	}
	
	
	public celebrations(int id, String message) {
		super();
		this.name = message;
	}
	
	public celebrations(String message) {
		super();
		this.name = message;
	}
	
	public celebrations(int id) {
		super();
		this.id = id;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	
	//SELECTED VALUE
//	public int getSelectedValue() {
//		return selectedValue;
//	}


//	public void setSelectedValue() {
////		this.selectedValue = selectedValue;
//		this.selectedValue = this.id;
//	}

	public String toString() {
		return this.id + ": " + this.name;
	}

}