package dao;

import java.util.List;

public interface IGenericEntityOperations {

	public <E> void save(E entity) ;
	public <E> void merge(E entity);
	public <E, T> E findById(Class<E> type ,T primaryKey);
	public <E> List<E> findAll(Class<E> type) ;
	public <E, T> void delete(Class<E> type ,T primaryKey);
	
}
