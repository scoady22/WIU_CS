//stack.LinkedStack
//Sean Coady

package stack;
import node.*;

//a singly linked implementation of Stack
public class LinkedStack implements Stack
{
  //declaration of instance variables
  private Node topNode;
  private int size;
  
  //post: initialize this to empty Stack
  public LinkedStack()
  {
    topNode = null;
	 size = 0;
  }
  
  //post: returns size of Stack
  public int size()
  {
    return size;
  }
  
  //post: returns true if stack is empty, false if not
  public boolean isEmpty()
  {
    if(size == 0)
	 {
	   return true;
	 }
	 else
	 {
	   return false;
	 }
  }
  
  //post: theElement is added to the top of the stack
  public void push(Object theElement)
  {
    Node theNode = new Node(theElement,null);
	 theNode.setNext(topNode);
	 topNode = theNode;
	 size++;
  }
  
  //pre: stack not empty
  //post: removes top element and returns in
  public Object pop() throws StackEmptyException
  {
    if(this.isEmpty())
	 {
	   throw new StackEmptyException("Can't pop.");
	 }
	 Object removedElement = topNode.getElement();
	 topNode = topNode.getNext();
	 size--;
	 return removedElement;
  }
  
  //pre: Stack not empty
  //post: returns top element, stack remains unchanged
  public Object peek() throws StackEmptyException
  {
    if(this.isEmpty())
	 {
	   throw new StackEmptyException("Can't peek.");
	 }
	 Object top = topNode.getElement();
	 return top;
  }
  
  //post: returns string representation of current stack.
  public String toString()
  {
    String theString="";
	 String theSeparator="";
	 Node hopNode = topNode;
	 int count = 0;
	 while(count<size)
	 {
	   theString = theString+theSeparator+hopNode.getElement();
		hopNode = hopNode.getNext();
		theSeparator = ",";
		count++;
	 }
	return theString;
  }
}
		