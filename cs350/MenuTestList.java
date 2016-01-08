//MenuTestList.java
//Sean Coady

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import list.*;

public class MenuTestList
{
   //prints menu to allow user to test and perform operations on a list,
   //prompts the user to enter String elements and int indexes for the operations,
   //then prints out the results of each menu choice,

   public static void main(String [] args) 
   {
      List theList = new LinkedList();
	
	   while(true)
	   {
	      int choice = printMenuAndGetChoice();
			processMenuChoice(choice, theList);
			if(choice==9)
		      break;
		  	System.out.println("current List:  " + theList.toString());
	   }
	}

	//post:  prints Test List menu with choices for the 
   //       operations in the list interface,
	//       reads user choice and returns it
  public static int printMenuAndGetChoice()
	{
	    Scanner scan = new Scanner(System.in);
		 System.out.println("___________________________________________________________________");
	    System.out.println("Test List operations:  ");
		 System.out.println("1) add element to list at given index");
		 System.out.println("2) remove element at given index from list ");
		 System.out.println("3) get element at given index from list");
		 System.out.println("4) set element at given index to new element " 
		                       +"and return replaced element");
		 System.out.println("5) find index of first occurrence of element in list");
		 System.out.println("6) find if list contains given element");
		 System.out.println("7) is the list empty?");
		 System.out.println("8) current size of the list?");
		 System.out.println("9) quit this application");
		 System.out.println("Choose next List operation (1-9)>");
		
		 int choice = scan.nextInt();
		 return choice; 
	}
		
	//post:  prompts for and reads in an int to use for an index
	//       returns that int index
	public static int getIndex()
	{
	   Scanner scan = new Scanner(System.in);
		System.out.println("Type in your index ");
		int theIndex = -1;
		while(theIndex<0)
		{
		  try
		  {
		    theIndex = scan.nextInt( );
		  }
		  catch(Exception ex)
		  {
		    scan.next(); //consume the non-int bad data
		    System.out.println("Type in an INT index ");
		  }
		}
		return theIndex;
	}
	
	//post:  prompts for and reads in a String to use as an element 
	//       returns the element
	public static String getElement()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Type in your string element ");
		String theElement = scan.next();
		return theElement;
	}

	
	//post:  do chosen operations on theList and print results
	public static void processMenuChoice(int choice, List theList) 
	{
	   int theIndex;
	   String theElement;
	   if(choice==1)
		{
		   try
			{
		      theIndex = getIndex();
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
			  theIndex=getIndex();
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
			   theIndex=getIndex();
			   System.out.println("The element at Index " + theIndex+ " is:  "
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
			  theIndex = getIndex();
		  	  theElement = getElement();
			  Object oldElement = theList.set(theIndex, theElement);
			  System.out.println("Replaced " + oldElement + " at " + theIndex 
			                      + " with " + theElement);
			}   
			catch(IndexOutOfBoundsException ex)
			{
			  System.out.println("Caught:  " + ex);
			}
		}
		else if(choice==5)
		{
		   theElement = getElement();
			theIndex = theList.indexOf(theElement);
			if(theIndex>-1)
			  System.out.println("The first occurence of " +
			                    theElement + " is at index " + theIndex);
			else
			  System.out.println("Sorry, "+theElement+" is not in list.");
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
		    System.out.println("The current size of the list is: "+ theList.size());
		}
		else if(choice==9)
		    System.out.println("Good-bye!");
		else
		   System.out.println("Invalid choice, choose operation 1-9");
	}
}