package com.protalento.jdbc.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.protalento.DataBaseConnector.ConnectionMariaDB;
import com.protalento.entities.WebTextSearch;
import com.protalento.jdbc.DAO.DAO;
import com.protalento.utilities.LocalDateUtillities;

public class WebTextSearchImp implements DAO<WebTextSearch, Integer>, ConnectionMariaDB {
	private Connection mariaDBConnection;
	private PreparedStatement preparedStatementInsert = null;
	private PreparedStatement preparedStatementList = null;
	
	//constructor
	public WebTextSearchImp() {
		super();
	}

	@Override
	public WebTextSearch keySearch(Integer key) { 
		
		return null;
	}

	@Override
	public boolean insert(WebTextSearch element) { 
		mariaDBConnection = getMariaDBConnection();
		 
		
		String sql = "insert into web_searches (searchedText, searchedURL, urlContent, searchDate) values (?, ?, ?, ?);";
		try {
			if (preparedStatementInsert == null) {
				preparedStatementInsert = mariaDBConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			}
			
			LocalDateTime dateTime = LocalDateUtillities.getLocalDateTimeNow(LocalDateUtillities.SQL_DATETIME_PATTERN);
			element.setDate(dateTime);
			
			preparedStatementInsert.setString(1, element.getText());
			preparedStatementInsert.setString(2, element.getUrl());
			preparedStatementInsert.setString(3, element.getHtmlContent());
			preparedStatementInsert.setString(4, LocalDateUtillities.getLocalDateTimeString(dateTime, LocalDateUtillities.SQL_DATETIME_PATTERN));
			
			
			if (preparedStatementInsert.executeUpdate() != 0) {
				ResultSet resultSet = preparedStatementInsert.getGeneratedKeys();
				
				if (resultSet.next()) { 
					element.setId(resultSet.getInt(1));
					return true;
				}
			} 
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<WebTextSearch> listElements() { 
		mariaDBConnection = getMariaDBConnection();
		List<WebTextSearch> webSearchList = new ArrayList<WebTextSearch>();
		
		String sql = "select id, searchedText, searchedURL, searchDate from web_searches;";
		
		try {
			preparedStatementList = mariaDBConnection.prepareStatement(sql);
			
			ResultSet queriedList = preparedStatementList.executeQuery();
			
			while (queriedList.next()) { 
				WebTextSearch searchItem = new WebTextSearch();
				searchItem.setId(queriedList.getInt("id"));
				searchItem.setText(queriedList.getString("searchedText"));
				searchItem.setUrl(queriedList.getString("searchedURL"));
				
				String queriedDateTime = queriedList.getString("searchDate");
				LocalDateTime dateTime = LocalDateTime.parse(queriedDateTime, LocalDateUtillities.getDateTimeFormatter(LocalDateUtillities.SQL_DATETIME_PATTERN));
				searchItem.setDate(dateTime);
				webSearchList.add(searchItem);
			}
			
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		
		return webSearchList;
	}
	 
//	public static void main(String[] args) {
//		
//		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//		
////		LocalDateTime dateTime = LocalDateTime.parse("2012-06-23 23:34:56", dateFormat);
////		LocalDateTime dateTime = LocalDateTime.parse(LocalDateTime.now().format(dateFormat), dateFormat);
////		System.out.println(dateTime.format(dateFormat));
//		
//		
//		LocalDateTime dateTime = LocalDateUtillities.getLocalDateTimeNow(LocalDateUtillities.SQL_DATETIME_PATTERN);
//		System.out.println(LocalDateUtillities.getLocalDateTimeString(dateTime, LocalDateUtillities.SQL_DATETIME_PATTERN));
//		
////		LocalDateTime dateTime = new LocalDateTime.parse("2012-06-23 23:34:56", new  datetimeformatter(); )
////		System.out.println(dateTime);
//	}
	
//	public static void main(String[] args) {
//		WebTextSearch search = new WebTextSearch(0, "Hello, world", "https://docs.oracle.com/", "some content", 0, null);
//		WebTextSearchImp searchImp = new WebTextSearchImp();
//		searchImp.insert(search);
//		
//		System.out.println(search);
//	}
	
	//Main method for List()
	public static void main(String[] args) {
		WebTextSearchImp searchImp = new WebTextSearchImp();
		
		List<WebTextSearch> myList = (List<WebTextSearch>)searchImp.listElements();
		
		for (WebTextSearch webSearch : myList) {
			System.out.println(webSearch);
		}
	}
}
