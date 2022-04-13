package eduIt.practica_adicional_semana4;

import objectmodels.AirPlane;
import objectmodels.AirTrafficControllerEmployee;
import objectmodels.AirTrafficControllerTower;
import objectmodels.FlyingHero;
import objectmodels.Helicopter;
import objectmodels.SpatialPosition;
import objectmodels.UFO;

public class Airport {

	public static void main(String[] args) {
		SpatialPosition spatialPosition = new SpatialPosition(1250.3f, 45f , 35f, 10f, "4°27'10.0\"N", "75°46'04.9\"W");
		String[] supermanAbilities = {"Flight", "Super speed", "Super Strength", "X-ray vision", "Heat vision", "Super hearing"};
		
		FlyingHero superMan = new FlyingHero("SuperMan", spatialPosition, 300.0f, "LEVITATION",
				(byte)28, supermanAbilities, "1993-04-11", "Justice League");
		//System.out.println(superMan);
		
		UFO ufo = new UFO("Unidentified Flying Object", spatialPosition, 10000f, "Unknown", "Unknown", 
				(byte)0, "Gray", (byte)0, "saucer", (byte)4, (byte)10);
		//System.out.println(ufo);
		
		Helicopter helicoper = new Helicopter("Defiant X", spatialPosition, 125f, "Rotating wings", 
				"Boeing", (byte) 8, "Black", (byte)5, (byte)4, (byte)1);
		//System.out.println(helicoper);
		
		AirPlane airplane = new AirPlane("737 MAX 10", spatialPosition, 900f, "Fix wings", 
				"Boeing", (byte)120, "blue-white", (byte)75, false, (byte)2);
		//System.out.println(airplane);
		
		AirTrafficControllerEmployee controlEmployee = new AirTrafficControllerEmployee("Jose Foronda", (byte)111);
		
		AirTrafficControllerTower controlTower = new AirTrafficControllerTower("Quindio Airport", "Armenia", controlEmployee);
		//System.out.println(controlTower);
		
		
		System.out.println();
		System.out.println();
		System.out.println("*** Requesting permission to land ***");

		interfaceImplementingVerification(controlTower, superMan, "superman: ");
		interfaceImplementingVerification(controlTower, ufo, "ufo: ");
		interfaceImplementingVerification(controlTower, helicoper, "helicopter: ");
		interfaceImplementingVerification(controlTower, airplane, "airplane: "); 
	}
	
	public static void interfaceImplementingVerification(AirTrafficControllerTower tower, Object obj, String msg) {
		System.out.println();
		System.out.println(msg);
		tower.requestPermissionToLand(obj);
	}
}
