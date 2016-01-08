//list.LinkedList
//Sean Coady

package list;
import java.util.Iterator;
import java.util.NoSuchElementException;
import node.DLNode;

// a List is a linear sequence of elements ordered by their indexed position in the List
// (indices 0 to szie-1), List elements may be added or deleted or viewed via their index

public class LinkedList implements List
{
  private DLNode headNode;
  private int size;
  
  //post: initialize this to empty LinkedList
  public LinkedList()
  {
    headNode = new DLNode();
	 headNode.setNext(headNode);
	 headNode.setPrevious(headNode);
	 size = 0;
  }
  
  //post: checks to see if given index is in range 0..maxIndex
  //      throws IndexOutOfBoundsException if not
  private void CheckPreCondition(int theIndex, int maxIndex)
  {
    if(theIndex<0 || (theIndex > maxIndex))
	 {
	   throw new IndexOutOfBoundsException(theIndex +" is not in range 0 - "+maxIndex);
	 }
  }
  
  //post: returns number of elements in this list
  public int size()
  {
    return size;
  }
  
  //post: returns true if this list is empty
  //      false if not
  public boolean isEmpty()
  {
    return(size==0);
  }
  
  //post: returns the index of the first occurence of theElement in this list
  //      or returns -1 if theElement is not contained in this list
  public int indexOf(Object theElement)
  {
    int hopIndex= 0;
	 DLNode hopNode = getNodeAt(0);
	 
	 while(hopIndex < size)
	 {
	   if(theElement.equals(hopNode.getElement()))
		{
		  return hopIndex;
		}
		
		hopNode = hopNode.getNext();
		hopIndex++;
	 }
	 return -1;
  }
  
  //post: returns true if theElement is contained in this list (if some element.equals(theElement))
  //      false if not
  public boolean contains(Object theElement)
  {
    int hopIndex = 0;
	 DLNode hopNode = getNodeAt(0);
	 
	 while(hopIndex < size)
	 {
	   if(theElement.equals(hopNode.getElement()))
		{
		  return true;
		}
		hopNode = hopNode.getNext();
		hopIndex++;
	 }
	 return false;
  }
  
  //post: returns the node at Index theIndex if 0 <=theIndex < size()
  //      returns the head node if theIndex == size()
  public DLNode getNodeAt(int theIndex)
  {
    DLNode hopNode = headNode.getNext();
	 int hopCount = 0;
	 while(hopCount < theIndex)
	 {
	   hopNode = hopNode.getNext();
		hopCount++;
    }
	 return hopNode;
  }
  
  //pre: 0<=theIndex <=size()
  //post: adds theElement at position theIndex and returns it
  //      (elements previously at theIndex...size-1 are now theIndex+1..size
  public void add(int theIndex, Object theElement) throws IndexOutOfBoundsException
  {
    CheckPreCondition(theIndex, size);
	 DLNode afterNode = getNodeAt(theIndex);
	 DLNode beforeNode = afterNode.getPrevious();
	 DLNode theNode = new DLNode(beforeNode, theElement, afterNode);
	 beforeNode.setNext(theNode);
	 afterNode.setPrevious(theNode);
	 size++;
  }
  
  //pre: 0<=theIndex <=size
  //post:removes the element at position theIndex and returns it
  //     (elements previously at theIndex+1..size-1 are now theIndex...size-2)
  public Object remove(int theIndex) throws IndexOutOfBoundsException
  {
    CheckPreCondition(theIndex, size-1);
	 DLNode removedNode = getNodeAt(theIndex);
	 DLNode beforeNode = removedNode.getPrevious();
	 DLNode afterNode = removedNode.getNext();
	 beforeNode.setNext(afterNode);
	 afterNode.setPrevious(beforeNode);
	 size--;
	 return removedNode.getElement();
  }
  
  //pre: 0<= theIndex <= size()
  //post:replaces theElement at position theIndex with theElement and returns theElement that was replaced
  //     (does not change size of list)
  public Object set(int theIndex, Object theElement) throws IndexOutOfBoundsException
  {
    CheckPreCondition(theIndex, size-1);
	 
	 DLNode theNode = getNodeAt(theIndex);
	 Object oldElement = theNode.getElement();
	 theNode.setElement(theElement);
	 return oldElement;
  }
  
  //pre: 0<=theIndex<=size()
  //post: returns the element at position:theIndex (List is unchanged)
  public Object get(int theIndex) throws IndexOutOfBoundsException
  {
    CheckPreCondition(theIndex,size-1);
	 
	 DLNode hopNode = getNodeAt(theIndex);
	 return hopNode.getElement();
  }
  
  //post: returns String representation of the current LinkedList
  public String toString()
  {
   String theString = "";
	String theSeparator="";
	
	Iterator theIterator = this.iterator();
	while(theIterator.hasNext())
	{
	  theString = theString+theSeparator+theIterator.next();
	  theSeparator =",";
	}
	return theString;
  }
	
	//an instance of a LinkedIterator can iterate thru a LinkedList one time
	private class LinkedIterator implements Iterator
	{
	  private DLNode currentNode = headNode;
	  private boolean okToRemove = false;
	  
	  //post: returns true if there are still elements in this iteration
	  public boolean hasNext()
	  {
	    return currentNode.getNext()!=headNode;
	  }
	  
	  //pre: hasNext() must be true
	  //post: return the next element
	  public Object next()
	  {
	    if(!hasNext())
		 {
		   throw new NoSuchElementException("No more elements in this iteration!");
		 }	
		 currentNode = currentNode.getNext();
		 okToRemove = true;
		 return currentNode.getElement();
	  }
	  
	  //pre: next() must be called at least once before each call to remove
	  //post: remove the last element that was viewed
	  public void remove()
	  {
	    if(!okToRemove)
		 {
		   throw new NoSuchElementException(" Must call next() again before calling remove()");
		 }
		 
		 currentNode.getPrevious().setNext(currentNode.getNext());
		 currentNode.getNext().setPrevious(currentNode.getPrevious());
		 size--;
		 currentNode = currentNode.getPrevious();
		 okToRemove = false;
		 
	  }
	}
	  
   //post: returns an iterator for this list
   public Iterator iterator()
	{
	  return new LinkedIterator();
	}
}


	 