package dao;

import jpa.MyEntityManagerFactory;

public class AbstractEntityOperations implements IAbstractEntityOperations {
	

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

	public <E, T> E findById(T primaryKey) {
		E entityFound = null;
		try {
			Class<E> typeOfOurEntity = null;
			entityFound = MyEntityManagerFactory.getEntityManager().find(typeOfOurEntity , primaryKey);
			MyEntityManagerFactory.getEntityTransaction().commit();
		}catch (Exception e) {
			MyEntityManagerFactory.getEntityTransaction().rollback();
		}
		return entityFound;
	}


	public <E, T> void delete(T primaryKey) {
		try {
			E ourEntity = findById(primaryKey);
			MyEntityManagerFactory.getEntityManager().remove(ourEntity);
			MyEntityManagerFactory.getEntityTransaction().commit();
		}catch (Exception e) {
			MyEntityManagerFactory.getEntityTransaction().rollback();
		}
	}
	
	public <E> void findAll(E entity) {

	}

}
