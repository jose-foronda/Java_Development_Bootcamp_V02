package com.protalento.DataBaseConnector.jdbc.enums;

public enum AuthenticationParameters {
	EMAIL("You have to enter an allowed format as 'user@domain.ext'"),
	PASSWORD("the password must have between 8 and 16 characters, at least one digit, at least a lower-case and at least an upper-case letter. Can't have other symbols.");

	private String msg;

	AuthenticationParameters(String msg) {
		this.msg = msg;
	}

	public String getMensaje() {
		return msg;
	}
}
