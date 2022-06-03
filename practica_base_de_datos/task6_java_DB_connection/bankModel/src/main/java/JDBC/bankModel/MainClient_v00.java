package JDBC.bankModel;

import JDBC.bankModel.entities.City;
import JDBC.bankModel.entities.Client;
import JDBC.bankModel.implementation.mariadb.ClientImpl;

public class MainClient_v00 {
	public static void main(String[] args) {
        Client myClient = null;
        
        ClientImpl clientImpl = new ClientImpl();
        //Search for an client with an Id
        myClient = clientImpl.keySearch("CC1085");
        System.out.println(myClient);
        
        //update client
        Client myClient2 = new Client("Juan Foronda Melo", "CC1097", new City(15, null), "Gaitan Mz Q#20", null);
        System.out.println("updted? : " + clientImpl.update(myClient2));
        
        //delete client
        System.out.println("deleted client?: " + clientImpl.delete(myClient2));
        
        //Insert client
        System.out.println("Inserted client?: " + clientImpl.insert(myClient2));
        
        //get List of elements from clients table
        System.out.println();
        for (Client client : clientImpl.listElements()) {
			System.out.println(client);
		}
        
	}
}
