n// queue.ArrayQueue
//Ahmed Hakami
// 10/19/2009

package queue;

// a cricular arry implementation of Queue
public class ArrayQueue implements Queue
{
	private Object[]element;
	private int frontIndex;
	private int rearIndex;
	private int size;
	public static final int DEFAULT_CAPACITY= 5;
	
	// post: initialize this to empty Queue with initialCapacity
	public ArrayQueue(int intalCapacity)
	{
		element=new Object[intalCapacity];
		size=0;
		frontIndex = 0;
		rearIndex = element.length-1;
	}
	// post: initialize to empty Queue with DEFAULT-CAPACITY
	public ArrayQueue()
	{
		this (DEFAULT_CAPACITY);
	}
	// post: returns number of elements currently in this queue
	public int size()
	{
		return size;
	}
	// post: returns number of elements in this queue
	public boolean isEmpty()
	{
		if(size==0)
		  return true;	
		else
		  return false;
	}
	// pre: queue not empty
	// post: returns top element, queue is unchanged
	public Object peek()throws QueueEmptyException
	{
		if(this.isEmpty())
			throw new QueueEmptyException("queue is empty.!");
		return element[frontIndex];
	}
	// post: returns the next index after theIndex in this queue's circular array
	private int nextIndex(int theIndex)
	{
		return(theIndex+1)%element.length;
	
	}
	// post: theElement is added at rear of this queue
	public void enqueue(Object theElement)
	{
		if(size==element.length)
		 doubleArrayCapacity();	
		rearIndex= nextIndex(rearIndex);
		element[rearIndex]=theElement;
		size++;
	}
	// post: doubles capacity of element array, maintains current elements
	private void doubleArrayCapacity()
	{
		Object[]theArray= new Object[2*element.length];
		int i=frontIndex;
		int count=0;
		while(count<size)
		{
			theArray[count]=element[i];
			i=nextIndex(i);
			count++;
		}
		element=theArray;
		frontIndex=0;
		rearIndex=size-1;
	}
	// pre: queue not empty
	// post: removes front element and returns it
	public Object dequeue()throws QueueEmptyException
	{
	 	if(this.isEmpty())
			throw new QueueEmptyException("can't dequeue");
		Object removedElement= element[frontIndex];
		size--;
		frontIndex=nextIndex(frontIndex);
			return removedElement;

	}
	// post: returns string Queue elements,
	// 		in front to rear order, seperated by commas
	public String toString()
	{
		String theString=" ";
		String theSoprater=" ";
		int i=frontIndex;
		int count=0;
		while(count<size)
		{
			theString =theString+theSoprater+element[i];
			theSoprater=" , ";
			i=nextIndex(i);
		  count++;
		}
		return theString;
	  }
				
	}
	
