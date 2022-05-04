package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import datarest.Admin;
import datarest.Answers;
import datarest.Candidates;
import datarest.Questions;

public class Daojpa {
	
	// Method reads all of the questions from database to a list.
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
	 
	// Method adds new question to a database and then returns all questions.
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
		// EntityMangaer enables the interaction with database
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("minion");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Questions question = em.find(Questions.class, question_id);   // Searches for an entity of the specified class and primary key.
		
		if (question != null) {
			em.remove(question);   // Removes the entity.
		}

		em.getTransaction().commit();   // Commits the transaction. Entity won't be removed unless commit is success.
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

	//Method to update candidates info
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

	// Method adds all candidates answer to a zero in the newly added question.
	public static void addAnswerZeroToNewQuestion() {
		List<Candidates> candidates=getCandidates();
		List<Questions> list=getQuestions();
		
		Questions en =(Questions) list.get(list.size()-1);
		System.out.println(en.getQuestion_id()+" "+en.getQuestion());
		int question_id = en.getQuestion_id();
		
		for (int i=1; i<=candidates.size(); i++) {
			int candidate_id = candidates.get(i-1).getCandidate_id();
			System.out.println("moi");
			Answers answer=new Answers(candidate_id, question_id, 0);
			System.out.println(answer);
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("minion");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(answer);
			em.getTransaction().commit();
			em.close();
		}
		
		
	}
	
	// method deletes a candidate and answers related to given candidate id
	public static boolean deleteCandidate(int candidate_id) {
		// EntityMangaer enables the interaction with database
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("minion");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Candidates cand = em.find(Candidates.class, candidate_id);   // Searches for an entity of the specified class and primary key.
		
		if (cand != null) {
			em.remove(cand);   // Removes the entity.
		}

		em.getTransaction().commit();   // Commits the transaction. Entity won't be removed unless commit is success.
		em.close();
		
		return true;
	}

	//Method adds new candidates info to a database and then returns readCandidate
	public static Candidates addCandidate(Candidates c) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("minion");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		  
		  if (c != null) {
		  
		  em.merge(c); 
		  
		  } else {
			  System.out.println("eip");
		  }
	  
		List<Candidates> list=getCandidates();
		Candidates en =(Candidates) list.get(list.size()-1);
		System.out.println(en.getCandidate_id());
		int candidate_id = en.getCandidate_id();
		  
		Candidates can = readCandidate(candidate_id); 
		return can;
	}

	//Method adds newly added candidates answer values to questions zero.
	public static void addAnswersToNewCandidate() {
		List<Candidates> list=getCandidates();
		List<Questions> questions=getQuestions();
		
		Candidates en =(Candidates) list.get(list.size()-1);
		
		int candidate_id = en.getCandidate_id();
		
		for (int i=1; i <=questions.size(); i++){
			System.out.println("moi");
			int question_id = questions.get(i-1).getQuestion_id();
			Answers answer=new Answers(candidate_id, question_id, 0);
			System.out.println(answer);
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("minion");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(answer);
			em.getTransaction().commit();
			em.close();
		}
		
	}


	public static Admin getCredentials() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("minion");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Admin admin = new Admin();
		
		admin = em.find(Admin.class, 1);
		em.close();	
		
		return admin;
	}
	
	//**************************************************************************************
}
