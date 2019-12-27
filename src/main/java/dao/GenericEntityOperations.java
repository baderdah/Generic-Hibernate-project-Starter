package dao;
import java.util.List;

import jpa.MyEntityManagerFactory;

/*
 * @author dahBader
 * @version 1.0.0
 * this class is a implementation of IGnericEntityOpreations
 */

public class GenericEntityOperations implements IGenericEntityOperations {
	
	
	public <E> void save(E entity) {
		try {
			MyEntityManagerFactory.getEntityManager().persist(entity);
			MyEntityManagerFactory.getEntityTransaction().commit();
		}catch (Exception e) {
			MyEntityManagerFactory.getEntityTransaction().rollback();
		}
	}

	
	public <E> void merge(E entity) {
		try {
			MyEntityManagerFactory.getEntityManager().merge(entity);
			MyEntityManagerFactory.getEntityTransaction().commit();
		}catch (Exception e) {
			MyEntityManagerFactory.getEntityTransaction().rollback();
		}
	}


	public <E, T> E findById(Class<E> type ,T primaryKey) {
		
		E entityFound  = MyEntityManagerFactory.getEntityManager().find(type, primaryKey);

		return entityFound;
	}


	public <E, T> void delete(Class<E> type, T primaryKey) {
		try {
			E ourEntity = findById(type, primaryKey);
			if(ourEntity != null) {
				MyEntityManagerFactory.getEntityManager().remove(ourEntity);
				MyEntityManagerFactory.getEntityTransaction().commit();
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
