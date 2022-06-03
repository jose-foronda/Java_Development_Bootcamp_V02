package JDBC.bankModel.DAO;

import java.util.List;

public interface DAO<E, K> {
	
	public abstract E keySearch(K key);
	
	public abstract boolean update(E element);
	
	public abstract boolean delete(E element);
	
	public abstract boolean insert(E element);
	
	public abstract List<E> listElements();
}
