package rest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import datarest.Questions;

@Path("/questions")
public class Rest {
	
	
	@GET
	@Path("/getquestions")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public static List<Questions> getQuestions() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("minion");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		List<Questions> list = em.createQuery("select q from Questions q").getResultList();
		em.close();
		return list;
	}
}
