package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import datarest.Questions;

public class Daojpa {

	public static List<Questions> getQuestions() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("minion");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		List<Questions> list = em.createQuery("select q from Questions q").getResultList();
		em.close();
		return list;
	}

//	
	public static Questions readQuestion(int ques_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("minion");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Questions question = em.find(Questions.class, ques_id);
		em.getTransaction().commit();
		return question;

	}

	
	  public static List<Questions> updateQuestion(Questions ques) {
	  EntityManagerFactory emf = Persistence.createEntityManagerFactory("minion");
	  EntityManager em = emf.createEntityManager(); em.getTransaction().begin();
	  Questions q = em.find(Questions.class, ques.getQuestion_id());
	  
	  if (q != null) {
	  
	  em.merge(ques); }
	  
	  em.getTransaction().commit(); List<Questions> list = getQuestions(); return
	  list;
	  
	  }
	 

	public static List<Questions> addQuestion(Questions q) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("minion");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(q);
		em.getTransaction().commit();

		return getQuestions();

	}
}
