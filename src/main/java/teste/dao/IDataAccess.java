package teste.dao;

import java.util.List;

public interface IDataAccess<T> {
	
	public Integer create(T object);
	public T retrieve(Class<T> type, Integer id);
	public List<T> retrieveAll(Class<T> type);
	public void update(T object);
	public void delete(T object);

}
