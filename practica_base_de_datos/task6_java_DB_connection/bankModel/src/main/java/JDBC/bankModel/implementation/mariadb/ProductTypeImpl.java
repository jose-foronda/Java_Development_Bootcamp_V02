package JDBC.bankModel.implementation.mariadb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import JDBC.bankModel.DAO.DAO;
import JDBC.bankModel.database_connections.ConnectionMariaDB;
import JDBC.bankModel.entities.ProductType;

public class ProductTypeImpl implements DAO<ProductType, Integer>, ConnectionMariaDB {
	//Connection interface
	private Connection connectionMariaDB = null;
	
	//prepared statements
	private PreparedStatement preparedStatementKeySearch = null;
	private PreparedStatement preparedStatementUpdate = null;
	private PreparedStatement preparedStatementDelete = null;
	private PreparedStatement preparedStatementInsert = null;
	private PreparedStatement preparedStatementList = null;
	
	@Override
	public ProductType keySearch(Integer key) { 
		checkMariaDBConnection();
		
		String productTypeName = null;
		
		String sql = "select name from bank_products where  id <=> ?";
		try {
			
			if (Objects.equals(preparedStatementKeySearch, null)) {
				preparedStatementKeySearch = connectionMariaDB.prepareStatement(sql);
			}
			
			preparedStatementKeySearch.setInt(1, key);
			ResultSet dataRead = preparedStatementKeySearch.executeQuery();
			
			if (dataRead.next()) {
				productTypeName = dataRead.getString("name");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new ProductType(key, productTypeName);
	}

	@Override
	public boolean update(ProductType element) {
//		Connection connectionMariaDB = getMariaDBConnection();
		checkMariaDBConnection();
		
		String sql = "update bank_products set name = ? where id <=> ?;";
		
		try {
			if (Objects.equals(preparedStatementUpdate, null)) {
				preparedStatementUpdate = connectionMariaDB.prepareStatement(sql);
			}
			preparedStatementUpdate.setString(1, element.getName());
			preparedStatementUpdate.setInt(2, element.getId());
			
			return preparedStatementUpdate.executeUpdate() != 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(ProductType element) {
//		Connection connectionMariaDB = getMariaDBConnection();
		checkMariaDBConnection();
		
		String sql = "delete from bank_products where id <=> ?;";
		
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
	public boolean insert(ProductType element) {
//		Connection connectionMariaDB = getMariaDBConnection();
		checkMariaDBConnection();
		
		String sql = "INSERT INTO eduIT_labDB_BanKModel.bank_products (name) values (?);";
		
		try {
			if (Objects.equals(preparedStatementInsert, null)) {
				preparedStatementInsert = connectionMariaDB.prepareStatement(sql);
			} 
			preparedStatementInsert.setString(1, element.getName());
			
			return preparedStatementInsert.executeUpdate() != 0;
		} catch (SQLException e) { 
			e.printStackTrace();
		};
		return false;
		
	}

	@Override
	public List<ProductType> listElements() { 
		List<ProductType> list = new ArrayList<ProductType>();
//		Connection connectionMariaDB = getMariaDBConnection();
		checkMariaDBConnection();
		
		String sql = "select id, name from bank_products;";
		
		try {
			if (Objects.equals(preparedStatementList, null)) {
				preparedStatementList = connectionMariaDB.prepareStatement(sql); 
			} 
			ResultSet readData = preparedStatementList.executeQuery();
			
			while (readData.next()) { 
				list.add(new ProductType( readData.getInt("id"), readData.getString("name") ));
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
