//TestMergeSort.java
//Sean Coady

import java.io.*;
import utilities.Arrays;
import java.util.Scanner;

public class TestMergeSort
{
  public static void main(String[]args) throws IOException
  {
    Scanner scanner = new Scanner(System.in);
	 System.out.println("Type in a positive integer: ");
	 int size = scanner.nextInt();
	 Integer[]number = Arrays.createRandomIntegerArray(size);
	 System.out.println("The old list: ");
	 Arrays.printArray(number,size);
	 System.out.println("The sorted list: ");
	 java.util.Arrays.sort(number);
	 Arrays.printArray(number,size);
	 
	 PrintWriter writer = new PrintWriter(new FileWriter(new File("sorted.out")));
	 
	 int i =0;
	 while(size<size)
	 {
	   writer.println(number[size].toString());
		i++;
	 }
	 writer.close();
  }
}
	 