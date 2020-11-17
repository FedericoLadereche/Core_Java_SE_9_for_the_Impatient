package exercises.chapter6genericprogramming.exercise1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;

public class StackTest {

  private Stack<Integer> stack;
  int one = 1;
  int two = 2;
  int three = 3;

  @Before
  public void setup() {
    stack = new Stack<>();
  }

  @Test
  public void PushMethodtest() {

    assertTrue("Empty stack! Before any push", stack.isEmpty());

    stack.push(one);
    assertFalse("Not empty stack!", stack.isEmpty());

    stack.push(two);
    assertFalse("Not empty stack!", stack.isEmpty());

    stack.push(three);
    assertFalse("Not empty stack!", stack.isEmpty());
  }

  @Test
  public void getExceptionPoppingEmptyStackTest() {
    InitializationException thrown = assertThrows(InitializationException.class, () -> stack.pop());

    assertEquals("Stack is empty!", thrown.getMessage());

    assertTrue(stack.isEmpty());
  }

  /*
   * @Test public void testExceptionMessage() { try { stack.pop();
   * fail("Expected an IndexOutOfBoundsException to be thrown"); } catch
   * (InitializationException initializationException) {
   * assertThat(initializationException.getMessage(), is("Stack is empty!")); } }
   */

  @Test
  public void popMethodTest() {
    assertTrue("Empty stack! Before any push", stack.isEmpty());

    stack.push(one);
    assertFalse("Not empty stack!", stack.isEmpty());

    try {
      stack.pop();
      assertTrue("Empty stack again", stack.isEmpty());
    } catch (InitializationException e) {
      e.printStackTrace();
    }
  }
}
    