//StackEmptyException.java
//Sean Coady

package stack;

//thrown on attempt to pop() / peek() an empty stack

public class StackEmptyException extends RuntimeException
{
  //post: initialize this exception to report theMessage
  public StackEmptyException(String theMessage)
  {
    super(theMessage);
  }
}