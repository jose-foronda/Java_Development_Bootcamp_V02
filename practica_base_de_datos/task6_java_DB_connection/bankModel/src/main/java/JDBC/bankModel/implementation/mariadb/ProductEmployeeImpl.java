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
import JDBC.bankModel.entities.Client;
import JDBC.bankModel.entities.Employee;
import JDBC.bankModel.entities.Product;
import JDBC.bankModel.utilities.DatesUtilities;

public class ProductEmployeeImpl implements DAO<Client, String>, ConnectionMariaDB{
	Connection connectionMariaDB = null;
	
	PreparedStatement preparedStatementKeySearch = null;
	PreparedStatement preparedStatementUpdate = null;
	PreparedStatement preparedStatementDelete = null;
	PreparedStatement preparedStatementInsert = null;
	PreparedStatement preparedStatementList = null;
	
	@Override
	public Client keySearch(String key) { 
		checkMariaDBConnection();
		
		List<Product> productList = new ArrayList<Product>();
		List<Employee> employeeList = new ArrayList<Employee>();
		
		int employeeId = 0;
		String employeeName = null;
		String employeePhoneNumber = null; 
  		  
		String sql = "select id, name, phone_number from employees where id in" + 
		"(select employees_id from employees_and_clientproducts where client_products_id <=> ?);";
		
		try {
			
			if (Objects.equals(preparedStatementKeySearch, null)) {
				preparedStatementKeySearch = connectionMariaDB.prepareStatement(sql);
			}
			
			preparedStatementKeySearch.setString(1, key);
			ResultSet dataRead = preparedStatementKeySearch.executeQuery();
			
			while (dataRead.next()) {
				employeeId = dataRead.getInt("id");
				employeeName = dataRead.getString("name");
				employeePhoneNumber = dataRead.getString("phone_number");
				
				employeeList.add(new Employee(employeeName, employeeId, employeePhoneNumber, null));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		productList.add(new Product(key, null, employeeList));
		return new Client(null, null, null, null, productList);
	}

	@Override
	public boolean update(Client element) {
 		checkMariaDBConnection();
		
		String sql = "update employees_and_clientproducts set employees_id = ? "
				+ "where client_products_id <=> ? and employees_id <=> ?;";
		
 		try {
			if (Objects.equals(preparedStatementUpdate, null)) {
				preparedStatementUpdate = connectionMariaDB.prepareStatement(sql);
			}
			  
			preparedStatementUpdate.setInt(1, element.getProductList().get(0).getProductEmployees().get(1).getId());
			preparedStatementUpdate.setString(2, element.getProductList().get(0).getId());
			preparedStatementUpdate.setInt(3, element.getProductList().get(0).getProductEmployees().get(0).getId());
			return preparedStatementUpdate.executeUpdate() != 0;
 			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Client element) {
		checkMariaDBConnection();
		
		String sql = "delete from employees_and_clientproducts where client_products_id <=> ? and employees_id <=> ?;";
		
		try {
			if (Objects.equals(preparedStatementDelete, null)) {
				preparedStatementDelete = connectionMariaDB.prepareStatement(sql);
			} 
			 
			preparedStatementDelete.setString(1, element.getProductList().get(0).getId()); 
			preparedStatementDelete.setInt(2, element.getProductList().get(0).getProductEmployees().get(0).getId());
			
			return preparedStatementDelete.executeUpdate() != 0;
		} catch (SQLException e) { 
			e.printStackTrace();
		};
		return false;
	}

	@Override
	public boolean insert(Client element) {
		Connection connectionMariaDB = getMariaDBConnection();
		checkMariaDBConnection();
		
		String sql = " INSERT into employees_and_clientproducts (client_products_id, employees_id) VALUES (?, ?);";
		
		try {
			if (Objects.equals(preparedStatementInsert, null)) {
				preparedStatementInsert = connectionMariaDB.prepareStatement(sql);
			} 

			preparedStatementInsert.setString(1, element.getProductList().get(0).getId());
			preparedStatementInsert.setInt(2, element.getProductList().get(0).getProductEmployees().get(0).getId()); 
		
			return preparedStatementInsert.executeUpdate() != 0;
		} catch (SQLException e) { 
			e.printStackTrace();
		};
		return false;
		
	}

	@Override
	public List<Client> listElements() { 
		List<Client> list = new ArrayList<Client>(); 
		checkMariaDBConnection();
		
		String sql = "select p1.client_products_id, p1.employees_id, p2.name, p2.phone_number, p2.start_date  from (select client_products_id, employees_id from employees_and_clientproducts order by client_products_id) as p1 \r\n"
				+ "inner join \r\n"
				+ "(select employees.* from employees) as p2 on p1.employees_id <=> p2.id ;";
		
		String productId = null;
		int employeeId;
		String employeeName = null;
		String employeePhoneNumber = null;
		LocalDate employeeStartDate = null;
			
		try {
			if (Objects.equals(preparedStatementList, null)) {
				preparedStatementList = connectionMariaDB.prepareStatement(sql); 
			} 
			ResultSet readData = preparedStatementList.executeQuery();
			
			String lastProductId = null;
 			while (readData.next()) {   
				productId = readData.getString("client_products_id");
				employeeId = readData.getInt("employees_id");
				employeeName = readData.getString("name");
				employeePhoneNumber = readData.getString("phone_number");
				employeeStartDate = LocalDate.parse(readData.getString("start_date"), DatesUtilities.getDateTimeFormatter(DatesUtilities.getSQLformat()));
				
				if (productId.equals(lastProductId) && list.size() > 0) { 
					
					int producListSize = list.get(list.size() - 1).getProductList().size() - 1;
					list.get(list.size() - 1).getProductList().get(producListSize).getProductEmployees().add(new Employee(employeeName, employeeId, employeePhoneNumber, employeeStartDate));
				}else {
					
					List<Employee> employeeRead = new ArrayList<Employee>();
					employeeRead.add(new Employee(employeeName, employeeId, employeePhoneNumber, employeeStartDate));
					
					List<Product> productsRead = new ArrayList<Product>();
					productsRead.add(new Product(productId, null, employeeRead));
					
 					Client newClient = new Client(null, null, null, null, productsRead);
					list.add(newClient);
					lastProductId = productId;
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
