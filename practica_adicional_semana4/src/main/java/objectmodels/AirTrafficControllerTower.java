package objectmodels;

import interfaces.Landable;

public final class AirTrafficControllerTower {

	private final String AIRPORT_NAME;
	private final String AIRPORT_CITY;
	private AirTrafficControllerEmployee controllerEmployee;
	
	public AirTrafficControllerTower(String anAirportName, String anAirportCity, AirTrafficControllerEmployee aControllerEmployee) {
		super();
		this.AIRPORT_NAME = anAirportName;
		this.AIRPORT_CITY = anAirportCity;
		this.controllerEmployee = aControllerEmployee;
	}
	
	public String getAirportName() {
		return this.AIRPORT_NAME;
	}
	
	public String getAirportCity() {
		return this.AIRPORT_CITY;
	}
	
	public AirTrafficControllerEmployee getAirTrafficControllerEmployee() {
		return this.controllerEmployee;
	}
	
	//when implementing the interface
	public void requestPermissionToLand(Object obj) {
		if (obj instanceof Landable) {
			((Landable) obj).receiveLandingAuthorization(new LandingAuthorization(controllerEmployee, "GRANTED"));
		} else {
			System.out.println("LANDING DENIED. YOU DO NOT KNOW PROTOCOL (INTERFACE) ABOUT HOW TO REQUEST A LANDING AUTHORIZATION."
					+ " THIS IS A RESTRICTED AIR SPACE!!");
		}
	}

	@Override
	public String toString() {
		return "AirTrafficControllerTower [AIRPORT_NAME=" + AIRPORT_NAME + ", AIRPORT_CITY=" + AIRPORT_CITY
				+ ", " + controllerEmployee + "]";
	}
	
}
