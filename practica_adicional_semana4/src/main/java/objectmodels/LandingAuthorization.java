package objectmodels;

public class LandingAuthorization {
	
	private static int landingAuthorizationId = 0;
	
	private AirTrafficControllerEmployee authorizingEmployee;
	private int authorizationId;
	private String permissionToLandStatus;
	
	{
		authorizationId = LandingAuthorization.landingAuthorizationId;
		LandingAuthorization.landingAuthorizationId++;
	}

	public LandingAuthorization(AirTrafficControllerEmployee authorizingEmployee, String permissionToLandStatus) {
		super();
		this.authorizingEmployee = authorizingEmployee;
		this.permissionToLandStatus = permissionToLandStatus;
	}
	
	/**
	 * @return the authorizingEmployee
	 */
	public AirTrafficControllerEmployee getAuthorizingEmployee() {
		return authorizingEmployee;
	}

	/**
	 * @return the authorizationId
	 */
	public int getAuthorizationId() {
		return authorizationId;
	}

	/**
	 * @return the permissionToLandStatus
	 */
	public String getPermissionToLandStatus() {
		return permissionToLandStatus;
	}

	@Override
	public String toString() {
		return "LandingAuthorization [authorizingEmployee=" + authorizingEmployee + ", authorizationId="
				+ authorizationId + "]";
	}

}
