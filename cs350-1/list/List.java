// list.List.java
// Ahmed Hakami
// 11/06/2009

package list;

import java.util.Iterator;

// a list is a linear sequence of elements ordered by their indexed position in the list
// (indices 0 to size-1),a List element may be added or deleted or viewed via it's index
public interface List
{
	//post: return the number of elements in this list
	public int size();
	
	//post: returns true if this list is empty, false otherwise
	public boolean isEmpty();
	
	//post: returns the index of the first occurrence of theElement in this list
	//    or returns -1 if theElement is not in this list
	public int indexOf(Object theElement);
	
	//post: returns true if theElement in this list
	//    or returns false if theElement is not in this list
	public boolean contains(Object theElement);
	
	//pre:0<=theIndex< size()
	//post: returns the element at position: theIndex (List is unchanged)
	public Object get( int theIndex)throws IndexOutOfBoundsException;
	
	//pre:0<=theIndex<= size()
  //post: adds theElement at position theIndex and returns it,
	//(elements formerly at positions theIndex..size-1 are now at positions theIndex+1..size)
	public void add(int theIndex,Object theElement)throws IndexOutOfBoundsException;
	
	
	//pre:0<=theIndex< size()
  //post: removes theElement at position theIndex and returns it,
	//(elements formerly at positions theIndex+1..size-1 are now in positions theIndex..size-2)
	public Object remove(int theIndex)throws IndexOutOfBoundsException;
	
	//pre:0<=theIndex< size()
  //post: replaces theElement at position theIndex with theElement and returns theElement that was replaced,
	//     (does not change the size of the list)
	public Object set(int theIndex, Object theElement)throws IndexOutOfBoundsException;
	
	//post: returns an instance of Interator which can be used to iterate true the list from position0..size()-1
	//public Iterator iterator();
  	public Iterator iterator(); 
}
	
 // NOTE: THE LAST METHOD IS DELIBERATELY COMMENTED OUT	TILL LATER	
