//node.Node
//Sean Coady

package node;

//a node contains one element of a singly linked list

public class Node
{
  private Object element = null;
  private Node next = null;
  
  //post: initialize this to contain theElement and and point to theNext
  public Node(Object theElement, Node theNext)
  {
    setElement(theElement);
	 setNext(theNext);
  }
  
  //post: initialize this to the empty Node
  public Node()
  {
    this(null,null);
  }
  
  //post: stored theElement in this Node
  public void setElement(Object theElement)
  {
    element = theElement;
  }
  
  //post: made theNext the next node after this one
  public void setNext(Node theNext)
  {
    next = theNext;
  }
  
  //post: returns element stored in node
  public Object getElement()
  {
    return element;
  }
  
  //post: returns the next node after this one
  public Node getNext()
  {
    return next;
  }
}