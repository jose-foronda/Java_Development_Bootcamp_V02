package objectmodels;

public final class AirTrafficControllerEmployee {
	
	private String name;
	private byte id;
	
	public AirTrafficControllerEmployee(String aName, byte anId) {
		super();
		this.name = aName;
		this.id = anId;
	}

	public void setName(String aName) {
		this.name = aName;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setId(byte anId) {
		this.id = anId;
	}
	
	public byte getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return "AirTrafficControllerEmployee [name=" + name + ", id=" + id + "]";
	}
	
}
