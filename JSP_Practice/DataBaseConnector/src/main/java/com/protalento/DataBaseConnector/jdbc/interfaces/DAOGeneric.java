package com.protalento.DataBaseConnector.jdbc.interfaces;

import java.util.List;

public interface DAOGeneric<E, K> {
	
	public abstract E searchByKey(K k);
	
	public abstract boolean insert(E e);
	
	public abstract boolean modify(E e);
	
	public abstract boolean delete(E e); 
	
	public abstract List<E> list();
}
