package JDBC.bankModel.entities;

import java.util.List;

public final class Client extends Person {
	//Private fields:
	private String id;
	private City city;
	private String street;
	private List<Product> productList;
	
	//Constructors
	public Client() {
		super();
	}

	public Client(String name, String id, City city, String street, List<Product> productList) {
		super(name);
		this.id = id;
		this.city = city;
		this.street = street;
		this.productList = productList;
	}

	//Getters and setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	@Override
	public String toString() {
		return "Client [name=" + getName() + ", id=" + id + ", city=" + city + ", street=" + street
				+ "\nproductList=" + productList + "]";
	}
	
}
