package objectmodels;

public class UFO extends AirCraft {
	
	private String characteristicShape;
	private byte accessibleDimensions;
	private byte abductedPeopleAmount;
		
	public UFO(String aName, SpatialPosition aSpatialPos, float aSpeed, String aSustentationType,
			String aBrand, byte aSeatsAmount, String aColor, byte aPassengersAmount,
			String aCharactShape, byte anAccessDim, byte anAbductedPeopleAmount) {
		
		super(aName, aSpatialPos, aSpeed, aSustentationType, aBrand, aSeatsAmount, aColor, aPassengersAmount);
		this.setCharacteristicShape(aCharactShape);
		this.accessibleDimensions = anAccessDim;
		this.abductedPeopleAmount = anAbductedPeopleAmount;
	}

	public void setCharacteristicShape(String aCharactShape) {
		this.characteristicShape = aCharactShape;
	}
	
	public String getCharacteristicShape() {
		return this.characteristicShape;
	}

	public void setAccessibleDimensions(byte aDimAccessAmount){
		this.accessibleDimensions = aDimAccessAmount;
	}
	
	public byte getAccessibleDimensions() {
		return this.accessibleDimensions;
	}
	
	public void setAbductedPeopleAmount(byte anAbductedPeopleAmount) {
		this.abductedPeopleAmount = anAbductedPeopleAmount;
	}
	
	public byte getAbductedPeopleAmount() {
		return this.abductedPeopleAmount;
	}

	@Override
	public String toString() {
		return "UFO [toString()=" + super.toString() + ", characteristicShape=" + characteristicShape
				+ ", accessibleDimensions=" + accessibleDimensions + ", abductedPeopleAmount=" + abductedPeopleAmount
				+ "]";
	}
	
}
