// Queue.
// Ahmed Hakami
// 10/19/2009

package queue;
// a Queue stores elements in first-in-first-out linear order
// only the element at the front and may be viewed or removed
// new elements my only be added at the rear end
public interface Queue
{
// post: returns number of elements in this queue
	public int size();
	
// post: return if gueue is empty, false if not
	public boolean isEmpty();
	
// post: theElement is added at rear of this queue
	public void enqueue(Object theElement);
	
//pre:  queue not empty
// post: remove front element and returens it
	public Object dequeue() throws QueueEmptyException;
	
//pre: queue not empty
//post: return front element, queue is unchanged
	public Object peek()throws QueueEmptyException;
}