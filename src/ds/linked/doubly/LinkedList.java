package ds.linked.doubly;

import java.util.Iterator;

public class LinkedList<Item> implements Iterable<Item> {
	
	Node<Item> head;
	Node<Item> tail;
	int size = 0;
	
	public void addToFront(Item item) {
		Node<Item> newNode = new Node<Item>();
		newNode.data = item;
		newNode.next = head;
		if(head != null) head.prev = newNode;
		else {
			tail = newNode;
		}
		head = newNode;
		size++;
	}
	
	public void addToRear(Item item) {
		Node<Item> newNode = new Node<Item>();
		newNode.data = item;
		if(head == null) {
			head = newNode;
			tail = newNode;
		}else {
			Node<Item> current = head;
			while(current.next != null) {
				current = current.next;
			}
			newNode.prev = current;
			current.next = newNode;
			tail = current.next;
		}
		size++;
	}
	
	public void removeFromRear() {
		if (head == null) {
			throw new IndexOutOfBoundsException("The linked list is empty.");
		} else if (size == 1) {	
			head = null;
			tail = null;
		} else {															
			tail = tail.prev;
			tail.next = null;
		}
		size--;																
	}
	
	public void removeFromFront() {
		if(head == null) {
			throw new IndexOutOfBoundsException("The linked list is empty.");
		}else if (size == 1) {
			head = null;
			tail = null;
		}else {
		head = head.next;
		head.prev = null;
		}
		size--;
	}
	
	public int count() {
		return size;
	}

	public Iterator<Item> iterator() {
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator<Item>{

		Node<Item> current = head;
		
		public boolean hasNext() {
			return current != null;
		}


		public Item next() {
			Item item = current.data;
			current = current.next;
			return item;
		}
		
	}
}
