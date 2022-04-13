package objectmodels;

import interfaces.Landable;

public class Helicopter extends AirCraft implements Landable{

	private byte topRotorBladesAmount;
	private byte tailRotorsAmount;
	
	public Helicopter(String aName, SpatialPosition aSpatialPos, float aSpeed, String aSustentationType,
			String aBrand, byte aSeatsAmount, String aColor, byte aPassengersAmount,
			byte aTopRotorBladesAmount, byte aTailRotorsAmount) {
	
		super(aName, aSpatialPos, aSpeed, aSustentationType, aBrand, aSeatsAmount, aColor, aPassengersAmount);
		this.topRotorBladesAmount = aTopRotorBladesAmount;
		this.tailRotorsAmount = aTailRotorsAmount;
	}
	
	public void setTopRotorBladesAmount(byte aTopRotorBladesAmount) {
		this.topRotorBladesAmount = aTopRotorBladesAmount;
	}
	
	public byte getTopRotorBladesAmount() {
		return this.topRotorBladesAmount;
	}
	
	public void setTailRotorsAmount(byte aTailRotorsAmount) {
		this.tailRotorsAmount = aTailRotorsAmount; 
	}
	
	public byte getTailRotorsBladesAmount() {
		return this.tailRotorsAmount;
	}

	@Override
	public String toString() {
		return "Helicopter [toString()=" + super.toString() + ", topRotorBladesAmount=" + topRotorBladesAmount
				+ ", tailRotorsAmount=" + tailRotorsAmount + "]";
	}	
}
