package interfaces;

import objectmodels.LandingAuthorization;

public interface Landable {
	
	default public void receiveLandingAuthorization(LandingAuthorization authorizationInfo) {
		System.out.println("THIS OBJECT IMPLEMENTED Landable INTERFACE");
		System.out.println("The permission to land has been " + authorizationInfo.getPermissionToLandStatus());
		System.out.println("***Info about authorization***");
		System.out.println("	Authorization-to-land status: " + authorizationInfo.getPermissionToLandStatus());
		System.out.println("	AuthorizationId: " + authorizationInfo.getAuthorizationId());
		System.out.println("	Air Traffic Controller Employee:");
		System.out.println("		name: " + authorizationInfo.getAuthorizingEmployee().getName());
		System.out.println("		Employee ID: " + authorizationInfo.getAuthorizingEmployee().getId());
	};
	
}
