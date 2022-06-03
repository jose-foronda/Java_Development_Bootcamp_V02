package JDBC.bankModel;

import JDBC.bankModel.entities.ProductType;
import JDBC.bankModel.implementation.mariadb.ProductTypeImpl;

public class Main_ProductType_v00 {
	public static void main(String[] args) {
        ProductType myProductType = null;
        
        ProductTypeImpl productTypeImpl = new ProductTypeImpl();
        
        myProductType = productTypeImpl.keySearch(4);
        System.out.println(myProductType);
        
        //update productType
        ProductType myprodProductType2 = new ProductType(4, "PRESTAMO");
        System.out.println("updted? : " + productTypeImpl.update(myprodProductType2));
        
        //delete productType
        System.out.println("deleted productType?: " + productTypeImpl.delete(myprodProductType2));
        
        //Insert productType
        //System.out.println("Inserted productType?: " + productTypeImpl.insert(myprodProductType2));
        
        //get List of elements from cities table
        System.out.println();
        for (ProductType productType : productTypeImpl.listElements()) {
			System.out.println(productType);
		}
         
	}
}
