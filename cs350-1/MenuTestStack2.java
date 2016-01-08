// menuTeststack2
// Ahmed Hakami
// 10/09/2009

import java.util.Scanner;
import java.util.Random;
import stack.*;
public class MenuTestStack2
{
	//
	public static void main(String [] args)
	{
	Scanner sc=new Scanner(System.in);
	Stack theStack= new LinkedStack();
	int choice=0;
	while(choice!=6)
	{
		printMenu();
		System.out.println("Choose next stack operation:(1-6)>");
	   choice=sc.nextInt(); 
		processMenuChoice(choice,theStack);
		System.out.println("current stack: " + theStack.toString());
	}
	}
	
	public static void printMenu()
	{
		System.out.println("Test Stack operation:"
	                      +"\n1) push a randomly chosen integer onto the stack"
		                   +"\n2) pop the stack"
								 +"\n3) peek at top element of the stack"
								 +"\n4) tell size of the stack"
								 +"\n5) tell whether the stack is empty or not"
								 +"\n6) quit");
	}
	
	// post: do chosen operation on theStack and print results
	public static void processMenuChoice(int choice,Stack theStack)
	{
	if(choice==1)
	{
	 Random x= new Random();
	 Integer i=new Integer(x.nextInt(100));
	 theStack.push(i);
	 System.out.println(" pushed: " + i);
	 }
	 else if(choice==2)
	 {try
	 	{
		System.out.println("popped" + theStack.pop());
		}
		catch( StackEmptyException ex)
		{
			System.out.println(" illegal operation prevented, method threw: " + ex.toString());
		}
	 }
	 else if(choice==3)
	 {try
	 	{
		System.out.println(" the peek" + theStack.peek());
		}
		catch( StackEmptyException ex)
		{
			System.out.println(" illegal operation prevented, method threw: " + ex.toString());
		}	
	 }
	 else if(choice==4)
	 {
	 	System.out.println( " the size of stack" + theStack.size());
	 }
	 else if(choice==5)
	 {
	 System.out.println(" is the stack empty "+ theStack.isEmpty());
	 }
	 else if(choice==6)
	 {
	 System.out.println("Good bye");
	 }
	 else
	   System.out.println(" invalid choice, choose operation 1-6");
	}
}
	  