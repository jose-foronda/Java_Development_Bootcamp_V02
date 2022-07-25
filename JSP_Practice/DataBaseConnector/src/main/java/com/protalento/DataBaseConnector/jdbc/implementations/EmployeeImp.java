package com.protalento.DataBaseConnector.jdbc.implementations;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.protalento.DataBaseConnector.Utilities.LocalDateUtilities;
import com.protalento.DataBaseConnector.entities.Document;
import com.protalento.DataBaseConnector.entities.Employee;
import com.protalento.DataBaseConnector.enums.DocumentType;
import com.protalento.DataBaseConnector.jdbc.connections.ConnectionMariaDB;
import com.protalento.DataBaseConnector.jdbc.interfaces.IEmployee;

public final class EmployeeImp implements IEmployee, ConnectionMariaDB{
	private Logger logger = LogManager.getLogger();
	
	private PreparedStatement preparedStatementSearchById;
	private PreparedStatement preparedStatementInsert;
	private PreparedStatement preparedStatementModify;
	private PreparedStatement preparedStatementDelete;
	private PreparedStatement preparedStatementList;
	private PreparedStatement preparedStatementSaveToCSV;
	
	@Override
	public Employee searchByKey(Document document) {
		Employee employee = null;
		String sql = "select name, lastName, age, birthDate from employees where documentType = ? and documentNumber = ?;";
		try {
			if (null == preparedStatementSearchById) {
				preparedStatementSearchById = getMariaDBConnection().prepareStatement(sql);
			}

			preparedStatementSearchById.setString(1, document.getType().toString());
			preparedStatementSearchById.setString(2, document.getNumber());

			ResultSet resultSet = preparedStatementSearchById.executeQuery();

			if (resultSet.next()) {
				employee = new Employee();
				employee.setDocument(document);
				employee.setName(resultSet.getString("name"));
				employee.setLastName(resultSet.getString("lastName"));
				employee.setAge(resultSet.getInt("age"));
				employee.setBirthDate(LocalDate.parse(resultSet.getString("birthDate"), LocalDateUtilities.getDateTimeFormatter(LocalDateUtilities.SQL_DATE_PATTERN)));
			}
			
			logger.debug(preparedStatementSearchById);

			logger.info(employee);
		} catch (SQLException e) {
			logger.error(e);
		} 
	
		return employee;
	}

	@Override
	public boolean insert(Employee employee) {
 		String sql = "insert into employees (documentType, documentNumber, name, lastName, age, birthDate) values (?, ?, ?, ?, ?, ?);";
		try {
			if (null == preparedStatementInsert) {
				preparedStatementInsert = getMariaDBConnection().prepareStatement(sql);
			}

			preparedStatementInsert.setString(1, employee.getDocument().getType().toString());
			preparedStatementInsert.setString(2, employee.getDocument().getNumber());
			preparedStatementInsert.setString(3, employee.getName());
			preparedStatementInsert.setString(4, employee.getLastName());
			preparedStatementInsert.setInt(5, employee.getAge());
			preparedStatementInsert.setString(6, employee.getBirthDate().format(LocalDateUtilities.getDateTimeFormatter(LocalDateUtilities.SQL_DATE_PATTERN)));
			
			logger.info(preparedStatementInsert);
			
			return preparedStatementInsert.executeUpdate() == 1;
 
		} catch (SQLException e) {
			logger.error(e);
		} 
	
		return false;
	}

	@Override
	public boolean modify(Employee employee) {
 		String sql = "update employees set  name = ?, lastName = ?, age = ?, birthDate = ? where documentType = ? and  documentNumber = ?;";
		try {
			if (null == preparedStatementModify) {
				preparedStatementModify = getMariaDBConnection().prepareStatement(sql);
			}


			preparedStatementModify.setString(1, employee.getName());
			preparedStatementModify.setString(2, employee.getLastName());
			preparedStatementModify.setInt(3, employee.getAge());
			preparedStatementModify.setString(4, employee.getBirthDate().format(LocalDateUtilities.getDateTimeFormatter(LocalDateUtilities.SQL_DATE_PATTERN)));
			preparedStatementModify.setString(5, employee.getDocument().getType().toString());
			preparedStatementModify.setString(6, employee.getDocument().getNumber());
			
			logger.info(preparedStatementModify);
			
			return preparedStatementModify.executeUpdate() == 1;
 
		} catch (SQLException e) {
			logger.error(e);
		} 
	
		return false;
	}

	@Override
	public boolean delete(Employee employee) {
		String sql = "delete from employees where documentType = ? and documentNumber = ?;";
		
		try {
			if (preparedStatementDelete == null) {
				preparedStatementDelete = getMariaDBConnection().prepareStatement(sql);
			}
			
			preparedStatementDelete.setString(1, employee.getDocument().getType().toString());
			preparedStatementDelete.setString(2, employee.getDocument().getNumber());
			
			logger.info(preparedStatementDelete);
			return preparedStatementDelete.executeUpdate() == 1;
			
		} catch (SQLException e) { 
			logger.error(e);
		}
		return false;
	}

	@Override
	public List<Employee> list() {
		List<Employee> employeesList = new ArrayList<Employee>();
		
		String sql = "select documentType, documentNumber, name, lastName, age, birthDate from employees;";
		
		try {
			preparedStatementList = getMariaDBConnection().prepareStatement(sql);
			
			ResultSet resultSet = preparedStatementList.executeQuery();
			
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setDocument(new Document(DocumentType.valueOf(resultSet.getString("documentType")), resultSet.getString("documentNumber")));
				employee.setName(resultSet.getString("name"));
				employee.setLastName(resultSet.getString("lastName"));
				employee.setAge(resultSet.getInt("age"));
				employee.setBirthDate(LocalDate.parse(resultSet.getString("birthDate"), LocalDateUtilities.getDateTimeFormatter(LocalDateUtilities.SQL_DATE_PATTERN)));
				
				//adds an employee
				employeesList.add(employee);
			}
			
		} catch (SQLException e) { 
			logger.error(e);
		}
		
		return employeesList;
	}
	
	@Override
	public void saveListToCSV(String fileName) { 		
		String sql = "select documentType, documentNumber, name, lastName, age, birthDate from employees;";
		
		try {
			preparedStatementSaveToCSV = getMariaDBConnection().prepareStatement(sql);
			
			ResultSet resultSet = preparedStatementSaveToCSV.executeQuery(); 
			
////			Appendable outFile = new FileWriter("myFirstCSV.csv");
//			File outFile = new File("myFirstCSV.csv")
//			CSVFormat csvFormat = CSVFormat.EXCEL;
//			CSVPrinter csvPrinter = csvFormat.print(outFile);
//			csvPrinter.printHeaders(resultSet);  
//			csvPrinter.printRecords(resultSet);
//			csvPrinter.flush();
			
			
			/**
			 * Source is https://mvnrepository.com/artifact/org.apache.commons/commons-csv/1.9.0
			 * https://commons.apache.org/proper/commons-csv/
			 * https://commons.apache.org/proper/commons-csv/apidocs/index.html
			 */
			
//			Appendable outFile = new FileWriter("myFirstCSV.csv");
			
//			public static final File propertiesFile = FileSystems.getDefault().getPath("src", "main", "myResources", "database.properties").toFile();
			//File outFile = FileSystems.getDefault().getPath("src", "main", "UserGeneratedCSVs", fileName).toFile();
			File outFile = FileSystems.getDefault().getPath(fileName).toFile();
			logger.info(outFile.getAbsolutePath());

//			File outFile = new File("GeneratedFiles"+ File.separator + "myFirstCSV.csv");
			CSVFormat csvFormat = CSVFormat.EXCEL;
			CSVPrinter csvPrinter = csvFormat.print(outFile, StandardCharsets.UTF_16LE);
			csvPrinter.printHeaders(resultSet);  
			csvPrinter.printRecords(resultSet);
			csvPrinter.flush();
	
		} catch (SQLException e) { 
			logger.error(e);
		} catch (IOException e) { 
			logger.error(e);
		} 		
	}
	
	
	
	
	
	
	
//	public static void main(String[] args) {
//		LocalDate date = LocalDate.parse("01/07/1993", LocalDateUtilities.getDateTimeFormatter(LocalDateUtilities.SYS_FORMATTER));
//		
//		System.out.println(date.format(LocalDateUtilities.getDateTimeFormatter(LocalDateUtilities.SYS_FORMATTER)));
//		System.out.println(date.format(LocalDateUtilities.getDateTimeFormatter(LocalDateUtilities.SQL_DATE_PATTERN)));
//	}
	
//	public static void main(String[] args) {
//		EmployeeImp employeeImp = new EmployeeImp();
//		
//		Employee employee1 = new Employee();
//		employee1.setDocument(new Document(DocumentType.CC, "1097400296"));
//		employee1.setName("Jose");
//		employee1.setLastName("Foronda Melo");
//		employee1.setAge(29);
//		employee1.setBirthDate(LocalDate.parse("11/07/1993", LocalDateUtilities.getDateTimeFormatter(LocalDateUtilities.SYS_FORMATTER)));
//		
//		Employee employee2 = new Employee();
//		employee2.setDocument(new Document(DocumentType.TI, "24579999"));
//		employee2.setName("Santi");
//		employee2.setLastName("Melo");
//		employee2.setAge(5);
//		employee2.setBirthDate(LocalDate.parse("14/03/2017", LocalDateUtilities.getDateTimeFormatter(LocalDateUtilities.SYS_FORMATTER)));
//		
//		System.out.println(employee1);
//		
//		//Inserting an element
//		//System.out.println("Employee inserted? " + employeeImp.insert(employee2));
//		
//		//Searching an element
//		//System.out.println("searched the element= " + employeeImp.searchByKey(employee1.getDocument()));
//		
//		
//		//Modifying an element
//		//System.out.println("modified the element? " + employeeImp.modify(employee1));
//		
//		//Deleting an element
//		//System.out.println("deleted the element:" + employeeImp.delete(employee1));
//		
//		//Listing the elements
//		for (Employee employee : employeeImp.list()) {
//			System.out.println(employee);
//		}
//		
//	}
	
	
	public static void main(String[] args) {
		EmployeeImp employeeImp = new EmployeeImp();
		//Listing the elements
		for (Employee employee : employeeImp.list()) {
			System.out.println(employee);
		}
		
		employeeImp.saveListToCSV("mySecondCSV.csv");
	}



}
