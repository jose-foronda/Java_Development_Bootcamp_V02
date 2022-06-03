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
import JDBC.bankModel.entities.City;

public final class CityImpl implements DAO<City, Integer>, ConnectionMariaDB {

	Connection connectionMariaDB = null;
	
	PreparedStatement preparedStatementKeySearch = null;
	PreparedStatement preparedStatementUpdate = null;
	PreparedStatement preparedStatementDelete = null;
	PreparedStatement preparedStatementInsert = null;
	PreparedStatement preparedStatementList = null;
	
	@Override
	public City keySearch(Integer key) { 
		checkMariaDBConnection();
		
		String cityName = null;
		
		String sql = "select name from cities where  id <=> ?;";
		try {
			
			if (Objects.equals(preparedStatementKeySearch, null)) {
				preparedStatementKeySearch = connectionMariaDB.prepareStatement(sql);
			}
			
			preparedStatementKeySearch.setInt(1, key);
			ResultSet dataRead = preparedStatementKeySearch.executeQuery();
			
			if (dataRead.next()) {
				cityName = dataRead.getString("name");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new City(key, cityName);
	}

	@Override
	public boolean update(City element) {
//		Connection connectionMariaDB = getMariaDBConnection();
		checkMariaDBConnection();
		
		String sql = "update cities set name = ? where id <=> ?;";
		
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
	public boolean delete(City element) {
//		Connection connectionMariaDB = getMariaDBConnection();
		checkMariaDBConnection();
		
		String sql = "delete from cities where id <=> ?;";
		
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
	public boolean insert(City element) {
//		Connection connectionMariaDB = getMariaDBConnection();
		checkMariaDBConnection();
		
		String sql = "INSERT INTO eduIT_labDB_BanKModel.cities (name) values (?);";
		
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
	public List<City> listElements() { 
		List<City> list = new ArrayList<City>();
//		Connection connectionMariaDB = getMariaDBConnection();
		checkMariaDBConnection();
		
		String sql = "select id, name from cities;";
		
		try {
			if (Objects.equals(preparedStatementList, null)) {
				preparedStatementList = connectionMariaDB.prepareStatement(sql); 
			} 
			ResultSet readData = preparedStatementList.executeQuery();
			
			while (readData.next()) { 
				list.add(new City( readData.getInt("id"), readData.getString("name") ));
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
