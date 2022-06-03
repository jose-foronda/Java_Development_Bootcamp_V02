package JDBC.bankModel.entities;

public abstract class Person {
	//Private fields:
	private String name;
	
	//constructors:
	public Person() {
		super();
	}

	//Getters and setters
	public Person(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}

}
