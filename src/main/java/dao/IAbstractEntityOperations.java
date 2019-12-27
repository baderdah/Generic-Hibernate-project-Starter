package dao;

public interface IAbstractEntityOperations {

	public <E> void save(E entity) ;
	public <E> void merge(E entity);
	public <E, T> E findById(T primaryKey);
	public <E> void findAll(E entity);
	public <E, T> void delete(T primaryKey);
	
}
