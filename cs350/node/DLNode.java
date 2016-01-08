//node.DLNode
//Sean Coady

package node;


//a DLNode contains one element of a doubly linked list

public class DLNode
{
  private DLNode previous;
  private Object element;
  private DLNode next;
  
  public DLNode()
  {
    this(null,null,null);
  }
  
  //post: initialize this to contain thePrevious, theElement, theNext
  public DLNode(DLNode thePrevious, Object theElement, DLNode theNext)
  {
    setPrevious(thePrevious);
	 setElement(theElement);
	 setNext(theNext);
  }
  
  //post: store theElement in this node
  public void setElement(Object theElement)
  {
    element = theElement;
  }
  
  //post: make thePrevious the node before this one
  public void setPrevious(DLNode thePrevious)
  {
    previous = thePrevious;
  }
  
  //post: make theNext the node after this one
  public void setNext(DLNode theNext)
  {
    next = theNext;
  }
  
  //post: return this nodes element
  public Object getElement()
  {
    return element;
  }
  
  //post: return the node before this one
  public DLNode getPrevious()
  {
    return previous;
  }
  
  //post: return the node after this one
  public DLNode getNext()
  {
    return next;
  }
}