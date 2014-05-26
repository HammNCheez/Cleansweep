package com.cleansweep;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cleansweep.entities.ReoccurringTask;

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
		List<ReoccurringTask> result = entityManager.createQuery("from ReoccurringTask", ReoccurringTask.class)
		    .getResultList();
		for (ReoccurringTask task : result) {
			System.out.println("Reoccurring Task " + task.toJSON() + "\n");
		}
//		ReoccurringTask task = entityManager.find(ReoccurringTask.class, 1);
//		System.out.println("Reoccurring Task " + task.toJSON());
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	private void tearDown() {
		entityManagerFactory.close();
	}
}
