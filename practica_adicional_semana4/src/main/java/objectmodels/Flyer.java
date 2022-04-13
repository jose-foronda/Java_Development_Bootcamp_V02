package objectmodels;

public abstract class Flyer {

	private String name;
	private SpatialPosition spatialPos;
	private float speed;
	private String sustentationType;
	
	public Flyer(String aName, SpatialPosition aSpatialPos, float aSpeed, String aSustType) {
		super();
		this.name = aName;
		this.spatialPos = new SpatialPosition(aSpatialPos.getAltitude(), aSpatialPos.getYawDegree(), aSpatialPos.getPitchDegree(), 
												aSpatialPos.getRollDegree(), aSpatialPos.getLatitudePos(), aSpatialPos.getLongitudePos());
		this.speed = aSpeed;
		this.sustentationType = aSustType;
	}
	
	public void setName(String aName) {
		this.name = aName;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setSpeed(float aSpeed) {
		this.speed = aSpeed;
	}
	
	public float getSpeed() {
		return this.speed;
	}
	
	public void setSustentationType(String aSustType) {
		this.sustentationType = aSustType;
	}

	public String getSustentationType() {
		return this.sustentationType;
	}
	
	public SpatialPosition getSpatialPosition() {
		return this.spatialPos;
	}

	@Override
	public String toString() {
		return "Flyer [name=" + name + ", spatialPos=" + spatialPos + ", speed=" + speed + ", sustentationType="
				+ sustentationType + "]";
	}
	
}
