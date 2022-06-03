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
import JDBC.bankModel.entities.Office;

public final class OfficeImpl implements DAO<Office, Integer>, ConnectionMariaDB {

	Connection connectionMariaDB = null;
	
	PreparedStatement preparedStatementKeySearch = null;
	PreparedStatement preparedStatementUpdate = null;
	PreparedStatement preparedStatementDelete = null;
	PreparedStatement preparedStatementInsert = null;
	PreparedStatement preparedStatementList = null;
	
	@Override
	public Office keySearch(Integer key) { 
		checkMariaDBConnection();
		
		String officeName = null;
		
		String sql = "select name from offices where  city_id <=> ?;";
		try {
			
			if (Objects.equals(preparedStatementKeySearch, null)) {
				preparedStatementKeySearch = connectionMariaDB.prepareStatement(sql);
			}
			
			preparedStatementKeySearch.setInt(1, key);
			ResultSet dataRead = preparedStatementKeySearch.executeQuery();
			
			if (dataRead.next()) {
				officeName = dataRead.getString("name");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new Office(key, officeName);
	}

	@Override
	public boolean update(Office element) {
//		Connection connectionMariaDB = getMariaDBConnection();
		checkMariaDBConnection();
		
		String sql = "update offices  set name = ? where city_id <=> ?;";
		
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
	public boolean delete(Office element) {
//		Connection connectionMariaDB = getMariaDBConnection();
		checkMariaDBConnection();
		
		String sql = "delete from offices where city_id <=> ?;";
		
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
	public boolean insert(Office element) {
//		Connection connectionMariaDB = getMariaDBConnection();
		checkMariaDBConnection();
		
		String sql = " INSERT INTO eduIT_labDB_BanKModel.offices (city_id, name) values (?, ?);";
		
		try {
			if (Objects.equals(preparedStatementInsert, null)) {
				preparedStatementInsert = connectionMariaDB.prepareStatement(sql);
			} 
			preparedStatementInsert.setInt(1, element.getId());
			preparedStatementInsert.setString(2, element.getName());
			
			return preparedStatementInsert.executeUpdate() != 0;
		} catch (SQLException e) { 
			e.printStackTrace();
		};
		return false;
		
	}

	@Override
	public List<Office> listElements() { 
		List<Office> list = new ArrayList<Office>();
//		Connection connectionMariaDB = getMariaDBConnection();
		checkMariaDBConnection();
		
		String sql = "select city_id, name from offices;";
		
		try {
			if (Objects.equals(preparedStatementList, null)) {
				preparedStatementList = connectionMariaDB.prepareStatement(sql); 
			} 
			ResultSet readData = preparedStatementList.executeQuery();
			
			while (readData.next()) { 
				list.add(new Office( readData.getInt("city_id"), readData.getString("name") ));
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
