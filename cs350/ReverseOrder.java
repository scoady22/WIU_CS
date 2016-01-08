//ReverseOrder.java
//Sean Coady 1/20/2012

import java.io.*;
import java.util.Scanner;
public class ReverseOrder
{
  //reads in a list of movie titles, one per line (max of 10)
  //and prints out the list in reverse order
  public static void main(String [] args) throws IOException
  {
    String[] data = new String[10];
	 
	 System.out.println("What are your favorite movies?"
	                    +"\nType in their titles, one per line"
							  + "\nPress Enter To Stop");
	 int size = readData(data);
	 
	 System.out.println("\nYour data reversed: ");
	 printDataReversed(data,size);
	 int maxLength = findMaxLineLength(data,size);
	 System.out.println("The longest line in your data has "+maxLength+ " characters.");
  }
  
  //interactively reads list of lines into data array
  //returns number of lines stored
  public static int readData(String[]data) throws IOException
  {
    Scanner scanner = new Scanner(System.in);
	 
	 String line = null;
	 int count = 0;
	 while (true)
	 {
	   line = scanner.nextLine();
		if(line.equals(""))
		 break;
		data[count] = line;
		count++;
    }
	 return count; // number of data elements scored
  }
  //print data[0..size-1] in reverse order
  public static void printDataReversed( String[] data, int size)
  {
    int count = size-1;
	 while (count>=0)
	 {
	   System.out.println(data[count]);
		count--;
	 }
  }
  //finds the longest string in the array, prints which one is longest,
  //and returns the number of characters the longest string has
  public static int findMaxLineLength( String[] data,int size)
  {
   int count = 0;
	int maxLine = 0;
	String longestLine = null;
	while (count < size)
	{
	  if(data[count].length()> maxLine)
	  {
	    maxLine = data[count].length();
		 longestLine = data[count];
	  }
	 count++;
	}
	System.out.println("The longest line was: "+longestLine);
   return maxLine;
  }
}