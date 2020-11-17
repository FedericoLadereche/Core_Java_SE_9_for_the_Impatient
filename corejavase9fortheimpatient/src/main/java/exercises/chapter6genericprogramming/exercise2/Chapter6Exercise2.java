package exercises.chapter6genericprogramming.exercise2;

/*
 * Exercise:
 * Reimplement the Stack<E> class, using an array to hold the elements. If necessary, grow the array in the push method.Provide two solutions, one with an E[] array and one with an Object[] array.
 * Both solutions should compile without warnings. Which do you prefer, and why?
 * Answer:
 * I prefer the Generic array implementation (E[]) because is more concise and readable
*/

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

