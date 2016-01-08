// LinkedQueue.java
// Ahmed Hakami
// 10/23/2009

package queue;
import node.*;

// a singly linked implementation of Queue
public class LinkedQueue implements Queue
{
	//instance varibles
	private Node frontNode;
	private int size;
	private Node rearNode;
	
	// post: initialize this ti empty Queue	
	public LinkedQueue()
	{
		frontNode=null;
		size=0;
		rearNode=null;
	}
	// post: returns number of elements int this queue
	public int size()
	{
		return size;
	}
 
	// post: return true if queue is empty. false otherwise
	public boolean isEmpty()
	{
		if(size==0)
			return true;
		else
			return false;
	}

	// pre: queue not empty
	// post: return front element, queue is unchanged
	public Object peek() throws QueueEmptyException
	{
		if(this.isEmpty()) 
			throw new QueueEmptyException("can't peek"); 
		return 
			frontNode.getElement();
	}

	// post; theElement is added at rear of this queue
	public void enqueue(Object theElement)
	{

		Node theNode= new Node(theElement,null);
		if(this.isEmpty())
			frontNode=theNode;
		else
			rearNode.setNext(theNode);
			rearNode= theNode;
		

	}	
	//per: queue not empty
	//post: remove front element and returns it 
	public Object dequeue( )throws QueueEmptyException
	{
		if(this.isEmpty()) 
			throw new QueueEmptyException("can't dequeue!"); 
			Object removedElement=frontNode.getElement();
			frontNode= frontNode.getNext();
			size--;
			if (isEmpty())
				rearNode=null;
			return removedElement;
	}



	// post: returns string of Queue elements,
	//			in front to rear order, separated by commas
	public String toString()
	{
		String theString = "";
		String theSeparator = "";
		Node hopNode=frontNode;
		int count=0;
		while(count<size)
		{
			theString=theString+theSeparator+hopNode.getElement();
			theSeparator="," ;
			hopNode=hopNode.getNext();
			count++;
		
		}
		return theString;
		}
	}
