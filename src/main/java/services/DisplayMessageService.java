package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import data.Display_Message;

@Path("/displaymessageservice")
public class DisplayMessageService {
	
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("slayrobo9db");
	
	//To read the messages from the database
	@GET 
	@Path("/readmessage")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Display_Message> readMessage() {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		List<Display_Message> list=em.createQuery("select * from Display_Message").getResultList();		
		em.getTransaction().commit();
		return list;
	}
	
	
	//To add a message to the database
	@POST
	@Path("/addmessage")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Display_Message> addMessage(Display_Message displayMessage) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(displayMessage);//The actual insertion line
		em.getTransaction().commit();
		//Calling the method readMessage() of this service
		List<Display_Message> list=readMessage();		
		return list;
	}
	
	
	//To update a message in the database
	@PUT
	@Path("/updatemessage")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Display_Message> updateMessage(Display_Message displayMessage) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Display_Message f=em.find(Display_Message.class, displayMessage.getId());
		if (f!=null) {
			em.merge(displayMessage);//The actual update line
		}
		em.getTransaction().commit();
		//Calling the method readFish() of this service
		List<Display_Message> list=readMessage();		
		return list;
	}
	
	
	// To delete a message from the database
	@DELETE
	@Path("/deletemessage/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Display_Message> deleteMessage(@PathParam("id") int id) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Display_Message f=em.find(Display_Message.class, id);
		if (f!=null) {
			em.remove(f);//The actual insertion line
		}
		em.getTransaction().commit();
		//Calling the method readMessage() of this service
		List<Display_Message> list=readMessage();		
		return list;
	}
	
	//To read to update message in the database
	
	@GET
	@Path("/readtoupdatemessage/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Display_Message readToUpdateMessage(@PathParam("id") int id) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Display_Message f=em.find(Display_Message.class, id);
		em.getTransaction().commit();
		return f;
	}
	
	
}
