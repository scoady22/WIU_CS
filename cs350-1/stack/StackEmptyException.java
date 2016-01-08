// StackEmptyException.java
// Ahmed Hakami
// 10/09/2009

package stack;
// thrown on attempt to pop () or peek() an empty stack
public class StackEmptyException extends RuntimeException
{
	// post: initialize this exception to report theMessage
	public StackEmptyException (String theMessage)
	{
		super (theMessage);
	}

}