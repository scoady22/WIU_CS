/* SortIntegers.java
   Sean Coady */
	
import java.io.*;
import java.util.Scanner;
import utilities.Arrays;
public class SortIntegers
{
  //interactively reads in any list of integers (max 100), one per line
  //prints out the original list (pre and post sort)
  public static void main(String [] args) throws IOException
  {
    Integer [] number = new Integer[100];
	 
	 System.out.println("Type in up to 100 integers, one per line, enter an empty line to stop");
	 int size = readArray(number);
	 
	 System.out.println("The original list: ");
	 printArray(number, size);
	 
	 //calls selectionSort from the Arrays class to do a comparable sort, returns 
	 //the array sorted
	 Arrays.selectionSort(number);
	 
	 System.out.println("The sorted list: ");
	 printArray(number, size);
	 
  }
  
  //interactively reads in user input of integers (max of 100)
  //returns size of array
  public static int readArray(Integer[] number)
  {
    Scanner scanner = new Scanner(System.in);
	 
	 String line = null;
	 int count = 0;
	 while(true)
	 {
	   try
		{
		  line = scanner.nextLine();
		  if(line.equals(""))
			 break;
		  number[count] = new Integer(line);
		  count++;
		}
		catch(NumberFormatException ex)
		{
		 System.out.print(line +" is not an integer\nPlease enter an integer!");
		}
	 }
	 return count;
  }
  
  //prints out the number[] in sorted order
  public static void printArray(Integer[] number, int size)
  {
    int count = 0;
	 while(count < size)
	 {
	   System.out.println(number[count]);
	   count++;
	 }
  }
}
	
	   
	  
		 
  
