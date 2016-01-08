// queueEmptyException
// Ahmed Hakami
//10/19/2009

package queue;
public class QueueEmptyException extends RuntimeException
{
// per if the stack is empity
// post: initialize this exception to report theMessage
public QueueEmptyException(String theMessage)
{
		super(theMessage);
	}
}