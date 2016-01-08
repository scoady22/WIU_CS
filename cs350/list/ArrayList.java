//list.ArrayList
//Sean Coady

package list;
import java.util.*;

//a simply array implementation of list
public class ArrayList implements List
{
  private Object[] element;
  private int size;
  
  public static final int DEFAULT_CAPACITY= 10;
  
  //initialize this List to the empty List with initialCapacity
  public ArrayList(int initialCapacity)
  {
    element = new Object[initialCapacity];
	 size=0;
  }
  
  //intialize this List to the empty List with DEFAULT_CAPACITY
  public ArrayList()
  {
    this(DEFAULT_CAPACITY);
  }
  
  //pre: 0<= theIndex <= indexValue
  //post: throws IndexOutOfBoundsException if theIndex is out of range
  public void checkPreCondition(int theIndex, int maxIndex) 
  {
    if((0> theIndex) || (theIndex> maxIndex))
	 {
	   throw new IndexOutOfBoundsException("index: "+theIndex+" is beyond: "+maxIndex);
	 } 
  }
  
  //post: returns number of elements currently in this list
  public int size()
  {
    return size;
  }
  
  //post: returns true if this list is Empty
  //      false if not
  public boolean isEmpty()
  {
    if(size==0)
	 {
	   return true;
	 }
	 else
	 {
	   return false;
	 }
  }
  
  //post: returns the index of the first occurence of theElement in this list
  //      or returns -1 if theElement is not in the list
  public int indexOf(Object theElement)
  {
    int i=0;
	 while(i<size)
	 {
	   if(element[i].equals(theElement))
		{
		  return i;
		}
	  i++;
	 }
	 return -1;
  }
  
  //post: returns true if theElement is in this list
  //      false if it is not in this list
  public boolean contains(Object theElement)
  {
    int i =0;
	 while(i<size)
	 {
	   if(element[i].equals(theElement))
		{
		  return true;
		}
	  i++;
	 }
	 return false;
  }
  
  //pre: 0<=theIndex<= size()
  //post: returns the element at position: theIndex(list unchanged)
  public Object get(int theIndex) throws IndexOutOfBoundsException
  {
    checkPreCondition(theIndex, size-1);
	 return element[theIndex];
  }
  
  //pre:0<=theIndex<=size()
  //post: adds theElement at position theIndex and returns it
  //      (elements formerly at theIndex..size-1 are now in positions theIndex+1..size)
  public void add(int theIndex, Object theElement) throws IndexOutOfBoundsException
  {
    checkPreCondition(theIndex,size);
	 //if(size==element.length)
	 //doubleArrayCapacity
	 
	 int i = size-1;
	 while(i>=theIndex)
	 {
	   element[i+1] = element[i];
		i--;
	 }
	 
	 element[theIndex] = theElement;
    size++;
  }
  
  //pre: 0<=theIndex<=size()
  //post: removes the element at position theIndex and returns it
  //elements formerly at position theIndex..size are now in position theIndex-1..size-2
  public Object remove(int theIndex) throws IndexOutOfBoundsException
  {
    checkPreCondition(theIndex,size);
	 
	 Object removed = element[theIndex];
	 int i = theIndex+1;
	 while(i<size)
	 {
	   element[i-1] = element[i];
		i++;
	 }
	 element[size-1] = null;
	 size--;
	 return removed;
  }
  
  //pre:0<=theIndex<=size()
  //post: replaces theElement at position theIndex with theElement and returns theElement that was replaced
  //does not change size of the list
  public Object set(int theIndex, Object theElement) throws IndexOutOfBoundsException
  {
    checkPreCondition(theIndex,size);
	 
	 Object replaced = element[theIndex];
	 element[theIndex] = theElement;
	 return replaced;
  }
  
  //an instance of ArrayIterator can iterate thru an ArrayList one at a time
  private class ArrayIterator implements Iterator
  {
    private int currentIndex = -1;
	 private boolean okToRemove = false;
	 
	 //post: return true if there are still elements in this iteration
	 public boolean hasNext()
	 {
	   return(currentIndex < size()-1);
	 }
	 
	 //pre: hasNext must be true
	 //post: return the next element
	 public Object next()
	 {
	   if(!hasNext())
		{
		  throw new NoSuchElementException("No more elements in this iteration!");
		}
	   return element[++currentIndex];
	 }
	 
	 //pre: next() must be called at least once before each call to remove()
	 //post: removes the element that was last viewed (by last call to next())
	 public void remove()
	 {
	   if(!okToRemove)
		{
		  throw new NoSuchElementException("Must call next() again before calling remove()");
		}
		ArrayList.this.remove(currentIndex);
		currentIndex--;
		okToRemove=false;
	 }
  }
  
  //post: returns String of element array
  public String toString()
  {
    Iterator theIterator = this.iterator();
	 String theString = "";
	 String theSep ="";
	 while(theIterator.hasNext())
	 {
	   theString = theString+theSep+theIterator.next();
		theSep=",";
	 }
	 return theString;
  }
  
  //post: returns an instance of an iterator which can be used to iterate thru a list from position 0..size()-1
  public Iterator iterator()
  {
    return new ArrayIterator();
  }
} 
	