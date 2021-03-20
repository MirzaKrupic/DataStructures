package ds.queue.linked;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
	private Node<Item> first;
	private Node<Item> last;
	private int length = 0;
	
	public void enqueue(Item item) {
		Node<Item> olast = last;
		last = new Node<Item>();
		last.item = item;
		last.next = null;
		if(isEmpty()) first = last;
		else olast.next = last;
		length++;
	}
	
	public Item dequeue() {
		Item item = first.item;
		first = first.next;
		if(isEmpty()) last = null;
		length--;
		return item;
	}
	
	public boolean isEmpty() {
		return first==null;
	}
	
	public int size() {
		return length;
	}
	
	public Iterator<Item> iterator(){
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator<Item>{
		Node<Item> current = first;
		
		public boolean hasNext() {
			return current != null;
		}

		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
	
	
	
}
