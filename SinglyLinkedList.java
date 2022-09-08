package singlylinkedlist;

//Tiffany Kawamura ACO201 Edited Version 09/06/22
//Module 2: Linked List Implementation Assignment 

public class SinglyLinkedList<E> {
	private static class Node<E> {
		private E element;
		private Node<E> next;
		public E data;

		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}

		public E getElement() {
			return element;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> n) {
			next = n;
		}
	}

	private Node<E> head;
	private Node<E> tail;
	private int size;

	public SinglyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	public int length() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E getFirst() {
		if (isEmpty()) {
			return null;
		}
		return head.getElement();
	}

	public E getLast() {
		if (isEmpty()) {
			return null;
		}
		return tail.getElement();
	}

	public void addFirst(E e) {
		head = new Node<E>(e, head);
		if (isEmpty()) {
			tail = head;
		}
		size++;
	}

	public void addLast(E e) {
		Node<E> newest = new Node<E>(e, null);
		if (isEmpty()) {
			head = newest;
		} else {
			tail.setNext(newest);
		}
		tail = newest;
		size++;
	}

	public E removeFirst() {
		if (isEmpty()) {
			return null;
		} 

		E answer = head.getElement();
		head = head.getNext();
		size--;
		if (isEmpty()) {
			tail = null;
		}
		return answer;
	}

//setup and added a removeLast method
//remove last element of list and return it
//if list is empty return null
	
	public E removeLast() {		
		if (isEmpty()) {
			return null;
		}
		
		SinglyLinkedList.Node<E> pointer = head;
		
		E answer = tail.getElement();
	    size--;
	    if (isEmpty()) {
	    	head = null;
	    	tail = null;
	    } else {
	    	while (pointer.next.next != null) {
	    		pointer = pointer.next;
	    	}
	    }
		pointer.next = null;
		tail = pointer;
	    return answer;
	}

//setup and added a get method
//return the nth element of list
//if n>=length() return null
//must return type E
	public E get(int n) {
		SinglyLinkedList.Node<E> pointer = head;
		
		if (length() <= n) 
			return null;
		for (int i = 0; i<n; i++) {
			pointer = pointer.next;
		}
		E answer = pointer.getElement();
		return answer;
	}

	
//setup and added a delete method
//remove nth element from the list (including n = 0)
//if n>= length() do not delete element-> no error or exception
	void delete(int n) {
		if (isEmpty()) {
			head=null;
			tail=null;
		}
		if (n==0) {
			removeFirst();
		} else if (n==length()) {
			removeLast();
		} else {
			SinglyLinkedList.Node<E> pointer = head;
			SinglyLinkedList.Node<E> after = head;
			size--;
			for (int i = 0; i<n-2; i++) {
				pointer = pointer.next;
			}
			after = pointer.next.next;
			pointer.next = null;
			pointer.setNext(after);
		}
	}

//setup and added a insertAfter method
//insert element e after nth element of the list
//if n>=length() do not insert element -> no error or exception
	void insertAfter(int n, E e) {
		Node<E> newest = new Node<E>(e, null);
		SinglyLinkedList.Node<E> before = head;
		SinglyLinkedList.Node<E> after = head;
		size++;
		if (isEmpty()) {
			head = newest;
		} 
		if (n>=length()){} else {
			for (int i = 0; i<n-1; i++) {
				before = before.next;
			}
			after = before.next;
			before.setNext(newest);
			newest.setNext(after);
		}
		tail = newest;
	}
	
	public String toString() {
		String result = length() + ":[";
		for (Node<E> p = head; p != null; p = p.getNext()) {
			result += p.getElement();
			if (p.getNext() != null) {
				result += ", ";
			}
		}
		result += "]";
		return result;
	}
}