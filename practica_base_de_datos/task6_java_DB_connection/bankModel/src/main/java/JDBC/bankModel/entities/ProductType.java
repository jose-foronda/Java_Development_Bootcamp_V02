package JDBC.bankModel.entities;

public final class ProductType {
	//private fields:
	private int id;
	private String name;
	
	//Constructors
	public ProductType() {
		super(); 
	}

	public ProductType(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	//Getters and Setters
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
		return "ProductType [id=" + id + ", name=" + name + "]";
	}
	
}
