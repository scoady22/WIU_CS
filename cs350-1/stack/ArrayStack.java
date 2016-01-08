// stack.ArrayStack
// Ahmed Hakami
// 10/9/2009

 
package stack;
// an extensible array implementation of Stack
public class ArrayStack implements Stack
{
	private Object[] element;
	private int size = 0;
	public static final int DEFAULT_CAPACITY = 10;
		
	// post: initialize to empty stack with initialCapacity
	public ArrayStack( int initialCapacity )
	{
		element = new Object[ initialCapacity ];
		size = 0;
	}
		
	// post: initialize to empty stack with DEFAULT-CAPACITY
	public ArrayStack()
	{
		this (DEFAULT_CAPACITY);
		
	}
		
	// post: returns number of elements currently in this stack
	public int size()
	{
		return size;
	}
		
	// post: returns true if this stack is empty, false if not
	public boolean isEmpty()
	{
		if( size == 0 )
		return true;
		else
		return false;
	}
		
	// post: theElement is added to the top of this stack
	public void push( Object theElement )
	{
		if( size == element.length )
	   	this.doubleArrayCapacity();
		element[size] = theElement;
		size++;
	}
	
	// post: doubles element arrays capacity
	public void doubleArrayCapacity()
	{
		Object [] ar = new Object[2*size];
		for(int i=0; i < size;i++)
		{
		ar[i] = element[i];
		}
	   element = ar;
	}		
	// pre: stack not empty
	// post: removes top element and returns it
	public Object pop() throws StackEmptyException
	{
		if( this.isEmpty() )
		throw new StackEmptyException("can't pop");
		Object removedElement = element[size-1];
		element[size-1] = null;
		size--;
		return removedElement;
	}
		
	// pre: stack not empty
	// post: returns top element (stack is unchanged)
	public Object peek( ) throws StackEmptyException
	{
		if( this.isEmpty() )
		throw new StackEmptyException("can't peek");
		return element[size-1];
	}
		
	// post: returns string containing stack elements
	// in top to bottom order, seperated by commas
	public String toString()
	{
		String theSeperator = "";
		String theString = "";
		int i = size-1;
		while( i >= 0 )
  	{
		  theString = theString + theSeperator + element[i].toString();
		  theSeperator = ",";
		  i--;
	  }
		return theString;
	}
}
