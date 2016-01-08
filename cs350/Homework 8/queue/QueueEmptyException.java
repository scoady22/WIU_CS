//queue.QueueEmptyException
//Sean Coady

package queue;
public class QueueEmptyException extends RuntimeException
{
  //pre: this Queue is empty
  //post: initialize this exception to report theMessage
  public QueueEmptyException(String theMessage)
  {
    super(theMessage);
  }
}