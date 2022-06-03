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
import JDBC.bankModel.entities.Client;

public final class ClientImpl implements DAO<Client, String>, ConnectionMariaDB {

	Connection connectionMariaDB = null;
	
	PreparedStatement preparedStatementKeySearch = null;
	PreparedStatement preparedStatementUpdate = null;
	PreparedStatement preparedStatementDelete = null;
	PreparedStatement preparedStatementInsert = null;
	PreparedStatement preparedStatementList = null;
	
	@Override
	public Client keySearch(String key) { 
		checkMariaDBConnection();
		
		String clientId = null;
		String clientName = null;
		int clientCityId = 0;
		String clientStreet = null;
				
		String sql = "select id, client_name, city_id, street from clients where  id <=> ?;";
		try {
			
			if (Objects.equals(preparedStatementKeySearch, null)) {
				preparedStatementKeySearch = connectionMariaDB.prepareStatement(sql);
			}
			
			preparedStatementKeySearch.setString(1, key);
			ResultSet dataRead = preparedStatementKeySearch.executeQuery();
			
			if (dataRead.next()) {
				clientId = dataRead.getString("id");
				clientName = dataRead.getString("client_name");
				clientCityId = dataRead.getInt("city_id");
				clientStreet = dataRead.getString("street");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new Client(clientName, clientId, new City(clientCityId, "No updated"), clientStreet, null);
	}

	@Override
	public boolean update(Client element) {
 		checkMariaDBConnection();
		
		String sql = "update clients set client_name = ?, street = ?  where id <=> ? and city_id <=> ?;";
		
		try {
			if (Objects.equals(preparedStatementUpdate, null)) {
				preparedStatementUpdate = connectionMariaDB.prepareStatement(sql);
			}
			preparedStatementUpdate.setString(1, element.getName());
			preparedStatementUpdate.setString(2, element.getStreet());
			preparedStatementUpdate.setString(3, element.getId());
			preparedStatementUpdate.setInt(4, element.getCity().getId());
			
			return preparedStatementUpdate.executeUpdate() != 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Client element) {
		checkMariaDBConnection();
		
		String sql = "delete from clients where id <=> ? and city_id <=> ?;";
		
		try {
			if (Objects.equals(preparedStatementDelete, null)) {
				preparedStatementDelete = connectionMariaDB.prepareStatement(sql);
			} 
			preparedStatementDelete.setString(1, element.getId());
			preparedStatementDelete.setInt(2, element.getCity().getId());
			
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
		
		String sql = "INSERT into clients (id, client_name, city_id, street) values (?, ?, ?, ?);";
		
		try {
			if (Objects.equals(preparedStatementInsert, null)) {
				preparedStatementInsert = connectionMariaDB.prepareStatement(sql);
			} 
			preparedStatementInsert.setString(1, element.getId());
			preparedStatementInsert.setString(2, element.getName());
			preparedStatementInsert.setInt(3, element.getCity().getId());
			preparedStatementInsert.setString(4, element.getStreet());
		
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
		
		String sql = "select id, client_name, city_id, street from clients;";
		
		String clientId = null;
		String clientName = null;
		int clientCityId = 0;
		String clientStreet = null;
		
		try {
			if (Objects.equals(preparedStatementList, null)) {
				preparedStatementList = connectionMariaDB.prepareStatement(sql); 
			} 
			ResultSet readData = preparedStatementList.executeQuery();
			
			while (readData.next()) { 
				clientId = readData.getString("id");
				clientName = readData.getString("client_name");
				clientCityId = readData.getInt("city_id");
				clientStreet = readData.getString("street");
				list.add(new Client(clientName, clientId, new City(clientCityId, "Not available"), clientStreet, null));
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
