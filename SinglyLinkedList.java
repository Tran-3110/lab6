package main;

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size;

	public SinglyLinkedList() {
		super();
	}

// Returns the number of elements in the list. 
	public int size() {
		return size;
	}

// Returns true if the list is empty, and false 
//otherwise. 
	public boolean isEmpty() {
		return size == 0;
	}

// Returns (but does not remove) the first element in 
//the list. 
	public E first() {
		return head.getData();
	}

// Returns (but does not remove) the last element in 
//the list. 
	public E last() {
		return tail.getData();
	}

// Adds a new element to the front of the list. 
	public void addFirst(E e) {
		Node<E> newNode = new Node<E>(e);
		if (size == 0) {
			head = tail = newNode;
		} else {
			newNode.setNext(head);
			head = newNode;
		}
		size++;
	}

// Adds a new element to the end of the list. 
	public void addLast(E e) {
		Node<E> newNode = new Node<E>(e);
		if (size == 0) {
			head = tail = newNode;
		} else {
			tail.setNext(newNode);
			tail = newNode;
		}
		size++;
	}

// Removes and returns the first element of the list. 
	public E removeFirst() {
		if(size == 0) throw new NoSuchElementException();
		E e = head.getData();
		Node<E> temp = head.getNext();
		head = temp;
		temp = null;
		size--;
		return e;
	}

// Removes and returns the last element of the list. 
	public E removeLast() {
		if(size == 0) throw new NoSuchElementException();
		E e = tail.getData();
		if(size == 1) {
			head = tail = null;
		}
		else {
		Node<E> temp = head;
		while(temp.getNext().getNext() != null) {
		     temp = temp.getNext();
		}
		temp.setNext(null);
		tail = temp;
		}
		size--;
		return e;
	}
	
	public void print() {
		Node<E> temp = head;
		while (temp != null) {
			if (temp.getNext() == null) {
				System.out.print(temp.getData());
				break;
			}
			System.out.print(temp.getData() + "->");
			temp = temp.getNext();
		}
		System.out.println();
	}

}
