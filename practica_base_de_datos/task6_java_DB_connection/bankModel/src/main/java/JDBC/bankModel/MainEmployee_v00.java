package JDBC.bankModel;

import java.time.LocalDate;

import JDBC.bankModel.entities.Employee;
import JDBC.bankModel.implementation.mariadb.EmployeeImpl;
import JDBC.bankModel.utilities.DatesUtilities;

public class MainEmployee_v00 {
	public static void main(String[] args) {
        Employee myEmployee = null;
        
        EmployeeImpl employeeImpl = new EmployeeImpl();
        //Search for an employee with an Id
        myEmployee = employeeImpl.keySearch(32);
        System.out.println(myEmployee);
        
        //update productType
        LocalDate mydate = LocalDate.parse("2021-02-25", DatesUtilities.getDateTimeFormatter(DatesUtilities.getSQLformat()));
        Employee myEmployee2 = new Employee("Andres Felipe Foronda", 32, "(+57) 311 662 72 27", mydate);
        System.out.println("updted? : " + employeeImpl.update(myEmployee2));
        
        //delete productType
       // System.out.println("deleted Employee?: " + employeeImpl.delete(myEmployee2));
        
        //Insert productType
       // System.out.println("Inserted Employee?: " + employeeImpl.insert(myEmployee2));
        
        //get List of elements from cities table
        System.out.println();
        for (Employee employees : employeeImpl.listElements()) {
			System.out.println(employees);
		}
        
//        LocalDate mydate;
//        mydate = LocalDate.parse("2021-02-25", DatesUtilities.getDateTimeFormatter(DatesUtilities.getSQLformat()));
//        System.out.println(mydate);
         
	}
}
