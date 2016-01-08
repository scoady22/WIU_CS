// stack.stack
// Ahmed Hakami
// 10/09/2009

 package stack;
 
 //a stack stores elements in last-in-first-out linear order
 //only the top elements can be viewd or removed
 // new elements can only be added at the top
 
 public interface Stack
 {
	// post: return number of elements currently in this stack
	public int size( );
	
	// post: return true if this stack is empty, false if not
	public boolean isEmpty( );
	
	// post: theElement is added to top of this stack
	public void push(Object theElement );
	
	//pre: stack not empty
	//post: removes top element and return it
	public Object pop( )throws StackEmptyException;
	
	//pre: stack not empty
	//post: return top element (stack is unchanged)
	public Object peek( )throws StackEmptyException;
}