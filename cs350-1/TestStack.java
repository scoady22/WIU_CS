// TestStack.java
// Ahmed Hakami
// 10/9/2009

import java.io.*;
import stack.*;
import java.util.Scanner;

// Tests Stack implementation by calling each Stack method
public class TestStack
{
// interactively reads in a list of integers, one per line
// stores the integers in a Stack, prints size and contents of Stack,
// then empties Stack to print out the list in reverse order
	public static void main( String [] args ) throws IOException
	{
		Stack theStack = new ArrayStack(5);
		readIntegersIntoStack( theStack );
		System.out.println("There are " + theStack.size() + " elements in the stack.");
		System.out.println("The stack: " + theStack.toString() );
		System.out.println("Your data reversed: ");

		removeIntegersFromStack( theStack );
	}

// post: interactively reads in any number of integers 
// 		and stores them in theStack
public static void readIntegersIntoStack(Stack  theStack ) throws IOException
{
	Scanner keyScan = new Scanner( System.in );

	System.out.println("Type in a list of integers, one per line,."
								+ "\nPress enter to stop");

	String line = null;
	while( true )
   {
	  line = keyScan.nextLine();
	  if( line.equals("") )
	    break;
	  theStack.push(new Integer(line));
	}
 }

// post: removes each element from theStack and prints it
public static void removeIntegersFromStack( Stack theStack )
{
	while( ! theStack.isEmpty() )
	{
	System.out.println( theStack.peek().toString()); // test peek
	theStack.pop();											 // test pop
	}
	System.out.println("Stack is now empty");
}
}
