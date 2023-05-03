package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class celebration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	
	private int id ;
	private String name;
	
	public celebration() {
		super();
	}
	
	
	public celebration(int id, String message) {
		super();
		this.name = message;
	}
	
	public celebration(String message) {
		super();
		this.name = message;
	}
	
	public celebration(int id) {
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


	public String toString() {
		return this.id + ": " + this.name;
	}

}
