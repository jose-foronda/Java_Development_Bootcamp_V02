package com.protalento.DataBaseConnector.jdbc.implementations;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.protalento.DataBaseConnector.entities.SystemUser;
import com.protalento.DataBaseConnector.jdbc.connections.ConnectionMariaDB;
import com.protalento.DataBaseConnector.jdbc.interfaces.DAOGeneric;

public final class SystemUserImp implements DAOGeneric<SystemUser, String>, ConnectionMariaDB {
	private static Logger logger = LogManager.getLogger();
	private PreparedStatement preparedStatementSearchById;
	private PreparedStatement preparedStatementInsert;
	private PreparedStatement preparedStatementModify;
	private PreparedStatement preparedStatementDelete;
	private PreparedStatement preparedStatementList;

	@Override
	public SystemUser searchByKey(String email) {
		SystemUser user = null;
		String sql = "select AES_DECRYPT(password,?) as password from systemusers where email = ?";
		try {
			if (null == preparedStatementSearchById) {
				preparedStatementSearchById = getMariaDBConnection().prepareStatement(sql);
			}

			preparedStatementSearchById.setString(1, getDecryptedKey());
			preparedStatementSearchById.setString(2, email);

			ResultSet resultSet = preparedStatementSearchById.executeQuery();

			if (resultSet.next()) {
				user = new SystemUser();
				user.setEmail(email);
				user.setPassword(resultSet.getString("password"));
			}
			logger.debug(preparedStatementSearchById);

			logger.info(user);
		} catch (SQLException e) {
			logger.error(e);
		} 
	
		return user;
	}

	@Override
	public boolean insert(SystemUser user) {
 		String sql = "insert into systemusers (email, password) values ( ?, AES_ENCRYPT(?,?) );";
		try {
			if (null == preparedStatementInsert) {
				preparedStatementInsert = getMariaDBConnection().prepareStatement(sql);
			}

			preparedStatementInsert.setString(1, user.getEmail());
			preparedStatementInsert.setString(2, user.getPassword());
			preparedStatementInsert.setString(3, getDecryptedKey());
			
			logger.info(preparedStatementInsert);
			
			return preparedStatementInsert.executeUpdate() == 1;
 
		} catch (SQLException e) {
			logger.error(e);
		} 
	
		return false;
	}

	@Override
	public boolean modify(SystemUser user) {
		String sql = "update systemusers set password = AES_ENCRYPT(?,?) where email = ?;";
		
		try {
			if (preparedStatementModify == null) {
				preparedStatementModify = getMariaDBConnection().prepareStatement(sql);
			}
			
			preparedStatementModify.setString(1, user.getPassword());
			preparedStatementModify.setString(2, getDecryptedKey());
			preparedStatementModify.setString(3, user.getEmail());
			
			return preparedStatementModify.executeUpdate() == 1;
		} catch (SQLException e1) { 
			e1.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean delete(SystemUser user) {
		String sql = "delete from systemusers where email = ?";
		try {
			if (null == preparedStatementDelete) {
				preparedStatementDelete = getMariaDBConnection().prepareStatement(sql);
			}
			preparedStatementDelete.setString(1, user.getEmail());

			logger.debug(preparedStatementDelete);
			logger.info(user);
			return preparedStatementDelete.executeUpdate() == 1;
		} catch (SQLException e) {
			logger.error(e);
		}
		return false;
	}

	@Override
	public List<SystemUser> list() {
		List<SystemUser> users = new ArrayList<>();
		SystemUser user = null;
		
		String sql = "select email, AES_DECRYPT(password, ?) as password  from systemusers;";
		try {
			if (null == preparedStatementList) {
				preparedStatementList = getMariaDBConnection().prepareStatement(sql);
			}

			preparedStatementList.setString(1, getDecryptedKey()); 

			ResultSet resultSet = preparedStatementList.executeQuery();
			
			while (resultSet.next()) {
				user = new SystemUser();
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));
 				users.add(user);
			}
			
			logger.debug(preparedStatementList);
			logger.info(user);

		} catch (SQLException e) {
			logger.error(e);
		}

		return users;
	}
	
	public static void main(String[] args) {
		SystemUser userTest1 = new SystemUser("jose.ramon.foronda.melo@gmail.com", "User1.1234");
		System.out.println(userTest1);
		
		SystemUserImp systemUserImp = new SystemUserImp();
//		systemUserImp.insert(userTest1);
		
		System.out.println("searched user:");
		System.out.println(systemUserImp.searchByKey(userTest1.getEmail()));
		
		System.out.println("deleted user:");
//		System.out.println(systemUserImp.delete(userTest1));
		
		System.out.println("list users:");
		System.out.println();
		
		for (SystemUser user : systemUserImp.list()) {
			System.out.println(user);
		}
	}

}
