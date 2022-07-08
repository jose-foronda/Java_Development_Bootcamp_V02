package com.protalento.DataBaseConnector;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public interface ConnectionMariaDB {
//	private static final InputStream PATH = Thread.currentThread()
//			.getContextClassLoader().getResourceAsStream("basededatos.properties");
//	public static final File propertiesFile = FileSystems.getDefault().getPath("src", "main", "myResources", "database.properties").toFile();
//	public static final File propertiesFile = FileSystems.getDefault().getPath("src", "main", "myResources", "database.properties").toFile();

	default public Connection getMariaDBConnection() {
		
		InputStream PATH;
		Properties properties = new Properties();
//		System.out.println(propertiesFile.getAbsolutePath());
 		try { 
 			
			//			PATH = new FileInputStream(propertiesFile);
			PATH = Thread.currentThread().getContextClassLoader().getResourceAsStream("database.properties"); //ClassLoader.getSystemResourceAsStream("database.properties");
			
			properties.load(PATH);
		} catch (FileNotFoundException e1) { 
			e1.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		}
 		
		Connection connection = null;
		 
 			try { 
				String DRIVER = properties.getProperty("db_driver");
				String URL = properties.getProperty("db_url");
				String USUARIO = properties.getProperty("db_usuario");
				String CLAVE = properties.getProperty("db_clave");
//				System.out.println(USUARIO);
				
				Class.forName(DRIVER);
				connection = DriverManager.getConnection(URL, USUARIO, CLAVE); 
				
			} catch (ClassNotFoundException e) { 
				e.printStackTrace();
			} catch (SQLException e) { 
				e.printStackTrace();
			} 

		return connection;
	} 
	 
	
	public static void main(String[] args) { 
		//File clientFile = FileSystems.getDefault().getPath("src", "main", "myResources", "database.properties").toFile();
		//System.out.println(clientFile.getAbsolutePath());
//		String sp = File.separator;
//		String resource = "src" + sp + "main" + sp + "myResources" + sp +"database.properties";
		System.out.println(Thread.currentThread().getContextClassLoader().getResourceAsStream("database.properties"));
		
//		ConnectionMariaDB mariaDBConnection1 = new ConnectionMariaDB() {
//		};
//		
//		ConnectionMariaDB mariaDBConnection2 = new ConnectionMariaDB() {
//		};
//		
//		mariaDBConnection1.getMariaDBConnection();
//		mariaDBConnection2.getMariaDBConnection();
//		System.out.println(System.getProperty("user.dir"));
		
		
	}
}
