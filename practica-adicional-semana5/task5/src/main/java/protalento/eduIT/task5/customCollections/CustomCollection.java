package protalento.eduIT.task5.customCollections;

import java.util.Arrays;

public class CustomCollection<T> {
	//Helper private fields
	private int size = 5;
	private int elementCounter;
	private T removedElement;
	
	//Custom Collection
	private T[] customArray;
	
	//Cosntructor
	public CustomCollection() {
		super(); 
		customArray = (T[]) new Object[size];
	}
	
	public int size() {
		return elementCounter;
	}
	
	public void add(T element) {
		int rand = (int) (Math.random() * 2);
		switch (rand) {
		case 1:
			addFirst(element);
			break;
		default:
			addLast(element);
			break;
		}
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
	
	public T remove(T element) {
		removeCollectionElements(matchingElementsRemove(element)); 
		
		T removedElementReturned = removedElement;
		removedElement = null;
		return removedElementReturned;
	}
	
	public void removeAll(T element) {
		removeCollectionElements(matchingElementsRemoveAll(element)); 
	}
	
	/*** Helper methods ***/
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
		return "CustomCollection " + Arrays.toString(getCollection()) + " ---> elementCounter="
				+ elementCounter + "]";
	}
	
	private T[] getCollection() { 
		return Arrays.copyOfRange(customArray, 0, elementCounter);		
	}
	
	private CustomCollection<Integer> matchingElementsRemove(T element) {
		CustomCollection<Integer> matchingCounter = new CustomCollection<Integer>();
		
		for (int i = 0; i < elementCounter; i++) {
			if (customArray[i].equals(element)) {
				removedElement = element;
				matchingCounter.addLast(i);
				return matchingCounter;
			}
		}
		return matchingCounter;
	}
	
	private CustomCollection<Integer> matchingElementsRemoveAll(T element) {
		CustomCollection<Integer> matchingCounter = new CustomCollection<Integer>();
		
		for (int i = 0; i < elementCounter; i++) {
			if (customArray[i].equals(element)) {
				matchingCounter.addLast(i);
			}
		}
		return matchingCounter;
	}
	
	private void removeCollectionElements(CustomCollection<Integer> elementIndex) {
		
		if (elementIndex.empty()) {
			return;
		}
		
		T[] cleanedCollection = (T[]) new Object[size];
		Object[] indexCollectionToRemove = elementIndex.customArray;
//		System.out.println("tamanio indix " + elementIndex.elementCounter);
		int copyCounter = 0;
		int valueIndexToRemove = 0;
		for (int i = 0; i < elementCounter; i++) {
//			System.out.println("entro con (Integer)indexCollectionToRemove[valueIndexToRemove] =" + (Integer)indexCollectionToRemove[valueIndexToRemove]);
			if ( valueIndexToRemove < (elementIndex.elementCounter) && i == ((Integer)indexCollectionToRemove[valueIndexToRemove]).intValue()) {
				valueIndexToRemove++;
			}else {
				cleanedCollection[copyCounter] = customArray[i]; 
				copyCounter++;
			}
		}
		elementCounter -= elementIndex.elementCounter;
		customArray = cleanedCollection;
	}
}
