package protalento.eduIT.task5.customCollections;

import java.util.Arrays;

public class CustomCollection3<T> {
	private int size = 5;
	private int elementCounter;
	
	
	private T[] customArray;
	
	public CustomCollection3() {
		super(); 
		customArray = (T[]) new Object[size];
	}
	
	public int size() {
		return elementCounter;
	}
	
	public void addFirst(T element) {
		collectionReSizeValidation();
		elementCounter++;
		shiftUpOnePosition();
		customArray[0] = element;
	}

	public void addLast(T element) { 
		collectionReSizeValidation();
		elementCounter++;
 		customArray[elementCounter - 1] = element;
	} 
	
	public boolean empty() {
		return elementCounter == 0;
	}
	
	//Helper methods
	private void collectionReSizeValidation() {
		if (isSizeExceeded()) {
			size *= 2;
			customArray = copyCollection(customArray, CollectionWithIncreasedSize(size));
		}
	}
	
	private void shiftUpOnePosition() {
		for (int i = elementCounter - 1; i > 0; i--) {
			customArray[i] = customArray[i - 1]; 
		}
	}
	
	private T[] CollectionWithIncreasedSize(int size) {
		return (T[]) new Object[size];
	}
	
	private T[] copyCollection(T[] collectionFrom, T[] collectionTo) {
		for (int i = 0; i < collectionFrom.length; i++) {
			collectionTo[i] = collectionFrom[i];
		}
		return collectionTo;
	}
	
	private boolean isSizeExceeded() {
		return (elementCounter + 1) > size;
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
