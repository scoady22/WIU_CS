//MenuTestList2
// Ahmad Alshehri
// 4-20-2009

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import list.*;
// A menu driven program menu that allows user to test List operations.
public class MenuTestList2
{  
   // prompts the user to choose a List operation, then to enter any necessary 
	// integer elements and indexes for the operations,
   // Prints out the results of each operation performed.
   public static void main(String [] args) throws IOException
   {
      list.List theList = new list.LinkedList();
		
		int choice = printMenuAndGetChoice();	
	   while( choice != 9 )
	   {	      
			processChoice(choice, theList);
		  	System.out.println("current List:  " + theList.toString());
			
			choice = printMenuAndGetChoice();
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
		
		System.out.println("Choose next List operation (1-9)>");
		int choice = keyScan.nextInt();
		return choice; 
	}
		
	//post:  prompts for and reads in an index in range 0..maxIndex
	//       returns that int index
	public static int getIndex(int maxIndex) throws IOException
	{
	   Scanner keyScan = new Scanner(System.in);
		System.out.println("Type in an index in range 0.."+maxIndex+": ");
		int theIndex = keyScan.nextInt( );
		return theIndex;
	}
	
	//post:  prompts for and reads in an element for a List operation 
	//       returns the Integer Element
	public static Object getElement() throws IOException
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
		      theIndex = getIndex(theList.size());
			   theElement = getElement();
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
			  theIndex=getIndex(theList.size()-1);
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
			  theIndex=getIndex(theList.size()-1);
			  System.out.println("The element at Index " + theIndex+ "is: "
			                     + theList.get(theIndex));
		   }
			catch(IndexOutOfBoundsException ex)			{
			  System.out.println("Caught:  " + ex);
			}
		}
		else if(choice==4)
		{
		   try
			{
			  theIndex = getIndex(theList.size()-1);
		  	  theElement = getElement();
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
		   theElement = getElement();
			System.out.println("The first occurence of " +
			                   theElement + " is at index " +
									 theList.indexOf(theElement));
		}
		else if(choice==6)
		{
		   theElement = getElement();
			System.out.println("Does the list contain " +
			                   theElement + "? " + theList.contains(theElement));
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
