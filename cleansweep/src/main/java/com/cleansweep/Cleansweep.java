package com.cleansweep;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cleansweep.entities.ReoccurringTask;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Cleansweep {

	private EntityManagerFactory entityManagerFactory;

	public static void main(String[] args) {
		Cleansweep app = new Cleansweep();
		try {
			app.setUp();
			app.getListOfReoccurringTasks();
			app.tearDown();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void setUp() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory("com.cleansweep");
	}

	protected void getListOfReoccurringTasks() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		ObjectMapper mapper = new ObjectMapper();
		
//		List<User> result = entityManager.createQuery("from User", User.class)
//		    .getResultList();
//		for (User user : result) {
//			try {
//				System.out.println("User " + mapper.writeValueAsString(user) + "\n");
//			} catch (JsonProcessingException e) {
//				e.printStackTrace();
//			}
//		}
		
		List<ReoccurringTask> result = entityManager.createQuery("from ReoccurringTask", ReoccurringTask.class)
		    .getResultList();
		for (ReoccurringTask task : result) {
			try {
				System.out.println("Reoccurring Task " + mapper.writeValueAsString(task) + "\n");
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}

		entityManager.getTransaction().commit();
		entityManager.close();
	}

	private void tearDown() {
		entityManagerFactory.close();
	}
}
