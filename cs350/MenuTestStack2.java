//MenuTestStack.java
//Sean Coady

import java.util.Scanner;
import java.util.Random;
import stack.*;

public class MenuTestStack2
{
  public static void main(String[]args)
  {
    Scanner scanner = new Scanner(System.in);
	 Stack theStack = new LinkedStack();
	 int choice = 0;
	 while(choice!=6)
	 {
	   printMenu();
		System.out.println("Choose next Stack operation, 1 - 6");
		choice = scanner.nextInt();
		menuChoice(choice,theStack);
		System.out.println("Current stack: "+theStack.toString());
	 }
  }
  
  public static void printMenu()
  {
    System.out.println("Test Stack operation:"
	                      +"\n1) Push a randomly chosen integer onto the stack"
		                   +"\n2) Pop the stack"
								 +"\n3) Peek at top element of the stack"
								 +"\n4) Tell size of the stack"
								 +"\n5) Tell whether the stack is empty or not"
								 +"\n6) Quit.");
  }
  
  //post: processes user menu choice, performs stack operation
  //prints results
  public static void menuChoice(int choice, Stack theStack)
  {
    if(choice ==1)
	 {
	   Random x = new Random();
		Integer i = new Integer(x.nextInt(100));
		theStack.push(i);
		System.out.println("Pushed: "+i);
	 }
	 else if(choice == 2)
	 {
	   try
		{
		  System.out.println("Popped: "+theStack.pop());
		}
		catch(StackEmptyException ex)
		{
		  System.out.println("Can't pop.");
		}
    }
	 else if(choice == 3)
	 {
	   try
		{
		  System.out.println("Top Element : "+theStack.peek());
		}
		catch(StackEmptyException ex)
		{
		System.out.println("Can't peek.");
		}
	 }
	 else if(choice == 4)
	 {
	   System.out.println("The current size of the Stack is: "+theStack.size());
	 }
	 else if(choice == 5)
	 {
	   if(theStack.isEmpty())
		{
		  System.out.println("The stack is currently empty.");
		}
		else
		{
		  System.out.println("The stack is currently not empty.");
		}
	 }
  }
}
  