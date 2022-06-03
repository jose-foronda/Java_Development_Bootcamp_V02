package JDBC.bankModel.entities;

import java.time.LocalDate;

public final class Employee extends Person {
	//private fields:
	private int id;
	private String phoneNumber;
	private LocalDate hiringDate;
 
	//private constructors
	public Employee() {
		super(); 
	}

	public Employee(String name, int id, String phoneNumber, LocalDate hiringDate) {
		super(name);
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.hiringDate = hiringDate;
	}

	//Getters and Setters.
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getHiringDate() {
		return hiringDate;
	}

	public void setHiringDate(LocalDate hiringDate) {
		this.hiringDate = hiringDate;
	}

	@Override
	public String toString() {
		return "\n\tEmployee [name=" + getName() + ", id=" + id + ", phoneNumber=" + phoneNumber
				+ ", hiringDate=" + hiringDate + "]";
	}
	
}
