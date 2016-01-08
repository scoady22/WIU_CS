//queue.Queue
//Sean Coady

package queue;

//a Queue stores elements in first in first out, linear order
//only the element at the front may be removed or viewed
//new elements may only be added to the rear

public interface Queue
{
  //post: returns this Queue's size
  public int size();
  
  //post: return true if this Queue is empty, false if this Queue is not.
  public boolean isEmpty();
  
  //post: theElement is added to the rear of this Queue
  public void enqueue(Object theElement);
  
  //pre: queue not empty
  //post: the front element of this Queue is removed and returned
  public Object dequeue() throws QueueEmptyException;
  
  //pre: queue not empty
  //post: returns the front element of this Queue (queue is unchanged)
  public Object peek() throws QueueEmptyException;
}