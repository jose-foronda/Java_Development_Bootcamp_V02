package com.protalento.DataBaseConnector;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MAIN_DATETIME {
	public static void main(String[] args) {
		LocalDateTime dateTime = LocalDateTime.now();
		String date = dateTime.format(DateTimeFormatter.ofPattern("YYYYMMDDHHmmss"));
		System.out.println(date);
	}
}	
