package com.protalento.DataBaseConnector.jdbc.connections;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.protalento.DataBaseConnector.jdbc.enums.Base64Schema;
import com.protalento.DataBaseConnector.jdbc.utilities.Base64EncoderDecoder;

public interface ConnectionMariaDB {
	public static final InputStream PATH = Thread.currentThread().getContextClassLoader().getResourceAsStream("database.properties");
	public static final Properties properties = new Properties();
	
	//Logger
	public static final Logger logger = LogManager.getLogger();
	
	default public Connection getMariaDBConnection() {
		
		Connection mariaDBConnection = null;
		try {
			properties.load(PATH);
			
			String driver = properties.getProperty("db_driver");
			String url = properties.getProperty("db_url");
			String user = properties.getProperty("db_user");
			String key = properties.getProperty("db_key"); 
			
			Class.forName(driver);
			
			mariaDBConnection = DriverManager.getConnection(url, user, key);
			logger.debug("driver=" + driver + ", url= " + url + ", user=" + user + ", key=" + key);
		} catch (IOException e) { 
			e.printStackTrace();
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	
		return mariaDBConnection; 
		
	}
	
	default public String getDecryptedKey() {
		return Base64EncoderDecoder.operateBase64Schema(properties.getProperty("db_encrypKey"), Base64Schema.DECODE);
	}
	
	public static void main(String[] args) {
		ConnectionMariaDB mariaDBlink1 = new ConnectionMariaDB() {
		};
		
		ConnectionMariaDB mariaDBlink2 = new ConnectionMariaDB() {
		};
		
		System.out.println(mariaDBlink1.getMariaDBConnection());
		System.out.println(mariaDBlink2.getMariaDBConnection());
		System.out.println("Hola");
		
		System.out.println(mariaDBlink2.getDecryptedKey());
		
//		String encoded = Base64.getEncoder().encodeToString("hola".getBytes());
//		System.out.println(encoded);
//		
//		String decoded = new String(Base64.getDecoder().decode(encoded.getBytes()));
//				
//		byte[] a = null;
//
//		
// 		System.out.println(decoded);
		
//		String encoded = Base64EncoderDecoder.operateBase64Schema("ProtalentoEducacionITAlliance", Base64Schema.ENCODE);
//		String decoded = Base64EncoderDecoder.operateBase64Schema(encoded, Base64Schema.DECODE);
//		System.out.println("encoded: " + encoded);
//		System.out.println("decoded: " + decoded);
		
	}
}
