package JDBC.bankModel;

import java.util.ArrayList;
import java.util.List;

import JDBC.bankModel.entities.Client;
import JDBC.bankModel.entities.Product;
import JDBC.bankModel.entities.ProductType;
import JDBC.bankModel.implementation.mariadb.ProductImpl;

public class MainProduct_v00 {
	public static void main(String[] args) {
        Client myClient = null;
        
        ProductImpl productImpl = new ProductImpl();
        myClient = new Client(null, "CC1094", null, null, null);
        //Search for an employee with an Id
        System.out.println(productImpl.keySearch(myClient.getId()));
        
        //update productType
        List<Product> elementList = new ArrayList<Product>();
        elementList.add(new Product("10C", new ProductType(1, null), null));
        Client myClient2 = new Client(null, null, null, null, elementList);
        System.out.println();
        System.out.println("updted? : " + productImpl.update(myClient2));
        
        //delete productType
        List<Product> deleteElementList = new ArrayList<Product>();
        deleteElementList.add(new Product("10C", null, null));
        Client myClient3 = new Client(null, null, null, null, deleteElementList);
        System.out.println();
        System.out.println("deleted Product?: " + productImpl.delete(myClient3));
        
        //Insert productType
        List<Product> insertElementList = new ArrayList<Product>();
        insertElementList.add(new Product("10C", new ProductType(2, null), null));
        Client myClient4 = new Client(null, "CC1094", null, null, insertElementList);
        System.out.println("Inserted Employee?: " + productImpl.insert(myClient4));
        
        //get List of elements from client_products table
        System.out.println();
        for (Client client : productImpl.listElements()) {
        	System.out.println();
			System.out.println(client);
		}
         
	}
}
