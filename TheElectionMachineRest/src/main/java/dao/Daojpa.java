package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
}
