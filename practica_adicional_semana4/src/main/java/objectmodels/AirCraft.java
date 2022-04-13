package objectmodels;

public abstract class AirCraft extends Flyer {
	
	private String brand;
	private byte seatsAmount;
	private String color;
	private byte passengersAmount;
	
	public AirCraft(String aName, SpatialPosition aSpatialPos, float aSpeed, String aSustentationType,
			String aBrand, byte aSeatsAmount, String aColor, byte aPassengersAmount) {
		super(aName, aSpatialPos, aSpeed, aSustentationType);
		this.brand = aBrand;
		this.seatsAmount = aSeatsAmount;
		this.color = aColor;
		this.passengersAmount = aPassengersAmount;
	}
	
	public void setBrand(String aBrand) {
		this.brand = aBrand;
	}
	
	public String getBrand(){
		return this.brand;
	}
	
	public void setSeatsAmount(byte aSeatsAmount) {
		this.seatsAmount = aSeatsAmount;
	}
	
	public byte getSeatsAmount() {
		return this.seatsAmount;
	}
	
	public void setColor(String aColor) {
		this.color = aColor; 
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void setPassengersAmount(byte aPassengersAmount) {
		this.passengersAmount = aPassengersAmount;
	}
	
	public byte getPassengersAmount() {
		return this.passengersAmount;
	}

	@Override
	public String toString() {
		return "AirCraft [toString()=" + super.toString() + ", brand=" + brand + ", seatsAmount=" + seatsAmount
				+ ", color=" + color + ", passengersAmount=" + passengersAmount + "]";
	}
	
}
