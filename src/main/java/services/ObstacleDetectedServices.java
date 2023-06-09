package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import data.obstacle_detected;

@Path("/obstacledetectedservices")
public class ObstacleDetectedServices {
	//Reading all the rows from table object_detected.
		@GET
		@Path("/allobstacles")
		@Produces(MediaType.APPLICATION_JSON)
		public List<obstacle_detected> readAllObstacle() {
		//Create an EntityManagerFactory with the settings from persistence.xml file
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("slayrobo9db");
			//And then EntityManager, which can manage the entities.
			EntityManager em=emf.createEntityManager();
			
			//Read all the rows from table obstacle_detected. This returns a List of obstacle_detected objects.
			List<obstacle_detected> list=em.createQuery("select a from obstacle_detected a").getResultList();
			return list;
		}
		
		
		
		// Reading total number of rows from table obstacle_detected. (COUNT)
		@GET
		@Path("/obstaclecount")
		@Produces(MediaType.APPLICATION_JSON)
		public int getObstacleCount() {
		    // Create an EntityManagerFactory with the settings from persistence.xml file
		    EntityManagerFactory emf = Persistence.createEntityManagerFactory("slayrobo9db");
		    // And then EntityManager, which can manage the entities.
		    EntityManager em = emf.createEntityManager();

		    // Read the total count of rows from the obstacle_detected table.
		    CriteriaBuilder cb = em.getCriteriaBuilder();
		    CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
		    countQuery.select(cb.count(countQuery.from(obstacle_detected.class)));
		    long count = em.createQuery(countQuery).getSingleResult();
		    return (int) count;
		}
		
		//Adding one obstacle object into the table obstacle_detected	
		@POST
		@Path("/addobstacle")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public obstacle_detected postObstacle(obstacle_detected newObstacle) {
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("slayrobo9db");
			EntityManager em=emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(newObstacle);//The actual insertion line
			em.getTransaction().commit();
			return newObstacle;
		}
		
		//This method uses FormParams, but does the same as previous	
		@POST
		@Path("/addobstacle")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public obstacle_detected postObstacleByParams(@FormParam("id") int id, @FormParam("distance") int distance) {
			obstacle_detected newObstacle=new obstacle_detected(id,distance);
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("slayrobo9db");
			EntityManager em=emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(newObstacle);
			em.getTransaction().commit();
			return newObstacle;
		}
		
		//This method uses path params to input values from the robot. 
				@GET
				@Path("/addobstacle/{distance}")
				@Produces(MediaType.APPLICATION_JSON)
				public obstacle_detected postSingleObstacleByParams(@PathParam("distance") int distance) {
					obstacle_detected newObstacle=new obstacle_detected(distance);
					EntityManagerFactory emf=Persistence.createEntityManagerFactory("slayrobo9db");
					EntityManager em=emf.createEntityManager();
					em.getTransaction().begin();
					em.persist(newObstacle);
					em.getTransaction().commit();
					return newObstacle;
				}
		
	
}
