package com.protalento.DataBaseConnector.entities;

import com.protalento.DataBaseConnector.enums.DocumentType;

public final class Document {
	
	private DocumentType type;
	private String number;
	
	public Document() {
		super(); 
	}

	public Document(DocumentType type, String number) {
		super();
		this.type = type;
		this.number = number;
	}

	public DocumentType getType() {
		return type;
	}

	public void setType(DocumentType type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Document [type=" + type + ", number=" + number + "]";
	}
	
}
