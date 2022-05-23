package protalento.eduIT.task5.main;

import entities.Document;
import protalento.eduIT.task5.customCollections.CustomCollection;

public class MainTask5Objects {

	public static void main(String[] args)  {
		
		//Custom Collection
		CustomCollection<Document> customColl = new CustomCollection<Document>();
		
		System.out.println("Collection size is: " + customColl.size());
		System.out.println("Collection is empty? " + customColl.empty());
		
		//Adding elements to the custom collection
		System.out.println();
		System.out.println("*** Adding elements to the collection ***"); 
		customColl.add(new Document("CC", "1097"));
		customColl.add(new Document("CC", "1090"));
		customColl.addLast(new Document("CC", "1091"));
		customColl.addFirst(new Document("CC", "1092"));
		customColl.add(new Document("CC", "1093"));
		customColl.addFirst(new Document("CC", "1094"));
//		customColl.addLast(new Document("CC", "1093"));
//		customColl.addLast(new Document("CC", "1095"));
		customColl.add(new Document("CC", "1096"));
		customColl.addFirst(new Document("CC", "1097")); 
		
		System.out.println("Collection elements: " + customColl);
		System.out.println("Collection size is: " + customColl.size());
		System.out.println("Collection is empty? " + customColl.empty());
		
		
		System.out.println();
		System.out.println("*** Removing First element that matches and returns it ***"); 	
		
		
		
		System.out.println("Collection size before remove document CC1093: " + customColl.size());
		
		System.out.println("Collection before remove first matching element for CC1093: " + customColl);
		System.out.println("Returned element removed: " + customColl.remove(new Document("CC", "1093")));
		System.out.println("Collection after remove first matching element: " + customColl);
		System.out.println("Collection size after remove element: " + customColl.size());
		
		System.out.println();
		System.out.println("*** Adding more elements ***"); 
		System.out.println("Collection before adding more elements: " + customColl);
		customColl.add(new Document("CC", "1093"));
		customColl.addFirst(new Document("CC", "1098"));
		customColl.addLast(new Document("CC", "1093"));
		
		System.out.println("Collection after adding more elements: " + customColl);
		
		System.out.println();
		System.out.println("*** Removing all matching elements ***");  
		System.out.println("Collection before removing matching elements for document CC1093: : " + customColl);
		customColl.removeAll(new Document("CC", "1093")); 
		System.out.println("Collection after removing matching elements for document CC1093: : " + customColl);
		

	}

}
