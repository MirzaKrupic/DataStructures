package ds.stack.array;

public class Main {

	public static void main(String[] args) {
Stack<Integer> queue = new Stack<Integer>();
		
		queue.push(1);
		queue.push(2);
		queue.push(3);
		
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		queue.push(4);
		
		System.out.println("queue size: " + queue.size());

	}

}
