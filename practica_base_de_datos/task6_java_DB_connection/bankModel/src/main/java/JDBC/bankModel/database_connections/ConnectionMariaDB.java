package JDBC.bankModel.database_connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface ConnectionMariaDB {
	
	default public Connection getMariaDBConnection() {
		String driver = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost/eduit_labdb_bankmodel";
		String user = "root";
		String password = "";
		
		Connection mariaDBConnection = null;
		try {
			Class.forName(driver);
			mariaDBConnection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return mariaDBConnection;
	}
}
