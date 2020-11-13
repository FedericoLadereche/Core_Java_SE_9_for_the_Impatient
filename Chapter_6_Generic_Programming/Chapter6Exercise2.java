/*
 * Exercise:
 * Reimplement the Stack<E> class, using an array to hold the elements. If necessary, grow the array in the push method.Provide two solutions, one with an E[] array and one with an Object[] array.
 * Both solutions should compile without warnings. Which do you prefer, and why?
 * Answer:
 * I prefer the Generic array implementation (E[]) because is more concise and readable
*/

import java.util.Arrays;

public class Chapter6Exercise2 {

	//Program to exercise our generics solutions
	public static void main(String[] args) {
		try {
			StackObjectArray<String> objectStack = new StackObjectArray<>();
			StackGenericArray<String> genericStack = new StackGenericArray<>();
			for(String arg : args) {
				objectStack.push(arg);
				genericStack.push(arg);
			}

			while(!objectStack.isEmpty() && !genericStack.isEmpty()) {
				System.out.println("Pop from the Object Array stack");				
				System.out.println(objectStack.pop().toUpperCase());				
				System.out.println("Pop from the Generic Array stack");
				System.out.println(genericStack.pop().toUpperCase());
			}

			objectStack.pop();
			genericStack.pop();
							
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			System.out.println("Bye! :P");
		}
	}
}
		
//This solution requires a separate cast each time an array element is read.
class StackObjectArray<E> {
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 10;
	
	public StackObjectArray() { this.elements = new Object[DEFAULT_INITIAL_CAPACITY]; }                                 
	public void push(E element) {
		ensureCapacity();
		elements[size++] = element;
	}
	
	public E pop() throws EmptyStackException {
		if(isEmpty()) {
			throw new EmptyStackException("Oops! Tryng to pop from an empty Object Array stack!");
		}
		
		//Appropriate supression of unchecked warning
		//push requires elements to be of type E, so cast is correct
		@SuppressWarnings("unchecked")	
		E result = (E) elements[--size];
		elements[size] = null;//Eliminate obsolete object references or 'unintentional object retentions'.
		
		return result;
	}
	
	public boolean isEmpty() { return size == 0; }

	private void ensureCapacity() {
		if(isFull()) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}
	
	private boolean isFull() { return elements.length == size; }
}

//More readable and concise solution.
//Requires only a single cast (when array is created)
class StackGenericArray<E> {
	private E[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 10;
	
	//The elements array will contain only E instances from push(E).
	//Heap pollution, though harmless in this situation.
	@SuppressWarnings("unchecked")
	public StackGenericArray() { 
		this.elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY]; //Pleasing compiler by casting to generic array type.
	}

	public void push(E element) {
		ensureCapacity();
		elements[size++] = element;
	}

	public E pop() throws EmptyStackException {
		if(isEmpty()) {
			throw new EmptyStackException("Oops! Tryng to pop from empty Generic Array stack!");
		}
		
		E result = elements[--size];
		elements[size] = null;//Eliminate obsolete object references or 'unintentional object retentions'.
		
		return result;
	}

	
	public boolean isEmpty() { return size == 0; }

	private void ensureCapacity() {
		if(isFull()) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}
	
	private boolean isFull() { return elements.length == size; }
}

class EmptyStackException extends Exception {
	public EmptyStackException(String message) {
		super(message);
	}
}

