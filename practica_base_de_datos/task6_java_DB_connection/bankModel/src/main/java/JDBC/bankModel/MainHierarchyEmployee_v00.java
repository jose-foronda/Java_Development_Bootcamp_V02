package JDBC.bankModel;

import java.util.ArrayList;
import java.util.List;

import JDBC.bankModel.entities.Employee;
import JDBC.bankModel.entities.HierarchyEmployee;
import JDBC.bankModel.implementation.mariadb.HierarchyEmployeeImpl;

public class MainHierarchyEmployee_v00 {
	public static void main(String[] args) {
		 //Search for an hierarchy employee from a product key
		HierarchyEmployeeImpl hierarchyImpl = new HierarchyEmployeeImpl();
		System.out.println(hierarchyImpl.keySearch(31));
		 
//      //to update:
		Employee subaltern1 = new Employee(null, 31, null, null);
		List<Employee> bossList1 = new ArrayList<Employee>();
		Employee oldBoss1 = new Employee(null, 35, null, null);
		Employee newBoss1 = new Employee(null, 39, null, null);
		bossList1.add(oldBoss1);
		bossList1.add(newBoss1);
		HierarchyEmployee hierarchyEmployee1 = new HierarchyEmployee(subaltern1, bossList1);
		System.out.println();
		System.out.println("updted? : " + hierarchyImpl.update(hierarchyEmployee1));
		
		
		//To delete an associated employee
		Employee subalternDelete = new Employee(null, 31, null, null);
		List<Employee> bossListDelete = new ArrayList<Employee>();
		Employee bossDelete = new Employee(null, 39, null, null);
		bossListDelete.add(bossDelete);
		HierarchyEmployee hierarchyEmployeeDelete = new HierarchyEmployee(subalternDelete, bossListDelete);
		System.out.println();
		System.out.println("deleted? : " + hierarchyImpl.delete(hierarchyEmployeeDelete));
		
		
		////To insert an employee and an associated boss
		Employee subAlternInsert = new Employee(null, 31, null, null);
		List<Employee> bossListInsert = new ArrayList<Employee>();
		Employee bossInsert = new Employee(null, 39, null, null);
		bossListInsert.add(bossInsert);
		HierarchyEmployee hierarchyEmployeeInsert = new HierarchyEmployee(subAlternInsert, bossListInsert);
		System.out.println();
		System.out.println("inserted? : " + hierarchyImpl.insert(hierarchyEmployeeInsert));	
		
//      //get List of elements from employees_and_clientproducts table
		System.out.println();
		for (HierarchyEmployee hierarchyEmployee : hierarchyImpl.listElements()) {
			System.out.println();
			System.out.println(hierarchyEmployee);
		}
       
	}
}
