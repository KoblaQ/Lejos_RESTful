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
	//Reading all the rows from table slayroboto.
		@GET
		@Path("/readall")
		@Produces(MediaType.APPLICATION_JSON)
		public List<slayroboto> readAll() {
		//Create an EntityManagerFactory with the settings from persistence.xml file
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("slayrobo9db");
			//And then EntityManager, which can manage the entities.
			EntityManager em=emf.createEntityManager();
			
			//Read all the rows from table obstacle_detected. This returns a List of obstacle_detected objects.
			List<slayroboto> list=em.createQuery("select a from slayroboto a").getResultList();
			return list;
		}
		
		//Adding one slayroboto object into the table prey	
		@POST
		@Path("/adddata")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public slayroboto postObstacle(slayroboto newRobot) {
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("slayrobo9db");
			EntityManager em=emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(newRobot);//The actual insertion line
			em.getTransaction().commit();
			return newRobot;
		}
		
		//This method uses FormParams, but does the same as previous	
		@POST
		@Path("/adddata")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public slayroboto postObstacleByParams(@FormParam("base_speed") int base_speed, @FormParam("cycle") int cycle, @FormParam("safety_distance") float safety_distance, @FormParam("linecolor") int linecolor) {
			slayroboto newRobot=new slayroboto(base_speed, cycle, safety_distance, linecolor);
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("slayrobo9db");
			EntityManager em=emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(newRobot);
			em.getTransaction().commit();
			return newRobot;
		}
		
		
	
}
