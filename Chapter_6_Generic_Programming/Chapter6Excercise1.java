import java.util.ArrayList;
/*
	Implement a class Stack<E> that manages an array list of elements of type E. Provide methods push, pop, and isEmpty	 
*/
public class Chapter6Excercise1 {

	public static void main(String[] args) {
		try {
			Stack<Integer> stack = new Stack<>();
			System.out.println("Pushing one element to the stack");
			stack.push(1);
			System.out.println("Empty stack? " + stack.isEmpty());
			Integer poped = stack.pop();
			System.out.println("Element poped from the stack" + poped);
			System.out.println("Empty stack? " + stack.isEmpty());
			Integer otherPoped = stack.pop();
							
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			System.out.println("Bye! :P");
		}
	}
}

	class Stack<E> {
		private ArrayList<E> elements;
		private int size = 0;

		public Stack() { this.elements = new ArrayList<>(); }

		public void push(E element) {
		elements.add(element);
		size++;
		}	

		public E pop() throws InitializationException {
			if(size > 0) {
				E last = elements.get(size - 1);
				elements.remove(size - 1);
				size--;

				return last;

			}	
		
			throw new InitializationException("Stack is empty!");
		}

		public boolean isEmpty() {
			return size == 0;
		}	
}

class InitializationException extends Exception {
	public InitializationException(String message) {
		super(message);
	}
}
