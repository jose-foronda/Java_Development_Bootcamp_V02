package JDBC.bankModel;

import JDBC.bankModel.entities.City;
import JDBC.bankModel.implementation.mariadb.CityImpl;

/**
 * Hello world!
 *
 */
public class MainCity_v00 
{
    public static void main( String[] args )
    {
        City myCity = null;
        
        CityImpl cityImplement = new CityImpl();
        
        myCity = cityImplement.keySearch(2);
        System.out.println(myCity);
        
        //update city
        City myCity2 = new City(18, "Buenavista");
        System.out.println("updted? : " + cityImplement.update(myCity2));
        
        //delete city
        System.out.println("deleted city?: " + cityImplement.delete(myCity2));
        
        //Insert city
        //System.out.println("Inserted city?: " + cityImplement.insert(myCity2));
        
        //get List of elements from cities table
        System.out.println();
        for (City city : cityImplement.listElements()) {
			System.out.println(city);
		}
        
//        System.out.println(Objects.equals(null, null));
    }
}
