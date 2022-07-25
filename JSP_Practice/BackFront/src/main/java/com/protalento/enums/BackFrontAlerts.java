package com.protalento.enums;

public enum BackFrontAlerts {
	CORRECT_CREDENTIALS("Access granted"),
	INCORRECT_PASSWORD("The password is wrong"),
	USER_NO_REGISTERED("User is not registered"),
	USER_MODIFIED("User successfully modified"),
	USER_ADDED("User successfully added"),
	USER_MODIFIED_PROBLEM("The modification may not have been successful"),
	USER_NO_ADDED("The storing of the element may not have been seccessful"),
	USER_DELETED("The element has been deleted succesfully"),
	USER_NO_DELETED("The element could not be deleted"),
	SESSION_CLOSED("The session has been closed successfully"),
	CSV_FILE_GENERATED("The CSV file was succesfully generated");
	
	private String message;
	
	private BackFrontAlerts(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
}
