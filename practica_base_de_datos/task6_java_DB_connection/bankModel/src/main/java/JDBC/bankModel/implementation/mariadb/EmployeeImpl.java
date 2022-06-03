package JDBC.bankModel.implementation.mariadb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import JDBC.bankModel.DAO.DAO;
import JDBC.bankModel.database_connections.ConnectionMariaDB;
import JDBC.bankModel.entities.Employee;
import JDBC.bankModel.utilities.DatesUtilities;

public final class EmployeeImpl implements DAO<Employee, Integer>, ConnectionMariaDB {

	Connection connectionMariaDB = null;
	
	PreparedStatement preparedStatementKeySearch = null;
	PreparedStatement preparedStatementUpdate = null;
	PreparedStatement preparedStatementDelete = null;
	PreparedStatement preparedStatementInsert = null;
	PreparedStatement preparedStatementList = null;
	
	@Override
	public Employee keySearch(Integer key) { 
		checkMariaDBConnection();
		
		String employeeName = null;
		String employeePhoneNumber = null;
		LocalDate employeeHiringDate = null;
		
		String sql = "select id, name, phone_number, start_date from employees where  id <=> ?;";
		try {
			
			if (Objects.equals(preparedStatementKeySearch, null)) {
				preparedStatementKeySearch = connectionMariaDB.prepareStatement(sql);
			}
			
			preparedStatementKeySearch.setInt(1, key);
			ResultSet dataRead = preparedStatementKeySearch.executeQuery();
			
			if (dataRead.next()) {
				employeeName = dataRead.getString("name");
				employeePhoneNumber = dataRead.getString("phone_number");
				employeeHiringDate = LocalDate.parse(dataRead.getDate("start_date").toString(), DatesUtilities.getDateTimeFormatter(DatesUtilities.getSQLformat())) ;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new Employee(employeeName, key, employeePhoneNumber, employeeHiringDate);
	}

	@Override
	public boolean update(Employee element) {
//		Connection connectionMariaDB = getMariaDBConnection();
		checkMariaDBConnection();
		
		String sql = "update employees set name = ?, phone_number = ?, start_date = ?  where id <=> ?;";
		
		try {
			if (Objects.equals(preparedStatementUpdate, null)) {
				preparedStatementUpdate = connectionMariaDB.prepareStatement(sql);
			}
			preparedStatementUpdate.setString(1, element.getName());
			preparedStatementUpdate.setString(2, element.getPhoneNumber());
			preparedStatementUpdate.setString(3, element.getHiringDate().format(DatesUtilities.getDateTimeFormatter(DatesUtilities.getSQLformat())));
			preparedStatementUpdate.setInt(4, element.getId());
			
			return preparedStatementUpdate.executeUpdate() != 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Employee element) {
//		Connection connectionMariaDB = getMariaDBConnection();
		checkMariaDBConnection();
		
		String sql = "delete from employees where id <=> ?;";
		
		try {
			if (Objects.equals(preparedStatementDelete, null)) {
				preparedStatementDelete = connectionMariaDB.prepareStatement(sql);
			} 
			preparedStatementDelete.setInt(1, element.getId());
			
			return preparedStatementDelete.executeUpdate() != 0;
		} catch (SQLException e) { 
			e.printStackTrace();
		};
		return false;
	}

	@Override
	public boolean insert(Employee element) {
//		Connection connectionMariaDB = getMariaDBConnection();
		checkMariaDBConnection();
		
		String sql = "INSERT into employees (name, phone_number, start_date) values ( ?, ?, ?);";
		
		try {
			if (Objects.equals(preparedStatementInsert, null)) {
				preparedStatementInsert = connectionMariaDB.prepareStatement(sql);
			} 
			preparedStatementInsert.setString(1, element.getName());
			preparedStatementInsert.setString(2, element.getPhoneNumber());
			preparedStatementInsert.setString(3, element.getHiringDate().format(DatesUtilities.getDateTimeFormatter(DatesUtilities.getSQLformat())));
		
			return preparedStatementInsert.executeUpdate() != 0;
		} catch (SQLException e) { 
			e.printStackTrace();
		};
		return false;
		
	}

	@Override
	public List<Employee> listElements() { 
		List<Employee> list = new ArrayList<Employee>(); 
		
		checkMariaDBConnection();
		
		String sql = "select id, name, phone_number, start_date from employees;";
		
		String employeeName;
		int employeeId;
		String employeePhoneNumber;
		LocalDate employeeHiringDate;
		try {
			if (Objects.equals(preparedStatementList, null)) {
				preparedStatementList = connectionMariaDB.prepareStatement(sql); 
			} 
			ResultSet readData = preparedStatementList.executeQuery();
			
			while (readData.next()) { 
				employeeName = readData.getString("name");
				employeeId = readData.getInt("id");
				employeePhoneNumber = readData.getString("phone_number");
				employeeHiringDate = LocalDate.parse(readData.getDate("start_date").toString(), DatesUtilities.getDateTimeFormatter(DatesUtilities.getSQLformat()));
				list.add(new Employee(employeeName, employeeId, employeePhoneNumber, employeeHiringDate));
			}
			
		} catch (SQLException e) { 
			e.printStackTrace();
		};
		return list;
	}
	
	private void checkMariaDBConnection() {
		if (Objects.equals(connectionMariaDB, null)) {
			connectionMariaDB = getMariaDBConnection();
		}
	}
}
