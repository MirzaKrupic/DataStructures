package ds.stack.array;

public class Stack<Item> {
	private int length=0;

	@SuppressWarnings("unchecked")
	private Item[] s = (Item[]) new Object[1];
	
	@SuppressWarnings({ "unchecked" })
	private void resize(int capacity) {
		Item[] copy = (Item[]) new Object[capacity];
		for(int i=0; i<length; i++) {
			copy[i] = s[i];
		}
		s=copy;
	}
	
	public void push(Item item) {
		if(length == s.length) resize(2 * s.length);
		s[length++] = item;
	}
	
	public Item pop() {
		Item item = s[--length];
		s[length] = null;
		if(length > 0 && length == s.length/4) resize(s.length/2);
		return item;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	public int size() {
		return length;
	}
}
