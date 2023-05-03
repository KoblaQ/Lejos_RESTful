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

import data.obstacle_detected;

@Path("/slayrobotoservices")
public class SlayRobotoServices {
	//Reading all the rows from table object_detected.
		@GET
		@Path("/allobstacles")
		@Produces(MediaType.APPLICATION_JSON)
		public List<obstacle_detected> readAllPrey() {
		//Create an EntityManagerFactory with the settings from persistence.xml file
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("slayrobo9db");
			//And then EntityManager, which can manage the entities.
			EntityManager em=emf.createEntityManager();
			
			//Read all the rows from table obstacle_detected. This returns a List of obstacle_detected objects.
			List<obstacle_detected> list=em.createQuery("select * from obstacle_detected").getResultList();
			return list;
		}
		
		
		//This method uses FormParams, but does the same as previous	
		@POST
		@Path("/addobstacle")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public obstacle_detected postPreyByParams(@FormParam("id") int id, @FormParam("distance") int distance, @FormParam("time") String time) {
			obstacle_detected prey=new obstacle_detected(id,distance, time);
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("slayrobo9db");
			EntityManager em=emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(prey);
			em.getTransaction().commit();
			return prey;
		}
		
		
	
}
