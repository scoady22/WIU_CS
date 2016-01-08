// menuTestqueue2.java
// Ahmed Hakami
// 10/19/2009

import java.util.Scanner;
import java.util.Random;
import queue.*;
public class MenuTestQueue2
{
	public static void main(String [] args)
	{
	Scanner sc=new Scanner(System.in);
	Queue theQueue= new LinkedQueue();
	int choice=0;
	while(choice!=6)
	{
		printMenu();
		System.out.println("Choose next queue operation:(1-6)>");
	   choice=sc.nextInt();  
		processMenuChoice(choice,theQueue);
		System.out.println("current queue: " + theQueue.toString());
	}
	}
	
	public static void printMenu()
	{
		System.out.println("Test Queue operation:"
								+"\n1) enqueue a randomly chosen integer onto Queue"
								+"\n2) dedueue the Queue"
								+"\n3) peek at front element of Queue"
								+"\n4) tell size of Queue"
								+"\n5) tell whether Queue is empty or not"
								+"\n6) quit this application");
	}
	
	// post: do chosen operation on theQueue and print results
	public static void processMenuChoice(int choice,Queue theQueue)
	{
	if(choice==1)
	{
	 Random x= new Random();
	 Integer i=new Integer(x.nextInt(100));
	 theQueue.enqueue(i);
	 System.out.println(" add: " + i);
	 }
	 else if(choice==2)
	 {try
	 	{
		System.out.println("popped" + theQueue.dequeue());
		}
		catch( QueueEmptyException ex)
		{
			System.out.println(" illegal operation prevented, method threw exception" + ex.toString());
		}
	 }
	 else if(choice==3)
	 {try
	 	{
		System.out.println(" the peek" + theQueue.peek());
		}
		catch( QueueEmptyException ex)
		{
			System.out.println(" illegal operation prevented, method threw: " + ex.toString());
		}	
	 }
	 else if(choice==4)
	 {
	 	System.out.println( " the size of queue" + theQueue.size());
	 }
	 else if(choice==5)
	 {
	 System.out.println(" is thequeue empty "+ theQueue.isEmpty());
	 }
	 else if(choice==6)
	 {
	 System.out.println("Good bye");
	 }
	 else
	   System.out.println(" invalid choice, choose operation 1-6");
	}
}
	  