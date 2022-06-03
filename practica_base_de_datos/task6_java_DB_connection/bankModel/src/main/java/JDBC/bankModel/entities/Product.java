package JDBC.bankModel.entities;

import java.util.List;

public final class Product {
	//Private fields:
	private String id;
	private ProductType type;
	private List<Employee> productEmployees;

	//constructor
	public Product() {
		super(); 
	}
	
	public Product(String id, ProductType type, List<Employee> productEmployees) {
		super();
		this.id = id;
		this.type = type;
		this.productEmployees = productEmployees;
	}
	
	//getters and setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	public List<Employee> getProductEmployees() {
		return productEmployees;
	}

	public void setProductEmployees(List<Employee> productEmployees) {
		this.productEmployees = productEmployees;
	}

	@Override
	public String toString() {
		return "\nProduct [id=" + id + ", type=" + type + ", productEmployees=" + productEmployees + "]";
	}
	
}
