//TestStack.java
//Sean Coady

import java.io.*;
import java.util.Scanner;
import stack.*;


//Tests stack implementation by calling each stack method

public class TestStack
{
  //interactively reads in a list of integers, one per line
  //stores the integers in a Stack, prints size and contents of stack
  //then empties out the Stack to print in reverse order
  
  public static void main(String[] args) throws IOException
  {
    Stack theStack = new ArrayStack(5);
	 readIntegersIntoStack(theStack);
	 
	 System.out.println("There are "+theStack.size()+" elements in the stack.");
	 System.out.println("The stack: "+theStack.toString());
	 System.out.println("Your data reversed: ");
	 
	 removeIntegersFromStack(theStack);
  }
  
  //post: interactively reads in any amount of integers
  public static void readIntegersIntoStack(Stack theStack) throws IOException
  {
    Scanner scanner = new Scanner(System.in);
	 
	 System.out.println("Type in a list of integers, one per line. Press Enter to stop.");
	 
	 String line = null;
	 while(true)
	 {
	   line = scanner.nextLine();
		if(line.equals(""))
		 break;
	   theStack.push(new Integer(line));
	 }
  }
  
  //post: removes each element from stack and prints it
  public static void removeIntegersFromStack(Stack theStack)
  {
    while(!theStack.isEmpty())
	 {
	   System.out.println(theStack.peek().toString());
		theStack.pop();
	 }
	 System.out.println("Stack is now empty");
  }
}