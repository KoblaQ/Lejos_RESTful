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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import data.celebrations;

@Path("/celebrationservices")
public class CelebrationServices {

	// TESTING ROBOT CONNECTION
	@GET
	@Path("/tuduu")
	@Produces(MediaType.TEXT_PLAIN)
	public String echo() {
		return "HELLO FROM THE OTHER SIDE";
	}

	// Reading all the rows from table display_message.
	@GET
	@Path("/readallcelebrations")
	@Produces(MediaType.APPLICATION_JSON)
	public List<celebrations> readAllCelebrations() {
		// Create an EntityManagerFactory with the settings from persistence.xml file
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("slayrobo9db");
		// And then EntityManager, which can manage the entities.
		EntityManager em = emf.createEntityManager();

		// Read all the rows from table obstacle_detected. This returns a List of
		// obstacle_detected objects.
		List<celebrations> list = em.createQuery("select a from celebration a").getResultList();
		return list;
	}

	// Adding one prey object into the table celebration
	@POST
	@Path("/addcelebration")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public celebrations postCelebration(celebrations newCelebration) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("slayrobo9db");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(newCelebration);// The actual insertion line
		em.getTransaction().commit();
		return newCelebration;
	}

	// This method uses FormParams, but does the same as previous
	@POST
	@Path("/addcelebration")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public celebrations postCelebrationByParams(@FormParam("id") int id, @FormParam("celebration") String celebration) {
		celebrations newCelebration = new celebrations(id, celebration);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("slayrobo9db");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(newCelebration);
		em.getTransaction().commit();
		return newCelebration;
	}

//	// Reading selected celebration from the table celebration.
//	@GET
//	@Path("/selectedcelebration")
//	@Produces(MediaType.APPLICATION_JSON)
//	public String readOneCelebration() {
//		// Create an EntityManagerFactory with the settings from persistence.xml file
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("slayrobo9db");
//		// And then EntityManager, which can manage the entities.
//		EntityManager em = emf.createEntityManager();
//
//		// Read all the rows from table obstacle_detected. This returns a List of
//		// obstacle_detected objects.
//		String celebrationName = em.createQuery("select a.name from celebration a where a.id = 1").getResultList();
//		return celebrationName;
//	}

//	// READING ONLY ONE VALUE 
//	@POST
//	@Path("/singlecelebration")
//	@Produces(MediaType.APPLICATION_JSON)
//	public celebration readOneCelebration(@FormParam("id") int id) {
//	    // Create an EntityManagerFactory with the settings from persistence.xml file
//	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("slayrobo9db");
//	    // And then EntityManager, which can manage the entities.
//	    EntityManager em = emf.createEntityManager();
//	    
//	    // Retrieve the Prey with the specified ID
//	    celebration singleCelebration = em.find(celebration.class, id);
//	    
//	    // Close the EntityManager and EntityManagerFactory
//	    em.close();
//	    emf.close();
//	    
//	    
//	    
//	    return singleCelebration;
//	}
	
//	@GET
//	@Path("/singlecelebration")
////	@Produces(MediaType.TEXT_PLAIN)
//	@Produces(MediaType.APPLICATION_JSON)
//	public String readOneCelebration(@QueryParam("id") int id) {
//	    // Create an EntityManagerFactory with the settings from persistence.xml file
//	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("slayrobo9db");
//	    // And then EntityManager, which can manage the entities.
//	    EntityManager em = emf.createEntityManager();
//	    
//	    // Retrieve the Prey with the specified ID
//	    celebration singleCelebration = em.find(celebration.class, id);
//	    
//	    // Close the EntityManager and EntityManagerFactory
//	    em.close();
//	    emf.close();
//	    
//	    
//	    return "" + singleCelebration.getName();
//	}
	
	
//	@GET
//	@Path("/singlecelebration")
//	@Produces(MediaType.TEXT_PLAIN)
////	@Produces(MediaType.APPLICATION_JSON)
//	public String readOneCelebration() {
//	    // Create an EntityManagerFactory with the settings from persistence.xml file
//	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("slayrobo9db");
//	    // And then EntityManager, which can manage the entities.
//	    EntityManager em = emf.createEntityManager();
//	    
//	    
//	    //Get the selected value
//	    
//	    int id = 1;
//	    // Retrieve the Prey with the specified ID
//	    celebration singleCelebration = em.find(celebration.class,id);
//	    
//	    // Close the EntityManager and EntityManagerFactory
//	    em.close();
//	    emf.close();
//	    
//	    
//	   return singleCelebration.getName();
//	}
	
//	@GET
//	@Path("/singlecelebrationnoparam")
//	@Produces(MediaType.TEXT_PLAIN)
////	@Produces(MediaType.APPLICATION_JSON)
//	public String readOneCelebration() {
//	    // Create an EntityManagerFactory with the settings from persistence.xml file
//	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("slayrobo9db");
//	    // And then EntityManager, which can manage the entities.
//	    EntityManager em = emf.createEntityManager();
//	    
//	    // Retrieve the Prey with the specified ID
//	    celebration singleCelebration = em.find(celebration.class, 4);
//	    
//	    // Close the EntityManager and EntityManagerFactory
//	    em.close();
//	    emf.close();
//	    
//	    
////	     String value = singleCelebration.getName();
////	     return value.toString();
//	    
//	    return singleCelebration.getName();
//	}

	/*
	 * NEW method Read the values what you want from the database Create a string of
	 * the values separated by space e.g speed=50, dista=30....
	 * 
	 * String s=speed+" "+dista+" "+other; return s;
	 * 
	 * CREATE A NEW METHOD HERE TO READ THE VALUES YOU WANT FROM THE DATABASE AND
	 * THEN return them as a string THIS WOULD LATER BE CONVERTED INTO SEPARATE
	 * VALUES IN THE LEJOS PROJECT.
	 * 
	 */

}
