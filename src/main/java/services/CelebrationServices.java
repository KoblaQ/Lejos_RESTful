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

import data.celebration;

@Path("/celebrationservices")
public class CelebrationServices {
	//Reading all the rows from table display_message.
			@GET
			@Path("/readallcelebrations")
			@Produces(MediaType.APPLICATION_JSON)
			public List<celebration> readAllCelebrations() {
			//Create an EntityManagerFactory with the settings from persistence.xml file
				EntityManagerFactory emf=Persistence.createEntityManagerFactory("slayrobo9db");
				//And then EntityManager, which can manage the entities.
				EntityManager em=emf.createEntityManager();
				
				//Read all the rows from table obstacle_detected. This returns a List of obstacle_detected objects.
				List<celebration> list=em.createQuery("select a from celebration a").getResultList();
				return list;
			}
			
			//Adding one prey object into the table celebration	
			@POST
			@Path("/addcelebration")
			@Produces(MediaType.APPLICATION_JSON)
			@Consumes(MediaType.APPLICATION_JSON)
			public celebration postCelebration(celebration newCelebration) {
				EntityManagerFactory emf=Persistence.createEntityManagerFactory("slayrobo9db");
				EntityManager em=emf.createEntityManager();
				em.getTransaction().begin();
				em.persist(newCelebration);//The actual insertion line
				em.getTransaction().commit();
				return newCelebration;
			}
			
			//This method uses FormParams, but does the same as previous	
			@POST
			@Path("/addcelebration")
			@Produces(MediaType.APPLICATION_JSON)
			@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
			public celebration postCelebrationByParams(@FormParam("id") int id, @FormParam("celebration") String celebration) {
				celebration newCelebration=new celebration(id, celebration);
				EntityManagerFactory emf=Persistence.createEntityManagerFactory("slayrobo9db");
				EntityManager em=emf.createEntityManager();
				em.getTransaction().begin();
				em.persist(newCelebration);
				em.getTransaction().commit();
				return newCelebration;
			}

			/*
			NEW method
			Read the values what you want from the database
			Create a string of the values separated by space
			e.g speed=50, dista=30....
			
			String s=speed+" "+dista+" "+other;
			return s;
			
			CREATE A NEW METHOD HERE TO READ THE VALUES YOU WANT FROM THE DATABASE AND THEN return them as a string 
			THIS WOULD LATER BE CONVERTED INTO SEPARATE VALUES IN THE LEJOS PROJECT.
			
			*/
			
			
			
			
}
