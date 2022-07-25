package com.protalento.DataBaseConnector.entities;

public final class SystemUser {
	private String email;
	private String password;
	
	public SystemUser() {
		super(); 
	}

	public SystemUser(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "SystemUser [email=" + email + ", password=" + password + "]";
	}
	
}
