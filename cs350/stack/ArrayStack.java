//ArrayStack.java
//Sean Coady

package stack;

//array implementation of Stack

public class ArrayStack implements Stack
{
  private Object[] element;
  private int size =0;
  public static final int DEFAULT_CAPACITY = 10;
  
  //post: initialize to empty stack with initial capacity
  public ArrayStack(int initialCapacity)
  {
    element = new Object[initialCapacity];
	 size = 0;
  }
  
  //post: initialize to empty stack with DEFAULT_CAPACITY
  public ArrayStack()
  {
    this(DEFAULT_CAPACITY);
  }
  
  //post: returns number of elements currently in stack
  public int size()
  {
    return size;
  }
  
  //post: returns true if stack is empty, false if not
  public boolean isEmpty()
  {
    if(size == 0)
	 return true;
	 else
	 return false;
  }
  
  //post: theElement is added to the top of the stack
  public void push(Object theElement)
  {
    if(size == element.length)
	   this.doubleArrayCapacity();
	 element[size] = theElement;
	 size++;
  }
  
  //post: doubles element array's capacity
  public void doubleArrayCapacity()
  {
    Object[] array = new Object[2*size];
	 for(int i =0; i < size; i++)
	 {
	   array[i] = element[i];
	 }
	 element = array;
  }
  
  //pre: stack not empty
  //post: removes and returns top element
  public Object pop() throws StackEmptyException
  {
    if(this.isEmpty())
	  throw new StackEmptyException("cant pop");
	 Object removedElement = element[size-1];
	 size--;
	 return removedElement;
  }
  
  //pre: stack not empty
  //post: returns top element (stack is unchanged)
  public Object peek() throws StackEmptyException
  {
    if(this.isEmpty())
	  throw new StackEmptyException("can't peek");
	 return element[size-1];
  }
  
  //post: returns string containing stack elements
  //in top to bottom order, separated by commas
  public String toString()
  {
    String theSeparator = ""; 
	 String theString = "";
	 int i = size-1;
	 while(i >= 0)
	 {
	   theString = theString+ theSeparator+ element[i].toString();
		theSeparator = ",";
		i--;
    }
	 return theString;
  }
}