// list.List
// Sean Coady

package list;
import java.util.Iterator;

// a List is a linear sequence of elements ordered by their indexed position in the List
// ( indices 0 to size-1 ), List elements may be added or deleted or viewed via their index
public interface List
{
	// post: return the number of elements in this list
	public int size( );
	
	// post: returns true if this list is empty, false otherwise 
	public boolean isEmpty();
	
	// post: returns the index of the first occurrence of theElement in this list
	//       or returns =1 if the element is not in this list
	public int indexOf( Object theElement );
	
	// post: returns true if theElement is in this list (if some element in list equals(theObject)
	//       false otherwise
	public boolean contains( Object theElement );
	
	// pre: 0 <= theIndex < size()
	// post: returns the element at position: theIndex (List is unchaged)
	public Object get( int theIndex ) throws IndexOutOfBoundsException;
	
	// pre: 0 <= theIndex <= size()
	// post: adds theElement at position theIndex,
	// (elements formerly at positions theIndex .. size-1 are now positions theIndex +1 .. size)
	public void add( int theIndex, Object theElement ) throws IndexOutOfBoundsException;
	
	// pre: 0 <= theIndex < size()
	// post: removes the element at position theIndex and returns it,
	// (elements formerly at position theIndex .. size-1 are now in positions theIndex-1 .. size-2)
	public Object remove( int theIndex ) throws IndexOutOfBoundsException;
	
	// pre: 0 <= theIndex < size()
	// post: replaces the element at position theIndex with theElement and returns the element that was replaced,
	// (does not change the size of the list)
	public Object set( int theIndex, Object theElement ) throws IndexOutOfBoundsException;

	// post: returns an instance of Iterator which can be used to iterate thru the list from position 0 .. size()-1
	public Iterator iterator();
}