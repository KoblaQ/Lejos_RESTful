package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class display_message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	
	private int id ;
	private String message;
	
	public display_message() {
		super();
	}
	
	
	public display_message(int id, String message) {
		super();
		this.message = message;
	}
	
	public display_message(String message) {
		super();
		this.message = message;
	}
	
	public display_message(int id) {
		super();
		this.id = id;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	public String toString() {
		return this.id + ": " + this.message;
	}

}
