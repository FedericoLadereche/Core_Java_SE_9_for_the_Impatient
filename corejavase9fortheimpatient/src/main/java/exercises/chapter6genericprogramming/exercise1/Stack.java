package exercises.chapter6genericprogramming.exercise1;

import java.util.ArrayList;

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
