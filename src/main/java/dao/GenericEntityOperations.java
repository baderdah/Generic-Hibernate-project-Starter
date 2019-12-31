package dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import jpa.MyEntityManagerFactory;

/*
 * @author dahBader
 * @version 1.0.1
 * this class is a implementation of IGnericEntityOpreations
 */

public class GenericEntityOperations implements IGenericEntityOperations {
	
	EntityManager em ;
	EntityTransaction t ;
	
	public GenericEntityOperations() {
		em = MyEntityManagerFactory.getEntityManager();
		t = MyEntityManagerFactory.getEntityTransaction();
	}
	
	public <E> void save(E entity) {
		try {
			if(!t.isActive()) {
				t.begin();
			}
			em.persist(entity);
			t.commit();
		}catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		}
	}

	
	public <E> void merge(E entity) {
		try {
			if(!t.isActive()) {
				t.begin();
			}
			em.merge(entity);
			t.commit();
		}catch (Exception e) {
			e.printStackTrace();
			MyEntityManagerFactory.getEntityTransaction().rollback();
		}
	}


	public <E, T> E findById(Class<E> type ,T primaryKey) {
		
		E entityFound  = MyEntityManagerFactory.getEntityManager().find(type, primaryKey);

		return entityFound;
	}


	public <E, T> void delete(Class<E> type, T primaryKey) {
		try {
			if(!t.isActive()) { t.begin(); }
			
			E ourEntity = findById(type, primaryKey);
			if(ourEntity != null) {
				em.remove(ourEntity);
				t.commit();
			}			
		}catch (Exception e) {
			MyEntityManagerFactory.getEntityTransaction().rollback();
			e.printStackTrace();
		}
	}
	

	public <E> List<E> findAll(Class<E> type) {
		String typeName = type.getName();
		List<E> result =  MyEntityManagerFactory
				.getEntityManager()
				.createQuery("from " + typeName, type ).getResultList();
		return  result;
	}


}
