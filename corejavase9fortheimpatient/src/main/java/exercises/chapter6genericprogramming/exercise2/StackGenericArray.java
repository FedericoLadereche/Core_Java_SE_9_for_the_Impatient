package exercises.chapter6genericprogramming.exercise2;

import java.util.Arrays;

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
			throw new EmptyStackException("Oops! Trying to pop from empty Generic Array stack!");
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



