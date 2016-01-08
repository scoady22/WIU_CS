//MenuTestQueue.java
//Sean Coady

import queue.*;
import java.util.Scanner;
import java.util.Random;

//interactively driven test application for the ADT Queue, and it's methods
//menu choices 1-6 decide which executable path the program trys

public class MenuTestQueue
{
  public static void main(String[] args)
  {
    Scanner scanner = new Scanner(System.in);
	 Queue theQueue = new ArrayQueue(5);
	 int choice = 0;
	 while(choice != 6)
	 {
	   printMenu();
		System.out.println("Choose next Queue operation, 1-6.");
		choice = scanner.nextInt();
		menuChoice(choice,theQueue);
		if(theQueue.size() == 0)
		  System.out.println("Queue is currently empty.");
		else
		  System.out.println("Current Queue: "+theQueue.toString() );
	 }
  }
  
  //prints out the menu for Queue operations ordered 1-6
  public static void printMenu()
  {
    System.out.println("Test Queue Operation..:"
	                   +"\n1) Enqueue a randomly chosen Integer onto Queue"
							 +"\n2) Dequeue the Queue"
							 +"\n3) Peek at the front element of the Queue"
							 +"\n4) Tell the current size of the Queue"
							 +"\n5) Tell whether the Queue is empty or not"
							 +"\n6) Quit.");
  }
  
  //pre: choice is between 1-6
  //post: perform user chosen operation on theQueue and print results
  public static void menuChoice(int choice, Queue theQueue)
  {
    if(choice == 1)
	 {
	   Random x = new Random();
		Integer i = new Integer(x.nextInt(100));
		theQueue.enqueue(i);
		System.out.println("Enqueued: "+i);
	 }
	 else if(choice == 2)
	 {
	   try
		{
		  System.out.println("Dequeued: "+theQueue.dequeue() );
		}
		catch (QueueEmptyException ex)
		{
		  System.out.println("Illegal operation, for reason: "+ex.toString());
		}
	 }
	 else if(choice == 3)
	 {
	   try
		{
		  System.out.println("The current front element (peek) is: "+theQueue.peek() );
		}
		catch(QueueEmptyException ex)
		{
		  System.out.println("Illegal operation, for reason: "+ex.toString() );
		}
	 }
	 else if(choice ==4)
	 {
	   System.out.println("The current size of the Queue is: "+theQueue.size());
	 }
	 else if(choice == 5)
	 {
	   if(theQueue.isEmpty())
		{
		  System.out.println("The Queue is currently empty.");
		}
		else
		{
		  System.out.println("The Queue is not currently empty.");
		}
	 }
	 else if(choice == 6)
	 {
	   System.out.println("Goodbye.");
	 }
  }
}
