//stack.Stack
//Sean Coady

package stack;


//a stack stores elements in a linear first in last out order
//only the top element can be seen or removed
//new elements are added to the top

public interface Stack
{
  //post: returns the number of elements currently in stack
  public int size();
  
  //post: returns true if stack is empty, false if not
  public boolean isEmpty();
  
  //post: theElement is added to the top of the stack
  public void push(Object theElement);
  
  //pre: stack not empty
  //post: removes top element and returns it
  public Object pop() throws StackEmptyException;
  
  //pre: stack not empty
  //post: returns but does not remove top element
  public Object peek() throws StackEmptyException;
}
