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
import JDBC.bankModel.entities.HierarchyEmployee;
import JDBC.bankModel.utilities.DatesUtilities;

public class HierarchyEmployeeImpl implements DAO<HierarchyEmployee, Integer>, ConnectionMariaDB{
	Connection connectionMariaDB = null;
	
	PreparedStatement preparedStatementKeySearch = null;
	PreparedStatement preparedStatementUpdate = null;
	PreparedStatement preparedStatementDelete = null;
	PreparedStatement preparedStatementInsert = null;
	PreparedStatement preparedStatementList = null;
	
	@Override
	public HierarchyEmployee keySearch(Integer key) { 
		checkMariaDBConnection();
		
		HierarchyEmployee hierarchyEmployee = new HierarchyEmployee();
		hierarchyEmployee.setSubAlternEmployee(new Employee());
		hierarchyEmployee.setEmployeeBossList(new ArrayList<Employee>());
		
  		
		String sql = "select he.*, e.name as boss_name, e.phone_number as boss_phone_number, e.start_date as boss_start_date  \r\n"
				+ "from (select subaltern.*, boss.Employee_boss_id from (select e1.id, e1.name, e1.phone_number, e1.start_date  from employees e1 where e1.id <=> ?) as subaltern\r\n"
				+ "  inner join\r\n"
				+ "(select eh.* from employees_hierarchy as eh where eh.Employee_subaltern_id <=> ?) as boss) as he \r\n"
				+ "inner join \r\n"
				+ "(select employees.* from employees) as e on he.Employee_boss_id <=> e.id ;";
		
		try {
			
			if (Objects.equals(preparedStatementKeySearch, null)) {
				preparedStatementKeySearch = connectionMariaDB.prepareStatement(sql);
			}
			
			preparedStatementKeySearch.setInt(1, key);
			preparedStatementKeySearch.setInt(2, key);
			ResultSet dataRead = preparedStatementKeySearch.executeQuery();
			
			int subAlternId = 0;
			String nameSubaltern = null;
			String subAlternPhoneNumber = null;
			LocalDate subAlternStartDate = null;
			
			int bossId = 0;
			String nameBoss = null;
			String bossPhoneNumber = null;
			LocalDate bossStartDate = null;
			while (dataRead.next()) {
				
				subAlternId = dataRead.getInt("id");
				nameSubaltern = dataRead.getString("name");
				subAlternPhoneNumber = dataRead.getString("phone_number");
				subAlternStartDate = LocalDate.parse(dataRead.getString("start_date"), DatesUtilities.getDateTimeFormatter(DatesUtilities.getSQLformat()));
				
				hierarchyEmployee.getSubAlternEmployee().setId(subAlternId);
				hierarchyEmployee.getSubAlternEmployee().setName(nameSubaltern);
				hierarchyEmployee.getSubAlternEmployee().setPhoneNumber(subAlternPhoneNumber);
				hierarchyEmployee.getSubAlternEmployee().setHiringDate(subAlternStartDate);
				
				bossId = dataRead.getInt("Employee_boss_id");
				nameBoss = dataRead.getString("boss_name");
				bossPhoneNumber = dataRead.getString("boss_phone_number");
				bossStartDate = LocalDate.parse(dataRead.getString("boss_start_date"), DatesUtilities.getDateTimeFormatter(DatesUtilities.getSQLformat()));
				
				hierarchyEmployee.getEmployeeBossList().add(new Employee(nameBoss, bossId, bossPhoneNumber, bossStartDate));

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		return hierarchyEmployee;
	}

	@Override
	public boolean update(HierarchyEmployee element) {
 		checkMariaDBConnection();
		
		String sql = "update employees_hierarchy set Employee_boss_id = ? where Employee_subaltern_id <=> ? and Employee_boss_id <=> ?;";
		
 		try {
			if (Objects.equals(preparedStatementUpdate, null)) {
				preparedStatementUpdate = connectionMariaDB.prepareStatement(sql);
			}
			  
			preparedStatementUpdate.setInt(1, element.getEmployeeBossList().get(1).getId());
			preparedStatementUpdate.setInt(2, element.getSubAlternEmployee().getId());
			preparedStatementUpdate.setInt(3, element.getEmployeeBossList().get(0).getId());
			return preparedStatementUpdate.executeUpdate() != 0;
 			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(HierarchyEmployee element) {
		checkMariaDBConnection();
		
		String sql = "delete from employees_hierarchy where Employee_subaltern_id <=> ? and Employee_boss_id <=> ?;";
		
		try {
			if (Objects.equals(preparedStatementDelete, null)) {
				preparedStatementDelete = connectionMariaDB.prepareStatement(sql);
			} 
			 
			preparedStatementDelete.setInt(1, element.getSubAlternEmployee().getId()); 
			preparedStatementDelete.setInt(2, element.getEmployeeBossList().get(0).getId());
			
			return preparedStatementDelete.executeUpdate() != 0;
		} catch (SQLException e) { 
			e.printStackTrace();
		};
		return false;
	}

	@Override
	public boolean insert(HierarchyEmployee element) {
		Connection connectionMariaDB = getMariaDBConnection();
		checkMariaDBConnection();
		
		String sql = "INSERT into employees_hierarchy (Employee_subaltern_id, Employee_boss_id) VALUES (?, ?);";
		
		try {
			if (Objects.equals(preparedStatementInsert, null)) {
				preparedStatementInsert = connectionMariaDB.prepareStatement(sql);
			} 

			preparedStatementInsert.setInt(1, element.getSubAlternEmployee().getId());
			preparedStatementInsert.setInt(2, element.getEmployeeBossList().get(0).getId()); 
		
			return preparedStatementInsert.executeUpdate() != 0;
		} catch (SQLException e) { 
			e.printStackTrace();
		};
		return false;
		
	}

	@Override
	public List<HierarchyEmployee> listElements() { 
		List<HierarchyEmployee> list = new ArrayList<HierarchyEmployee>(); 
		checkMariaDBConnection();
		
		String sql = "select emp.*, boss_emp.name as boss_name, boss_emp.phone_number as boss_phone_number, boss_emp.start_date as boss_start_date from (select emp.*, eh.Employee_boss_id  from (select * from employees) as emp \r\n"
				+ "inner join\r\n"
				+ "(select employees_hierarchy.* from employees_hierarchy) as eh on emp.id <=> eh.Employee_subaltern_id) as emp\r\n"
				+ "inner join\r\n"
				+ "(select * from employees) as boss_emp on emp.Employee_boss_id <=> boss_emp.id;";
					
		try {
			if (Objects.equals(preparedStatementList, null)) {
				preparedStatementList = connectionMariaDB.prepareStatement(sql); 
			} 
			ResultSet readData = preparedStatementList.executeQuery();
			
			Integer subAlternId = 0;
			String nameSubaltern = null;
			String subAlternPhoneNumber = null;
			LocalDate subAlternStartDate = null;
			
			Integer bossId = 0;
			String nameBoss = null;
			String bossPhoneNumber = null;
			LocalDate bossStartDate = null;
			
			Integer lastSubAlternId = null;
		
 			while (readData.next()) {   
 				subAlternId = readData.getInt("id");
 				nameSubaltern = readData.getString("name");
 				subAlternPhoneNumber = readData.getString("phone_number");
 				subAlternStartDate = LocalDate.parse(readData.getString("start_date"), DatesUtilities.getDateTimeFormatter(DatesUtilities.getSQLformat()));
				
 				
				bossId = readData.getInt("Employee_boss_id");
				nameBoss = readData.getString("boss_name");
				bossPhoneNumber = readData.getString("boss_phone_number");
				bossStartDate = LocalDate.parse(readData.getString("boss_start_date"), DatesUtilities.getDateTimeFormatter(DatesUtilities.getSQLformat()));
				
				if (subAlternId.equals(lastSubAlternId) && list.size() > 0) { 
					
					int hierarchyListSize = list.size() - 1;
					list.get(hierarchyListSize).getEmployeeBossList().add(new Employee(nameBoss, bossId, bossPhoneNumber, bossStartDate));
					
 				}else {
				
					HierarchyEmployee hierarchyEmployeeRead = new HierarchyEmployee();
					hierarchyEmployeeRead.setSubAlternEmployee((new Employee(nameSubaltern, subAlternId, subAlternPhoneNumber, subAlternStartDate)));
					
					List<Employee> hierarchyEmployeeReadList = new ArrayList<Employee>();
					hierarchyEmployeeReadList.add(new Employee(nameBoss, bossId, bossPhoneNumber, bossStartDate));
					hierarchyEmployeeRead.setEmployeeBossList(hierarchyEmployeeReadList);
					 
 					list.add(hierarchyEmployeeRead);
 					lastSubAlternId = subAlternId;
				}
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
