// LinkedStack.java
// Ahmed Hakami
// 10/23/2009

package stack;
import node.*;

// a singly linked implementation of Stack
public class LinkedStack implements Stack
{
	//instance varibles
	private Node topNode;
	private int size;

	// post: initialize this ti empty Stack	
	public LinkedStack()
	{
		topNode= null;
		size=0;
	}

	
	// post: initialize this ti empty stack
	public int size()
	{
		return size;
	}
 
	// post: return true if stack is empty. false otherwise
	public boolean isEmpty()
	{
		if(size==0)
			return true;
		else
			return false;
	}
	

	// post: theElement is add at top of this stack
	public void push(Object theElement)
	{

		Node theNode= new Node(theElement,null);
		theNode.setNext(topNode);
	
			topNode= theNode;
			size++;

	}	
	//per: stack not empty
	//post: remove top element and returns it 
	public Object pop( )throws StackEmptyException
	{
		if(this.isEmpty()) 
			throw new StackEmptyException("can't pop!"); 
			Object removeElement=topNode.getElement();
			topNode= topNode.getNext();
			size--;
			return removeElement;
	}

	//pre: stack not empty
	// posr: return top element, stack is unchanged
	public Object peek() throws StackEmptyException
	{
		if(this.isEmpty()) 
			throw new StackEmptyException("can't peek"); 
			Object top= topNode.getElement();
			return top;
	}
	// post: returns string containing stack elements
	//			in top to bottom order, separated by commas
	public String toString()
	{
		String theString = "";
		String theSoparater="";
		Node hopNode=topNode;
		int count=0;
		while(count<size)
		{
		theString=theString+theSoparater+hopNode.getElement();
		hopNode=hopNode.getNext();
		theSoparater="," ;
		count++;
		}
		return theString;
		}
	}
