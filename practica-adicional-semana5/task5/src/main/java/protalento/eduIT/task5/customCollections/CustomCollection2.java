package protalento.eduIT.task5.customCollections;

import java.util.Arrays;

public class CustomCollection2<T> {
	private int size = 5;
	private int elementCounter;
	
	
	private T[] customArray;
	
	public CustomCollection2() {
		super(); 
		customArray = (T[]) new Object[size];
	}
	
	public int size() {
		return elementCounter;
	}
	
	public void addFirst() {
		elementCounter++;
	}
	
	public void addLast(T element) {
		elementCounter++;
		
		if (elementCounter > size) { 
			size = 2*(elementCounter - 1);
			customArray = copyCollection(customArray, size);
		}
		
		customArray[elementCounter - 1] = element;
		
	}
	
	private T[] copyCollection(T[] coll, int size) {
		T[] copyCollection = (T[]) new Object[size];
		
		for (int i = 0; i < coll.length; i++) {
			copyCollection[i] = coll[i];
		}
		return copyCollection;
	}

	@Override
	public String toString() {
		return "CustomCollection [size=" + size + ", customArray=" + Arrays.toString(toStringCollection()) + ", elementCounter="
				+ elementCounter + "]";
	}
	
	private T[] toStringCollection() { 
		return Arrays.copyOfRange(customArray, 0, elementCounter);		
	}
	
	
	
	
}
