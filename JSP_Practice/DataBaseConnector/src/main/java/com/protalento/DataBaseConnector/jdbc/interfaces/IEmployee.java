package com.protalento.DataBaseConnector.jdbc.interfaces;

import com.protalento.DataBaseConnector.entities.Document;
import com.protalento.DataBaseConnector.entities.Employee;

public interface IEmployee extends DAOGeneric<Employee, Document> {
	public abstract void saveListToCSV(String fileName);
}
