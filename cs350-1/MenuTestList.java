// MenuTestList.java
// Ahmed Hakami
// 11/06/2009

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import list.*;
// A menu driven program menu that allows user to test List operations.
public class MenuTestList
{  
  // prompts the user to choose a List operation, then to enter any  
	// necessary element and index for the operation,
  // prints out the results of each operation performed.
  public static void main(String [] args) throws IOException
  {
     list.List theList = new list.LinkedList();
		
		 int choice = 0;	
	   while( choice != 9 )
	   {	
		 		choice = printMenuAndGetChoice();      
			  processChoice(choice, theList);
		  	System.out.println("current List:  " + theList.toString());
	   }
	}

	//post:  prints a menu containing all List operations
	//       reads user choice and returns it
   public static int printMenuAndGetChoice() throws IOException 
	{
	 	Scanner keyScan = new Scanner(System.in);	
		System.out.println("______________________________________________________________________");  
	  System.out.println("Test List operations:  ");
		System.out.println("1) add an element at the given index");
		System.out.println("2) remove an element at the given index");
		System.out.println("3) get the element at the given index");
		System.out.println("4) replace the element at the given index with new element given" 
		                       +" and return the element that was replaced");
		System.out.println("5) find the index of the first occurrence of given element in list");
		System.out.println("6) tell whether list contains the given element");
		System.out.println("7) tell whether list is empty or not");
		System.out.println("8) tell the size of list");
		System.out.println("9) quit this application");
		System.out.println("_____________________________________________________________________");
		int choice = -1;
		while( choice<0 )
		{
		  try
			{
			
	 	    System.out.println("Choose next List operation (1-9)>");
		    choice = keyScan.nextInt( );
			}
			catch(java.util.InputMismatchException ex)
			{
			  keyScan.next(); // move past bad data
			  System.out.println("Choice must be an integer, please try again.");
			}
		}		
		return choice; 
	}
		
	//post:  prompts for and reads in an index in range 0..maxIndex
	//       returns that int index
	public static int readIndex(int maxIndex) throws IOException
	{
	  Scanner keyScan = new Scanner(System.in);

		int theIndex = -1;
		while( theIndex<0 )
		{
		  try
			{
				System.out.println("Type in an index in range 0.."+maxIndex+": ");
		    theIndex = keyScan.nextInt( );
			}
			catch(java.util.InputMismatchException ex)
			{
			  keyScan.next(); // move past error
			  System.out.println("Index must be an integer, please try again.");
			}
		}		
		return theIndex;
	}
	
	//post:  prompts for and reads in an element(as a String) for a List operation 
	//       returns the Element
	public static Object readElement() throws IOException                                                                                                                               
	{
		Scanner keyScan = new Scanner(System.in);
		System.out.println("Type in an element ");
		Object theElement = keyScan.next();
		return theElement;
	}

	
	//post:  do chosen operations on theList and print results
	public static void processChoice(int choice, List theList) throws IOException
	{
	  int theIndex;
		Object theElement;
	  if(choice==1)
		{
		  try
			{
		     theIndex = readIndex(theList.size());
			   theElement = readElement();
		     theList.add(theIndex,theElement);
			   System.out.println("added:  " + theElement+" at "+theIndex);
			}
			catch(IndexOutOfBoundsException ex)
			{
			   System.out.println("Caught:  " + ex);
			}
		}
	  else if(choice==2)
		{
		   try
			{  
			  theIndex=readIndex(theList.size()-1);
			  System.out.println("removed:  "+ theList.remove(theIndex)+" at "+ theIndex);
			}
			catch(IndexOutOfBoundsException ex)
			{
			  System.out.println("Caught:  " + ex);
   		}
		}
		else if(choice==3)
		{
		   try
		   {			 
			   theIndex=readIndex(theList.size()-1);
			   System.out.println("The element at Index " + theIndex+ " is: "
			                     + theList.get(theIndex));
		   }
			 catch(IndexOutOfBoundsException ex)
			 {
			   System.out.println("Caught:  " + ex);
		   }
		}
		else if(choice==4)
		{
		   try
			{
			  theIndex = readIndex(theList.size()-1);
		  	theElement = readElement();
			  Object oldElement = theList.set(theIndex, theElement);
			  System.out.println("Replaced " + oldElement + " at " + theIndex 
			                      + " with " + theList.get(theIndex));
			}   
			catch(IndexOutOfBoundsException ex)
			{
			  System.out.println("Caught:  " + ex);
			}
		}
		else if(choice==5)
		{
		   theElement = readElement();
			 theIndex = theList.indexOf(theElement);
			 if(theIndex < 0) 
			    System.out.println(theElement+" is NOT in the list.");
       else
			    System.out.println("The first occurence of " +
			                        theElement + " is at index " + theIndex);
		}
		else if(choice==6)
		{
		   theElement = readElement();
			 System.out.println("Does the list contain " +
			                    theElement + " ?  " + theList.contains(theElement));
		}
		else if(choice==7)
		{
		    System.out.println("Is current list empty?  " + theList.isEmpty());
   	}
		else if(choice==8)
		{
		    System.out.println("The current size of the list is:  " + theList.size());
		}
		else if(choice==9)
		    System.out.println("Good-bye!");
		else
		   System.out.println("Invalid choice, choose operation 1-9");
	}
}
