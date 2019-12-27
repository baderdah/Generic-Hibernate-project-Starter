package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/*
 * this class provide entity manager and entity transaction 
 */
public class MyEntityManagerFactory {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction transaction;
	
	/*
	 * this method initiate our Entity manger 
	 */
	private static void initMyEntityManagerFactory() {
		entityManagerFactory = Persistence.createEntityManagerFactory("UP_CAT");
		entityManager =  entityManagerFactory.createEntityManager();
	}
	
	/*
	 * this method initiate our Transaction 
	 */
	private static void initTransaction() {
		transaction = getEntityManager().getTransaction();
	}
	
	/*
	 * this method initiate the entity manager one time and 
	 * then we can use the same entityManager in all the next calls 
	 */
	public static EntityManager getEntityManager() {
		if(entityManager == null) { 
			initMyEntityManagerFactory();
		}
		return entityManager;
	}
	/*
	 * this method initiate the transaction one time and 
	 * then we can use the same transaction in all the next calls 
	 */
	public static EntityTransaction getEntityTransaction() {
		if(transaction == null) {
			initTransaction();
		}
		if(!transaction.isActive()) {
			transaction.begin();
		}
		return transaction;
	}
}
