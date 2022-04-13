package objectmodels;

import interfaces.Landable;

public class AirPlane extends AirCraft implements Landable {
	
	private boolean frontalPropeller;
	private byte lateralEnginesAmount;
	
	public AirPlane(String aName, SpatialPosition aSpatialPos, float aSpeed, String aSustentationType,
			String aBrand, byte aSeatsAmount, String aColor, byte aPassengersAmount,
			boolean hasFrontalPropeller, byte aLateralEnginesAmount) {
		
		super(aName, aSpatialPos, aSpeed, aSustentationType, aBrand, aSeatsAmount, aColor, aPassengersAmount);
		this.frontalPropeller = hasFrontalPropeller;
		this.lateralEnginesAmount = aLateralEnginesAmount;
	}
	
	public void setFrontalPropeller(boolean aFrontalPropeller) {
		this.frontalPropeller = aFrontalPropeller;
	}
	
	public boolean getFrontalPropeller(){
		return this.frontalPropeller;
	}
	
	public void setLateralEnginesAmount(byte aLateralEnginesAmount) {
		this.lateralEnginesAmount = aLateralEnginesAmount;
	}
	
	public byte getLateralEnginesAmount() {
		return this.lateralEnginesAmount;
	}

	@Override
	public String toString() {
		return "AirPlane [toString()=" + super.toString() + ", frontalPropeller=" + frontalPropeller
				+ ", lateralEnginesAmount=" + lateralEnginesAmount + "]";
	}
	
}
