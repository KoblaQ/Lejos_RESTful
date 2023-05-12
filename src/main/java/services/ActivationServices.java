//package services;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.FormParam;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//
//import data.activation;
//
//@Path("/activationservices")
//public class ActivationServices {
//	//Reading all the rows from table display_message.
//	@GET
//	@Path("/readstatus")
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<activation> readStatus() {
//	//Create an EntityManagerFactory with the settings from persistence.xml file
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("slayrobo9db");
//		//And then EntityManager, which can manage the entities.
//		EntityManager em=emf.createEntityManager();
//		
//		//Read all the rows from table obstacle_detected. This returns a List of obstacle_detected objects.
//		List<activation> list=em.createQuery("select a from activation a").getResultList();
//		return list;
//	}
//	
//	//Adding activation status object into the table activation	
//	@POST
//	@Path("/addstatus")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public activation postStatus(activation newStatus) {
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("slayrobo9db");
//		EntityManager em=emf.createEntityManager();
//		em.getTransaction().begin();
//		em.persist(newStatus);//The actual insertion line
//		em.getTransaction().commit();
//		return newStatus;
//	}
//	
////	//This method uses FormParams, but does the same as previous	
//
//		@POST
//		@Path("/activation")
//		@Produces(MediaType.APPLICATION_JSON)
//		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//		public activation updateStatus( @FormParam("status") int status) {
//			
//			activation newStatus = new activation( status);
//			EntityManagerFactory emf = Persistence.createEntityManagerFactory("slayrobo9db");
//			EntityManager em = emf.createEntityManager();
//			em.getTransaction().begin();
//			em.merge(newStatus);
//			em.getTransaction().commit();
//			return newStatus;
//		}
//		
//		//Get activation Status Value as a string 
//		
//		@GET
//		@Path("/status")
//		@Produces(MediaType.TEXT_PLAIN) //Plain text because we want only string value
//		public String activationToString() {
//		    // Create an EntityManagerFactory with the settings from persistence.xml file
//		    EntityManagerFactory emf = Persistence.createEntityManagerFactory("slayrobo9db");
//		    // And then EntityManager, which can manage the entities.
//		    EntityManager em = emf.createEntityManager();
//		    
//		    // Retrieve the Status with the specified ID
//		    activation activationStatus = em.find(activation.class,1);
//		    
//		    // Close the EntityManager and EntityManagerFactory
//		    em.close();
//		    emf.close();
//		    
//		    //Return string value
//		    return activationStatus.toString();
//		}
//
//
//}
