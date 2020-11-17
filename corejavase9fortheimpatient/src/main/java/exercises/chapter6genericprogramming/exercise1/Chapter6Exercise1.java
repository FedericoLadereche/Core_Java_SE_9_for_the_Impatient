package exercises.chapter6genericprogramming.exercise1;
/*
	Implement a class Stack<E> that manages an array list of elements of type E. 
	Provide methods push, pop, and isEmpty	 
*/
public class Chapter6Exercise1 {

	public static void main(String[] args) {
		try {
			Stack<Integer> stack = new Stack<>();
			System.out.println("Pushing one element to the stack");
			stack.push(1);
			System.out.println("Empty stack? " + stack.isEmpty());
			Integer popped = stack.pop();
			System.out.println("Element popped from the stack" + popped);
			System.out.println("Empty stack? " + stack.isEmpty());
			Integer otherPopped = stack.pop();
							
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			System.out.println("Bye! :P");
		}
	}
}	


