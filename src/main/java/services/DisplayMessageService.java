package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import data.display_message;

@Path("/displaymessageservices")
public class DisplayMessageService {
	//Reading all the rows from table display_message.
			@GET
			@Path("/allmessages")
			@Produces(MediaType.APPLICATION_JSON)
			public List<display_message> readAllMessages() {
			//Create an EntityManagerFactory with the settings from persistence.xml file
				EntityManagerFactory emf=Persistence.createEntityManagerFactory("slayrobo9db");
				//And then EntityManager, which can manage the entities.
				EntityManager em=emf.createEntityManager();
				
				//Read all the rows from table obstacle_detected. This returns a List of obstacle_detected objects.
				List<display_message> list=em.createQuery("select a from display_message a").getResultList();
				return list;
			}
			
			//Adding one message object into the table prey	
			@POST
			@Path("/addmessage")
			@Produces(MediaType.APPLICATION_JSON)
			@Consumes(MediaType.APPLICATION_JSON)
			public display_message postMessage(display_message newMessage) {
				EntityManagerFactory emf=Persistence.createEntityManagerFactory("slayrobo9db");
				EntityManager em=emf.createEntityManager();
				em.getTransaction().begin();
				em.persist(newMessage);//The actual insertion line
				em.getTransaction().commit();
				return newMessage;
			}
			
			//This method uses FormParams, but does the same as previous	
			@POST
			@Path("/addmessage")
			@Produces(MediaType.APPLICATION_JSON)
			@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
			public display_message postMessageByParams(@FormParam("id") int id, @FormParam("message") String message) {
				display_message newMessage=new display_message(id, message);
				EntityManagerFactory emf=Persistence.createEntityManagerFactory("slayrobo9db");
				EntityManager em=emf.createEntityManager();
				em.getTransaction().begin();
				em.persist(newMessage);
				em.getTransaction().commit();
				return newMessage;
			}

}
