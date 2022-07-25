package com.protalento.DataBaseConnector.entities;

import java.time.LocalDate;

public final class Employee {
	
	private Document document;
	private String name;
	private String lastName;
	private int age;
	private LocalDate birthDate;
	
	public Employee() {
		super(); 
	}
	
	public Employee(Document document, String name, String lastName, int age, LocalDate birthDate) {
		super();
		this.document = document;
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.birthDate = birthDate;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Employee [document=" + document + ", name=" + name + ", lastName=" + lastName + ", age=" + age
				+ ", birthDate=" + birthDate + "]";
	}
	
}
