package JDBC.bankModel;

import JDBC.bankModel.entities.Office;
import JDBC.bankModel.implementation.mariadb.OfficeImpl;

public class MainOffice_v00 {
	public static void main(String[] args) {
        Office myoffice = null;
        
        OfficeImpl officeImpl = new OfficeImpl();
        
        myoffice = officeImpl.keySearch(5);
        System.out.println(myoffice);
        
        //update productType
        Office myOffice2 = new Office(6, "Bank principal HeadQuarter");
        System.out.println("updted? : " + officeImpl.update(myOffice2));
        
        //delete productType
        System.out.println("deleted office?: " + officeImpl.delete(myOffice2));
        
        //Insert productType
        System.out.println("Inserted office?: " + officeImpl.insert(myOffice2));
        
        //get List of elements from cities table
        System.out.println();
        for (Office office : officeImpl.listElements()) {
			System.out.println(office);
		}
         
	}
}	
