package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Display_Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	
	private int id ;
	private String message;
	
	public Display_Message() {
		super();
	}
	
	
	public Display_Message(int id, String message) {
		this.id = id;
		this.message = message;
	}
	
	public Display_Message(String message) {
		this.message = message;
	}
	
	public Display_Message(int id) {
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
