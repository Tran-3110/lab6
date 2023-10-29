package main;
import java.util.Arrays;
import java.util.Comparator;
public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;
	public MyArrayList() {
		size = 0;
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		size = 0;
		this.elements = (E[]) new Object[capacity];
		
	}

	
// creates an array of double-size if the array of 
//elements is full  
	public void growSize() {
		E[] arrNew = (E[]) new Object[elements.length*2];
		for (int i = 0; i < elements.length; i++) {
			arrNew[i] = elements[i];
		}
		elements = arrNew;
	}

// Returns the number of elements in this list. 
	public int size() {
		return size;
	}

// Returns whether the list is empty. 
	public boolean isEmpty() {
		return size==0;
	}

// Returns (but does not remove) the element at index i. 
	public E get(int i) throws IndexOutOfBoundsException {
		if(i>=0 && i<size) {
			return elements[i];
		}
		throw new IndexOutOfBoundsException("index "+i+" out of bounds for length "+size);
	}

	// Replaces the element at index i with e, and
//returns the replaced element. ∗/ 
	public E set(int i, E e) throws IndexOutOfBoundsException {
		if(i>=0 && i<size) {
			E oldElement = elements[i];
			elements[i] = e;
			return oldElement;
		}
		throw new IndexOutOfBoundsException("index "+i+" out of bounds for length "+size);
	}

	// It is used to append the specified element at the
//end of a list. 
	public boolean add(E e) {
		if(isFull()) growSize();
		elements[size] = e;
		size++;
		return true;
	}
	
	public boolean isFull() {
		return size == elements.length;
	}
	// Inserts element e to be at index i, shifting all
//subsequent elements later. 

	public void add(int i, E e) throws IndexOutOfBoundsException {
		if(i<0 || i>size) throw new IndexOutOfBoundsException("index "+i +" out of bounds for length "+size);
		if(isFull()) growSize();
		for (int j = size; j >= 0; j--) {
			if(i == j)  {
				elements[i] = e;
				break;
			}
			else {
				elements[j] = elements[j-1];
			}
		}
		size++;
	}

	// Removes and returns the element at index i,
//shifting subsequent elements earlier. 
	public E remove(int i) throws IndexOutOfBoundsException {
		if(i<0 || i>=size) throw new IndexOutOfBoundsException("index "+i+" out of bounds for length "+size);
		boolean check =false;
		for (int j = 0; j < size-1; j++) {
			if(j == i) {
				check = true;
			}
			if(check == true) {
				elements[j] = elements[j+1];
			}
		}
		elements[size-1] = null;
		size--;
		return elements[i];
	}

//Then implements other methods as in Java Collection Framework - ArrayList.java 
// It is used to clear all elements in the list. 
	public void clear() {
		size = 0;
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

// It is used to return the index in this list of the 
//last occurrence of the specified element, or -1 if the 
//list does not contain this element. 
	public int lastIndexOf(Object o) {
		int index = -1;
		for (int i = size-1; i >= 0; i--) {
			if(elements[i].equals(o)) {
				index = i;
				break;
			}
		}
		return index;
	}

// It is used to return an array containing all of the 
	public E[] toArray() {
		E[] array = (E[]) new Object[size];
		for (int i = 0; i < array.length; i++) {
			array[i] = elements[i];
		}
		return array;
	}

// It is used to return a shallow copy of an ArrayList. 
	public MyArrayList<E> clone() {
		MyArrayList<E> arrListNew = new MyArrayList<>();
		arrListNew.elements = elements.clone();
		arrListNew.size = size;
		return arrListNew;
	}

// It returns true if the list contains the specified 
//element 
	public boolean contains(E o) {
		for (int i = 0; i < size; i++) {
			if(elements[i].equals(o)) {
				return true;
			}
		}
		return false;
	}

// It is used to return the index in this list of the 
//first occurrence of the specified element, or -1 if the 
//List does not contain this element. 
	public int indexOf(E o) {
		int index = -1;
		for (int i = 0; i < size; i++) {
			if(elements[i].equals(o)) {
				index = i;
				break;
			}
		}
		return index;
	}

// It is used to remove the first occurrence of the 
//specified element. 
	public boolean remove(E e) {
		boolean check =false;
		for (int i = 0; i < size-1; i++) {
			if(elements[i].equals(e)) {
				check = true;
			}
			if(check == true) {
				elements[i] = elements[i+1];
			}
		}
		elements[size-1] = null; 
		size--;
		return check;
	}
// It is used to sort the elements of the list on the 
//basis of specified comparator. 
	public void sort(Comparator<E> c) {
		Arrays.sort(elements, 0, size, c);
	}
	
	
	
	@Override
	public String toString() {
		if(size == 0) return "[]";
		String result = "[";
		for (int i = 0; i < size; i++) {
			if(i == size-1) {
				result+=elements[i]+"]";
			}
			else {
			result+= elements[i]+", ";
			}
		}
		return result;
	}
}
