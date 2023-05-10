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

import data.slayroboto;;

@Path("/slayrobotoservices")
public class SlayRobotoServices {
	// Reading all the rows from table slayroboto.
	@GET
	@Path("/readall")
	@Produces(MediaType.APPLICATION_JSON)
	public List<slayroboto> readAll() {
		// Create an EntityManagerFactory with the settings from persistence.xml file
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("slayrobo9db");
		// And then EntityManager, which can manage the entities.
		EntityManager em = emf.createEntityManager();

		// Read all the rows from table obstacle_detected. This returns a List of
		// obstacle_detected objects.
		List<slayroboto> list = em.createQuery("select a from slayroboto a").getResultList();
		return list;
	}

	// Adding one value object into the table slayroboto
	@POST
	@Path("/adddata")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public slayroboto postValue(slayroboto newRobot) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("slayrobo9db");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(newRobot);// The actual insertion line
		em.getTransaction().commit();
		return newRobot;
	}

	// This method uses FormParams, but does the same as previous
	@POST
	@Path("/adddatas")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public slayroboto postDataByParams(@FormParam("id") int id, @FormParam("base_speed") int base_speed,
			@FormParam("cycle") int cycle, @FormParam("safety_distance") int safety_distance,
			@FormParam("linecolor") int linecolor) {
		slayroboto newRobot = new slayroboto(id, base_speed, cycle, safety_distance, linecolor);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("slayrobo9db");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(newRobot);
		em.getTransaction().commit();
		return newRobot;
	}

	// This method uses FormParams to UPDATE the values in the slayroboto table.
	@POST
	@Path("/updatedata")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public slayroboto updateDataByParams(@FormParam("id") int id, @FormParam("base_speed") int base_speed,
			@FormParam("cycle") int cycle, @FormParam("safety_distance") int safety_distance,
			@FormParam("linecolor") int linecolor) {
		slayroboto newRobot = new slayroboto(id, base_speed, cycle, safety_distance, linecolor);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("slayrobo9db");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(newRobot);
		em.getTransaction().commit();
		return newRobot;
	}
		
		//All SlayRoboto Values to string 
		
		@GET
		@Path("/slayroboto")
		@Produces(MediaType.TEXT_PLAIN)
//		@Produces(MediaType.APPLICATION_JSON)
		public String slayrobotoString() {
		    // Create an EntityManagerFactory with the settings from persistence.xml file
		    EntityManagerFactory emf = Persistence.createEntityManagerFactory("slayrobo9db");
		    // And then EntityManager, which can manage the entities.
		    EntityManager em = emf.createEntityManager();
		    
		    // Retrieve the Prey with the specified ID
		    slayroboto slayRoboto = em.find(slayroboto.class,1);
		    
		    // Close the EntityManager and EntityManagerFactory
		    em.close();
		    emf.close();
		    
		    
//		   return slayRoboto.getBase_speed() + " " + slayRoboto.getCycle() + " " + slayRoboto.getSafety_distance() + " " + slayRoboto.getLinecolor();
		   return slayRoboto.toString();
		}
	
}
