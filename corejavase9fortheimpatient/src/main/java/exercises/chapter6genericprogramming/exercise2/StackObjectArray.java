package exercises.chapter6genericprogramming.exercise2;

import java.util.Arrays;
import java.util.Objects;

//This solution requires a separate cast each time an array element is read.
class StackObjectArray<E> {

    public StackObjectArray(Object[] elements, int size) {
        this.elements = elements;
        this.size = size;
    }

    public Object[] getElements() {
        return this.elements;
    }

    public void setElements(Object[] elements) {
        this.elements = elements;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public StackObjectArray elements(Object[] elements) {
        this.elements = elements;
        return this;
    }

    public StackObjectArray size(int size) {
        this.size = size;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof StackObjectArray)) {
            return false;
        }
        StackObjectArray stackObjectArray = (StackObjectArray) o;
        return Objects.equals(elements, stackObjectArray.elements) && size == stackObjectArray.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements, size);
    }

    @Override
    public String toString() {
        return "{" +
            " elements='" + getElements() + "'" +
            ", size='" + getSize() + "'" +
            "}";
    }
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
			throw new EmptyStackException("Oops! Trying to pop from an empty Object Array stack!");
		}
		
		//Appropriate suppression of unchecked warning
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