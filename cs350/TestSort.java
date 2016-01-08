//TestSort.java
//Sean Coady

import java.io.*;
import java.util.Scanner;
import utilities.Arrays;

//interactively prompts user to input a positive integer (size) which determines size of array
//creates random array of size integers
public class TestSort
{
  public static void main(String[] args) throws IOException
  {
    System.out.println("Type in a positive integer");
	 Scanner scanner = new Scanner(System.in);
	 int size = scanner.nextInt();
	 Integer[] number = Arrays.createRandomIntegerArray(size);
	 System.out.println("The original list: ");
	 Arrays.printArray(number, size);
	 Arrays.selectionSort(number);
	 System.out.println("The sorted list: ");
	 Arrays.printArray(number, size);
	 printOutPutToFile(number, "sorted.out", size);
  }
  
  //prints output to file
  public static void printOutPutToFile( Integer[] number, String fileName, int size) throws IOException
  {
    PrintWriter writer = new PrintWriter(new FileWriter(new File("sorted.out")));
	 
	 for (int i = 0; i < size; i++)
	 {
	   writer.println(number[i].toString() );
	 }
  }
}
    