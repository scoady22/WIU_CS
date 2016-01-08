//MenuTestStack.java
//Sean Coady

import java.util.Scanner;
import java.util.Random;
import stack.*;

//interactively tests Stack methods via menu choice
public class MenuTestStack
{
  public static void main(String [] args)
  {
    Stack theStack = new ArrayStack(5);
	 int choice = 0;
	 while(choice != 6)
	 {
	   printMenu();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose a stack operation, numbered 1-6.");
		choice = scanner.nextInt();
		menuChoice(choice,theStack);
		System.out.println("Current stack: "+theStack.toString() );
		
	 }
  }
  
  //prints menu choices for stack operations
  
  public static void printMenu()
  {
    System.out.println("Test Stack Operations:"
	                   +"\n1) push a randomly chosen integer on the Stack."
							 +"\n2) pop the Stack."
							 +"\n3) peek at the top element of the Stack."
							 +"\n4) tell size of the Stack."
						    +"\n5) tell whether the Stack is empty or not."
							 +"\n6) Quit.");
  }
  
  //post: do a chosen operation on theStack and print results
  public static void menuChoice(int choice, Stack theStack) throws StackEmptyException
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
		    System.out.println("illegal operation prevented, for reason: "+ ex.toString() );
		  }
	 }
	 else if(choice == 3)
	 {
	   try
		{
		  System.out.println("The peek: "+ theStack.peek() );
		}  
		  catch(StackEmptyException ex)  
		  {
		    System.out.println("Illegal operation prevented, for reason: "+ex.toString() );
		  }
	 }
	 else if(choice == 4)
	 {
	   System.out.println("Current size of the Stack is: "+theStack.size() );
	 }
	 else if(choice == 5)
	 {
	   if(theStack.isEmpty() )
		{
		  System.out.println("The stack is empty.");
		}
	   else
		{
		  System.out.println("The stack is not empty.");
		}
	 }
	 else if(choice == 6)
	 {
	   System.out.println("Goodbye.");
	 }
  }
}
	   
	 