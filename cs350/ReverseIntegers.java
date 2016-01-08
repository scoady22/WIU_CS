//ReverseIntegers.java
//Sean Coady 1/20/12
import java.io.*;
import java.util.Scanner;
public class ReverseIntegers
{
  //interactively reads in a list of integers, one per line (max of 10)
  // and prints out the list in reverse order
  public static void main(String [] args) throws IOException
  {
    Integer [] data = new Integer[10];
	 
	 System.out.println("Type in a list of integers, one per line."
	                   +"\nPress enter at blank line to stop");
	 int size = readData(data);
	 
	 System.out.println("\nYour Data Reversed: ");
	 printDataReversed(data,size);
	 int max = findMax(data,size);
	 System.out.println("\nThe largest integer in your data is "+max);
  }
  
  //interactively reads list of integers into data array
  //returns number of integers stored
  public static int readData(Integer[]data) throws IOException
  {
    Scanner scanner = new Scanner(System.in);
	 
	 String line = null;
	 int count = 0;
	 while ( true )
	 {
	   try
		{
		  line = scanner.nextLine();
		  if(line.equals(""))
		   break;
		  data[count]= new Integer(line);
		  count++;
		}
		catch(NumberFormatException ex)
		{
		  System.out.print(line +" is not an integer\nPlease enter an integer!");
		}
	 }
	 return count; //number of data elements stored
  }
  
  //print data[0..size-1] in reverse order
  public static void printDataReversed(Integer[] data, int size)
  {
    int count = size-1;
	 while(count>=0)
	 {
	   System.out.println(data[count]);
		count--;
	 }
  }
  public static int findMax(Integer[] data, int size) throws IOException
  {
    //finds the largest integer in the array
	 int count = 0;
	 int maxInt = data[count];
	 while(count < size)
	 {
	   if (data[count] > maxInt)
		 {
		   maxInt = data[count];
		 }
	   count++;
	 }
	 return maxInt;
  }
}