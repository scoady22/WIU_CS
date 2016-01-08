// list.ArrayList.java
// Ahmad Alshehri
// 4-18-2009

package list;

import java.util.*;

// a simple array implementation of List
public class ArrayList implements List
{
   private Object[ ] element;
	private int size;
   
	public static final int DEFAULT_CAPACITY = 10;

    // initialize this List to the empty List with initialCapacity
	public ArrayList(int initialCapacity )
	{
	   element = new Object[initialCapacity ];
		size =0;
		
	}

   // initialize this List to the empty List with DEFAULT_CAPACITY
	public ArrayList( )
	{
	  this(DEFAULT_CAPACITY);
	}

	// pre: 0 <= theIndex <= IndexValue
	// post: throws IndexOutOfBoundsException if theIndex is out of its range
	private void checkPrecondition(int theIndex, int maxIndexValue)
	{
		if((0 > theIndex) || (theIndex > maxIndexValue))
		{
			throw new IndexOutOfBoundsException("index: "+ theIndex+ " is beyond max: " + maxIndexValue);
		}
	}


	//post: return the number of elements in this list
	public int size()
	{
		return size;
	}
	
	//post: returns true if this list is empty, false otherwise
	public boolean isEmpty()
	{
		if(size==0)
			return true;
		else
			return false; 	
	}

	//post: returns the index of the first occurrence of theElement in this list
	//    or returns -1 if theElement is not in this list
	public int indexOf(Object theElement)
	{
		int i=0;
		while(i<size)
		{
			if( element[i].equals(theElement))
				return i;
			i++;
		}
		return -1;
	}
	//post: returns true if theElement in this list
	//    or returns false if theElement is not in this list
	public boolean contains(Object theElement)
	{
		int i =0;
		while(i<size)
		{
			if(element[i].equals(theElement))
				return true;
		
			i++;
		}
		return false;
	}
	//pre:0<=theIndex< size()
	//post: returns the element at position: theIndex (List is unchanged)
	public Object get( int theIndex)throws IndexOutOfBoundsException
	{
		checkPrecondition( theIndex, size-1);
		return element[theIndex];
	}	
	//pre:0<=theIndex<= size()
   //post: adds theElement at position theIndex and returns it,
	//     (elements formerly at positions theIndex..size-1 are now in positions theIndex+1..size)
	public void add(int theIndex,Object theElement)throws IndexOutOfBoundsException
	{
		checkPrecondition( theIndex, size);
	// if(size==element.length)
	//   doubleArrayCapacity		
		
		int i = size-1;
		while (i>=theIndex)
		{
			element[i+1] = element[i];
			i--;	
		}
			
	 element[theIndex] = theElement;
	 size++;
	}
	//pre:0<=theIndex< size()
   //post: removes theElement at position theIndex and returns it,
	//     (elements formerly at positions theIndex..size-1 are now in positions theIndex-1..size-2)
	public Object remove(int theIndex)throws IndexOutOfBoundsException
	{
			checkPrecondition( theIndex, size);
					
		Object removed=element[theIndex];
		int i=theIndex+1;
		while(i<size)
		{
		
				element[i-1]=element[i];
				i++;
		}
		element[size-1]=null;
		size--;
		return removed;
			
	}
	
	//pre:0<=theIndex< size()
   //post: replaces theElement at position theIndex with theElement and returns theElement that was replaced,
	//     (does not change the size of the list)
	public Object set(int theIndex, Object theElement)throws IndexOutOfBoundsException
	{
		checkPrecondition(theIndex, size);
		
		Object replaced = element[theIndex];
	   element[theIndex] = theElement;
		return replaced;
	}	
	// an instance of ArrayIterator can iterate thru an ArrayList one at a time
	private class ArrayIterator implements Iterator
	{
		private int currentIndex = -1;
		private boolean okToRemove = false;
		
		// post: return true if there are still elements in this iteration
		public boolean hasNext()
		{
			return (currentIndex < size() - 1);
		}
		
		// pre: hasNext must be true
		// post: return the next element
		public Object next()
		{
			if( !hasNext())
			{
				throw new NoSuchElementException("No more elements in this iteration!");
			}
			return element[++currentIndex];
		}
		
		// pre: next() must be called at least once before each call to remove()
		// post: removes the element that was last viewed(by last call to next())
		public void remove()
		{
			if( !okToRemove)
			{
				throw new NoSuchElementException("Must call next() again before you can call remove()");
			}
			ArrayList.this.remove(currentIndex);
			currentIndex--;
			okToRemove = false;
		}
	}
	
	// post: returns string of element array
	public String toString()
	{
		Iterator theIterator = this.iterator();
		String returnString = "";
		String seperator = "";
		
		while(theIterator.hasNext())
		{
			returnString = returnString + seperator + theIterator.next();
			seperator = "," ;
		}
		return returnString;
	}

	
	//post: returns an instance of Interator which can be used to iterate true the list from position0..size()-1
	//public Iterator();
 	public Iterator iterator()
	{
	   return new ArrayIterator();
	}

}
	
