//MenuTestQueue2.java
//Sean Coady

import java.util.Scanner;
import java.util.Random;
import queue.*;

public class MenuTestQueue2
{
  public static void main(String[]args)
  {
    Scanner scanner = new Scanner(System.in);
	 Queue theQueue = new LinkedQueue();
	 int choice = 0;
	 while(choice!=6)
	 {
	   printMenu();
		System.out.println("Choose next Queue operation: 1-6");
		choice = scanner.nextInt();
		menuChoice(choice,theQueue);
		System.out.println("Current queue: "+theQueue.toString());
	 }
  }
	 
	 //prints out menu choices for user to choose from
	 public static void printMenu()
	 {
	   System.out.println("Test Queue operations:"
								+"\n1) Enqueue a randomly chosen integer onto Queue"
								+"\n2) Dequeue the Queue"
								+"\n3) Peek at front element of Queue"
								+"\n4) Tell size of Queue"
								+"\n5) Tell whether Queue is empty or not"
								+"\n6) Quit.");
	 }
	   
	 //post: do chosen operation on theQueue and print results
	 public static void menuChoice(int choice, Queue theQueue) throws QueueEmptyException
	 {
	   if(choice==1)
		{
		  Random x = new Random();
		  Integer i = new Integer(x.nextInt(100));
		  theQueue.enqueue(i);
		  System.out.println("Added: "+i);
		}
		else if(choice == 2)
		{
		  try
		  {
		    System.out.println("Dequeued: "+theQueue.dequeue());
		  }
		  catch(QueueEmptyException ex)
		  {
		    System.out.println("Can't dequeue");
		  }
		}  
		else if(choice == 3 )
		{
		  try
		  {
		    System.out.println("Front element: "+theQueue.peek());
		  }
		  catch(QueueEmptyException ex)
		  {
		    System.out.println("Can't peek.");
		  }
		}
		else if(choice == 4)
		{
		  System.out.println("Size of the Queue is currently: "+theQueue.size());
		}
		else if(choice == 5)
		{
		  if(theQueue.isEmpty())
		  {
		    System.out.println("The queue is empty.");
		  }
		  else
		  {
		    System.out.println("The queue is not empty.");
		  }
		}
	   else if(choice == 6)
		{
		  System.out.println("Good bye.");
		}
	   else
		{
		  System.out.println("Invalid choice, choose an operation between 1 - 6.");
		}
   }
}
