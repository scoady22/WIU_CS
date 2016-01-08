//ReverseDoubles.java
//Sean Coady 1/20/12
import java.io.*;
import java.util.Scanner;
public class ReverseDoubles
{
  //interactively reads in a list of real numbers, one per line (max of 10)
  // and prints out the list in reverse order
  public static void main(String [] args) throws IOException
  {
    Double [] data = new Double[10];
	 
	 System.out.println("Type in a list of real numbers, one per line."
	                   +"\nPress enter at blank line to stop");
	 int size = readData(data);
	 
	 System.out.println("\nYour Data Reversed: ");
	 printDataReversed(data,size);
	 Double max = findMax(data,size);
	 System.out.println("\nThe largest real number in your data is "+max);
  }
  
  //interactively reads list of integers into data array
  //returns number of integers stored
  public static int readData(Double[]data) throws IOException
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
		  data[count]= new Double(line);
		  count++;
		}
		catch(NumberFormatException ex)
		{
		  System.out.print(line +" is not a real number\nPlease enter an integer!");
		}
	 }
	 return count; //number of data elements stored
  }
  
  //print data[0..size-1] in reverse order
  public static void printDataReversed(Double[] data, int size)
  {
    int count = size-1;
	 while(count>=0)
	 {
	   System.out.println(data[count]);
		count--;
	 }
  }
  public static Double findMax(Double[] data, int size) throws IOException
  {
    //finds the largest double in the array
	 int count = 0;
	 Double maxInt = data[count];
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