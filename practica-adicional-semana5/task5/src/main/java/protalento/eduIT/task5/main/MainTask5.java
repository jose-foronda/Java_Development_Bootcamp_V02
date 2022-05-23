package protalento.eduIT.task5.main;

import protalento.eduIT.task5.customCollections.CustomCollection;

public class MainTask5 {
	public static void main(String[] args) {
		
		//Custom Collection
		CustomCollection<String> customColl = new CustomCollection<String>();
		
		System.out.println("Collection size is: " + customColl.size());
		System.out.println("Collection is empty? " + customColl.empty());
		
		//Adding elements to the custom collection
		System.out.println();
		System.out.println("*** Adding elements to the collection ***"); 
		customColl.addLast("1");
		customColl.addFirst("2");
		customColl.addFirst("3");
		customColl.addFirst("4");
		customColl.add("5");
		customColl.add("6");
		customColl.addFirst("7");
		customColl.addLast("3");
		customColl.addFirst("8");
		customColl.addLast("9");
		customColl.addLast("10");
		customColl.addLast("3");
		customColl.addFirst("11");
		System.out.println("Collection elements: " + customColl);
		System.out.println("Collection size is: " + customColl.size());
		System.out.println("Collection is empty? " + customColl.empty());
		
		
		System.out.println();
		System.out.println("*** Removing First element that matches and returns it ***"); 	
		
		
		
		System.out.println("Collection size before remove element \"3\": " + customColl.size());
		
		System.out.println("Collection before remove first matching element: " + customColl);
		System.out.println("Returned element removed: " + customColl.remove("3"));
		System.out.println("Collection after remove first matching element: " + customColl);
		System.out.println("Collection size after remove element: " + customColl.size());
		
		System.out.println();
		System.out.println("*** Adding more elements ***"); 
		System.out.println("Collection before adding more elements: " + customColl);
		customColl.add("3");
		customColl.addLast("3");
		customColl.addFirst("12");
		System.out.println("Collection after adding more elements: " + customColl);
		
		System.out.println();
		System.out.println("*** Removing all matching elements ***");  
		System.out.println("Collection before removing matching elements for \"3\": " + customColl);
		customColl.removeAll("3"); 
		System.out.println("Collection after removing matching elements for \"3\": " + customColl);
		

	} 
}
