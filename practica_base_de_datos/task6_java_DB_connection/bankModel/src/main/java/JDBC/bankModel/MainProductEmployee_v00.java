package JDBC.bankModel;

import java.util.ArrayList;
import java.util.List;

import JDBC.bankModel.entities.Client;
import JDBC.bankModel.entities.Employee;
import JDBC.bankModel.entities.Product;
import JDBC.bankModel.implementation.mariadb.ProductEmployeeImpl;

public class MainProductEmployee_v00 {
	public static void main(String[] args) {
//        Client myClient = null;
        
        ProductEmployeeImpl productEmployeeImpl = new ProductEmployeeImpl();
        Product myProduct = new Product("10V", null, null);
        //Search for an product employee from a product key
        System.out.println(productEmployeeImpl.keySearch(myProduct.getId()));
        
        
        //to update:
        List<Employee> productEmployeeList = new ArrayList<Employee>();
        //Employee old
        productEmployeeList.add(0, new Employee(null, 45, null, null));
        //Employee new
        productEmployeeList.add(1, new Employee(null, 32, null, null));
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Product("10V", null, productEmployeeList));
        Client myClientUpdate = new Client(null, null, null, null, productList);
        System.out.println("updted? : " + productEmployeeImpl.update(myClientUpdate));
        
        
        //To delete an associated employee
        List<Employee> productEmployeeDelete = new ArrayList<Employee>();
        //employee to delete
        productEmployeeDelete.add(new Employee(null, 43, null, null));
        List<Product> productListDelete = new ArrayList<Product>();
        productListDelete.add(new Product("10V", null, productEmployeeDelete));
        Client myClientDelete = new Client(null, null, null, null, productListDelete);
        System.out.println("deleted Product Employee?: " + productEmployeeImpl.delete(myClientDelete));
        
        
        //To insert an associated employee
        List<Employee> productEmployeeInsert = new ArrayList<Employee>();
        //employee to insert
        productEmployeeInsert.add(new Employee(null, 43, null, null));
        List<Product> productListInsert = new ArrayList<Product>();
        productListInsert.add(new Product("10V", null, productEmployeeInsert));
        Client myClientInsert = new Client(null, null, null, null, productListInsert);
        System.out.println("Inserted ProductEmployee?: " + productEmployeeImpl.insert(myClientInsert));
        
        
        //get List of elements from employees_and_clientproducts table
        System.out.println();
        for (Client client : productEmployeeImpl.listElements()) {
        	System.out.println();
			System.out.println(client);
		}
         
	}
}
