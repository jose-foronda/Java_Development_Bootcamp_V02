package JDBC.bankModel.entities;

public class Office {
	//private fields:
	private int id;
	private String name;
	
	//Constructors:
	public Office() {
		super(); 
	}

	public Office(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	//Getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Office [id=" + id + ", name=" + name + "]";
	}
	
}
