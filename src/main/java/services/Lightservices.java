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
import javax.ws.rs.core.MediaType;

import data.light;

@Path("/lightservices")
public class Lightservices {
	//Reading all the rows from table display_message.
	@GET
	@Path("/readlinecolor")
	@Produces(MediaType.APPLICATION_JSON)
	public List<light> readLineColor() {
	//Create an EntityManagerFactory with the settings from persistence.xml file
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("slayrobo9db");
		//And then EntityManager, which can manage the entities.
		EntityManager em=emf.createEntityManager();
		
		//Read all the rows from table obstacle_detected. This returns a List of obstacle_detected objects.
		List<light> list=em.createQuery("select a from light a").getResultList();
		return list;
	}
	
	//Adding one prey object into the table prey	
	@POST
	@Path("/addlinecolor")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public light postMessage(light newLineColor) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("slayrobo9db");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(newLineColor);//The actual insertion line
		em.getTransaction().commit();
		return newLineColor;
	}
	
	//This method uses FormParams, but does the same as previous	
	@POST
	@Path("/addlinecolor")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public light postLightByParams(@FormParam("id") int id, @FormParam("intensity_level") int intensity_level) {
		light newLineColor=new light(intensity_level);
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("slayrobo9db");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(newLineColor);
		em.getTransaction().commit();
		return newLineColor;
	}
	
	
	@GET
	@Path("/colorsensor/{id}/{intensity_level}")
	@Produces(MediaType.APPLICATION_JSON)
	public light updateLight(@PathParam("id") int id, @PathParam("intensity_level") int intensityLevel) {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("slayrobo9db");
	    EntityManager em = emf.createEntityManager();

	    // Retrieve the light object with the given ID.
	    light colorSensor = em.find(light.class, id);
	    if (colorSensor != null) {
	        // Update the intensity level of the light object.
	        em.getTransaction().begin();
	        colorSensor.setIntensity_level(intensityLevel);
	        em.getTransaction().commit();
	    }

	    return colorSensor;
	}

}
