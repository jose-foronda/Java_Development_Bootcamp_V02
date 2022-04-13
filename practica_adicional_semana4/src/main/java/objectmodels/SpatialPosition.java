package objectmodels;

public final class SpatialPosition {

	private float altitude;
	private float yawDegree;
	private float pitchDegree;
	private float rollDegree;
	private String latitudePos;
	private String longitudePos;
	
	public SpatialPosition(float anAltitude, float aYawDegree, float aPitchDegree, 
						   float aRollDegree, String aLatitudePos, String aLongitudePos) {
		super();
		this.altitude = anAltitude;
		this.yawDegree = aYawDegree;
		this.pitchDegree = aPitchDegree;
		this.rollDegree = aRollDegree;
		this.latitudePos = aLatitudePos;
		this.longitudePos = aLongitudePos;
	}
	
	public void setAltitude(float anAltitude) {
		this.altitude = anAltitude;
	}
	
	public float getAltitude() {
		return this.altitude;
	}
	
	public void setYawDegree(float aYawDegree) {
		this.yawDegree = aYawDegree;
	}
	
	public float getYawDegree() {
		return this.yawDegree;
	}

	public void setPitchDegree(float aPitchDegree) {
		this.pitchDegree = aPitchDegree;
	}
	
	public float getPitchDegree() {
		return this.pitchDegree;
	}
	
	public void setRollDegree(float aRollDegree) {
		this.rollDegree = aRollDegree;
	}
	
	public float getRollDegree() {
		return this.rollDegree;
	}
	
	public void setLatitudePos(String aLatitudePos) {
		this.latitudePos = aLatitudePos;
	}
	
	public String getLatitudePos() {
		return this.latitudePos;
	}
	
	public void setLongitudePos(String aLongitudePos) {
		this.longitudePos = aLongitudePos;
	}
	
	public String getLongitudePos() {
		return this.longitudePos;
	}

	@Override
	public String toString() {
		return "SpatialPosition [altitude=" + altitude + ", yawDegree=" + yawDegree + ", pitchDegree=" + pitchDegree
				+ ", rollDegree=" + rollDegree + ", latitudePos=" + latitudePos + ", longitudePos=" + longitudePos
				+ "]";
	} 
	
}
