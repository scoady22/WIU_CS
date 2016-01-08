//queue.ArrayQueue
//Sean Coady

package queue;

//a circular implementation of Queue

public class ArrayQueue implements Queue
{
  private Object[] element;
  private int frontIndex;
  private int rearIndex;
  private int size;
  public static final int DEFAULT_CAPACITY = 5;
  
  //post: initializes this to empty Queue with initialCapacity
  public ArrayQueue(int initialCapacity)
  {
    element = new Object[initialCapacity];
	 size = 0;
	 frontIndex = 0;
	 rearIndex = element.length -1;
	 
  }
  
  //post: initialize to empty Queue with DEFAULT_CAPACITY
  public ArrayQueue()
  {
    this(DEFAULT_CAPACITY);
  }
  
  //post: returns number of elements currently in this Queue
  public int size()
  {
    return size;
  }
  
  //post: returns true if this Queue is empty, false is not
  public boolean isEmpty()
  {
    if(size == 0)
	  return true;
	 else
	  return false;
  }
  
  //pre: queue not empty
  //post: returns front element of this Queue (queue remains unchanged)
  public Object peek() throws QueueEmptyException
  {
    if(this.isEmpty() )
	  throw new QueueEmptyException("Queue is empty!");
	 return element[frontIndex];
  }
  
  //post: returns the next index after theIndex in this queue's circular array
  private int nextIndex(int theIndex)
  {
    return (theIndex+1)%element.length;
  }
  
  //post: theElement is added to the rear of this Queue
  public void enqueue(Object theElement)
  {
    if(size == element.length)
	  doubleArrayCapacity();
	 rearIndex = nextIndex(rearIndex);
	 element[rearIndex] = theElement;
	 size++;
  }
  
  //post: doubles capacity of element array, maintains current elements 
  private void doubleArrayCapacity()
  {
    Object[] theArray = new Object[2*element.length];
	 int i = frontIndex;
	 int count = 0;
	 while(count<size)
	 {
	   theArray[count] = element[i];
		i = nextIndex(i);
		count++;
	 }
	 element = theArray;
	 frontIndex = 0;
	 rearIndex = size-1;
  }
  
  //pre: queue not empty
  //post: removes and returns the front element of this Queue
  public Object dequeue() throws QueueEmptyException
  {
    if(this.isEmpty())
	   throw new QueueEmptyException("Queue is empty, can't dequeue");
	 Object removedElement = element[frontIndex];
	 size--;
	 frontIndex = nextIndex(frontIndex);
	 
	 return removedElement;
  }
  
  //pre: queue not empty
  //post: returns this Queue in String representation, front to rear order,
  //separated by commas
  public String toString()
  {
    String theString = " ";
	 String theSeparator =" ";
	 
	 int i = frontIndex;
	 int count = 0;
	 
	 while(count<size)
	 {
	   theString = theString+theSeparator+element[i];
		theSeparator =" , ";
		i=nextIndex(i);
		count++;
    }
	 return theString;
  }
}
	 