package com.protalento.DataBaseConnector.enums;

public enum DocumentType {
	CC("cedula de ciudadania"),
	TI("tarjeta de identidad"),
	PAS("Pasaporte"),
	CE("cedula extranjería"),
	RC("registro civil");
	
	private String description;
	
	private DocumentType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
