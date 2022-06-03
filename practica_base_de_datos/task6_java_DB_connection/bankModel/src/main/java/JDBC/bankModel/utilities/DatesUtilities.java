package JDBC.bankModel.utilities;

import java.time.format.DateTimeFormatter;

public final class DatesUtilities {
	private static final String SYS_FORMATTER = "dd/MM/yyyy";
	private static final String SQL_FORMATTER = "yyyy-MM-dd";
	
	public static String getSysFormat() {
		return SYS_FORMATTER;
	}
	
	public static String getSQLformat() {
		return SQL_FORMATTER;
	}
	
	public static DateTimeFormatter getDateTimeFormatter(String format) {
		return DateTimeFormatter.ofPattern(format);
	}
}
