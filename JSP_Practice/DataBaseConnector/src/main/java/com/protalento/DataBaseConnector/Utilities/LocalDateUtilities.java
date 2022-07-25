package com.protalento.DataBaseConnector.Utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class LocalDateUtilities {
	
	public static final String SQL_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final String SQL_DATE_PATTERN = "yyyy-MM-dd";
	public static final String SYS_FORMATTER = "dd/MM/yyyy";
	public static final String CSV_DATE_TIME_FORMAT = "YYYYMMDDHHmmss";
	
	//Avoid instantiation
	private LocalDateUtilities() {
		super(); 
	}
	
	//Utility Methods
	public static DateTimeFormatter getDateTimeFormatter(String format) {
		return DateTimeFormatter.ofPattern(format);
	}
	
	public static LocalDateTime getLocalDateTimeNow(String dateTimePattern) {
		DateTimeFormatter dateTimeFormatter = getDateTimeFormatter(dateTimePattern);
		return LocalDateTime.parse(LocalDateTime.now().format(dateTimeFormatter), dateTimeFormatter);
	}
	
	public static String getLocalDateTimeString(LocalDateTime dateTime, String format) {
		return dateTime.format(getDateTimeFormatter(format));
	}
	
}
