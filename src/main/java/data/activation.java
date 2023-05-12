//package data;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//@Entity
//public class activation {
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	
//	private int id;
//	private int status;
//	
//	public activation(){
//		super();
//	}
//	
//
//	
//	public activation(int status) {
//		super();
//		this.id = 1;
//		this.status = status;
//	}
//	
//	public activation(int id, int status) {
//		super();
//		this.id = id;
//		this.status = status;
//		
//	}
//	
//
//	public int getId() {
//		return id;
//	}
//
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//
//	public int getStatus() {
//		return status;
//	}
//
//
//	public void setStatus(int status) {
//		this.status = status;
//	}
//
//
//	public String toString() {
//		return  ""+this.status;
//	}
//}
