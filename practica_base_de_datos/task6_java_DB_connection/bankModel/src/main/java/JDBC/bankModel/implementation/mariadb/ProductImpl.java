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
import JDBC.bankModel.entities.Client;
import JDBC.bankModel.entities.Product;
import JDBC.bankModel.entities.ProductType;

public final class ProductImpl implements DAO<Client, String>, ConnectionMariaDB {
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
		String id = null;
		int bankProductId = 0; 
		  
				
		String sql = "select id, bank_products_id from client_products where  clients_id <=> ?;";
		try {
			
			if (Objects.equals(preparedStatementKeySearch, null)) {
				preparedStatementKeySearch = connectionMariaDB.prepareStatement(sql);
			}
			
			preparedStatementKeySearch.setString(1, key);
			ResultSet dataRead = preparedStatementKeySearch.executeQuery();
			
			while (dataRead.next()) {
				id = dataRead.getString("id");
				bankProductId = dataRead.getInt("bank_products_id"); 
				productList.add(new Product(id, new ProductType(bankProductId, null), null));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return new Client(null, key, null, null, productList);
	}

	@Override
	public boolean update(Client element) {
 		checkMariaDBConnection();
		
		String sql = "update client_products set bank_products_id = ? where id <=> ?;";
		
 		try {
			if (Objects.equals(preparedStatementUpdate, null)) {
				preparedStatementUpdate = connectionMariaDB.prepareStatement(sql);
			}
			  
			preparedStatementUpdate.setInt(1, element.getProductList().get(0).getType().getId());
			preparedStatementUpdate.setString(2, element.getProductList().get(0).getId());
			return preparedStatementUpdate.executeUpdate() != 0;
 			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Client element) {
		checkMariaDBConnection();
		
		String sql = "delete from client_products where id <=> ? ;";
		
		try {
			if (Objects.equals(preparedStatementDelete, null)) {
				preparedStatementDelete = connectionMariaDB.prepareStatement(sql);
			} 
			 
			preparedStatementDelete.setString(1, element.getProductList().get(0).getId()); 
			
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
		
		String sql = "INSERT into client_products (id, bank_products_id, clients_id) values ( ?, ?, ? );";
		
		try {
			if (Objects.equals(preparedStatementInsert, null)) {
				preparedStatementInsert = connectionMariaDB.prepareStatement(sql);
			} 

			preparedStatementInsert.setString(1, element.getProductList().get(0).getId());
			preparedStatementInsert.setInt(2, element.getProductList().get(0).getType().getId());
			preparedStatementInsert.setString(3, element.getId()); 
		
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
		
		String sql = "select id, bank_products_id, clients_id from client_products order by clients_id;";
		
		String productId = null;
		int productTypeId = 0;
		String clientId = null;
 		
		try {
			if (Objects.equals(preparedStatementList, null)) {
				preparedStatementList = connectionMariaDB.prepareStatement(sql); 
			} 
			ResultSet readData = preparedStatementList.executeQuery();
			
			String lastClientId = null;
 			while (readData.next()) { 
				productId = readData.getString("id");
				productTypeId = readData.getInt("bank_products_id");
				clientId = readData.getString("clients_id");
				
				if (clientId.equals(lastClientId) && list.size() > 0) {
					list.get(list.size() - 1).getProductList().add(new Product(productId, new ProductType(productTypeId, null), null));
				}else {
					List<Product> productsRead = new ArrayList<Product>();
					productsRead.add(new Product(productId, new ProductType(productTypeId, null), null));
					Client newClient = new Client(null, clientId, null, null, productsRead);
					list.add(newClient);
					lastClientId = clientId;
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
