package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import datarest.Candidates;
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

	
	public static Questions readQuestion(int ques_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("minion");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Questions question = em.find(Questions.class, ques_id);
		
		return question;

	}

	
	  public static List<Questions> updateQuestion(Questions ques) {
	  EntityManagerFactory emf = Persistence.createEntityManagerFactory("minion");
	  EntityManager em = emf.createEntityManager(); em.getTransaction().begin();
	  Questions q = em.find(Questions.class, ques.getQuestion_id());
	  
	  if (q != null) {
	  
	  em.merge(ques); }
	  
	  em.getTransaction().commit(); 
	  List<Questions> list = getQuestions(); 
	  return
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
	
	// method deletes a question and answers related to it based on a given question id
	public static boolean deleteQuestion(int question_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("minion");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Questions question = em.find(Questions.class, question_id);
		
		if (question != null) {
			em.remove(question);
		}

		em.getTransaction().commit();
		em.close();
		
		return true;
	}

	//************************************METHODS FOR CANDIDATE***************************
	
	//Method for getting all candidates from database
	public static List<Candidates> getCandidates() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("minion");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		List<Candidates> list = em.createQuery("select c from Candidates c").getResultList();
		em.close();
		return list;
	
	}
	
	//Method for reading one candidate from database
	public static Candidates readCandidate(int cand_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("minion");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Candidates candidate = em.find(Candidates.class, cand_id);
		
		return candidate;

	}

	//Method to update candidates info (no id or pic)
	public static Candidates updateCandidate(Candidates cand) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("minion");
		  EntityManager em = emf.createEntityManager(); em.getTransaction().begin();
		  Candidates c = em.find(Candidates.class,cand.getCandidate_id());
		  
		  if (c != null) {
		  
		  em.merge(cand); 
		  
		  } else {
			  System.out.println("eip");
		  }
	  
		  em.getTransaction().commit(); 
		  Candidates can = readCandidate(cand.getCandidate_id()); 
		  return can;
	}
	
	//**************************************************************************************
}
