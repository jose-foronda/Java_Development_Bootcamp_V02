package com.protalento.DataBaseConnector.jdbc.utilities;


import java.util.regex.Matcher;
import java.util.regex.Pattern;


public final class AuthenticationPatterns {

	private AuthenticationPatterns() {
		super(); 
	}
	
	public static boolean isEmail(String email) {
		Pattern pattern = Pattern.compile("([a-z0-9]+(\\.?[a-z0-9])*)+@(([a-z]+)\\.([a-z]+))");
		
		Matcher comparatorMatcher = pattern.matcher(email);
		
		if (comparatorMatcher.find()) {
			return true;
		}
		return false;
	}
 
	
	/**
	 * Verifies if it is a pattern
	 * 
	 * @param password
	 * @return boolean
	 */
	public static boolean isPassword(String password) {
		Pattern pattern = Pattern.compile("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$");
		
		Matcher comparatorMatcher = pattern.matcher(password);
		
		if (comparatorMatcher.find()) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isEmail("jose@hotmail.com"));
		System.out.println(isPassword("Jose@hotmail.com"));
	}
	
}
