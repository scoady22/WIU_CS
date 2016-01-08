// TestMergeSort.java
// Ahmed Hakami
// 11/30/2009

import java.io.*;
import utilities.Arrays;
import java.util.Scanner;

public class TestMergeSort
{
	public static void main( String [] args)throws IOException
	{
	
		Scanner sc = new Scanner (System.in);
		System.out.println(" read in a posoteve integer n ");
		int size=sc.nextInt(); 
		Integer [] number = Arrays.createRandomIntegerArray(size);
		System.out.println("the old list");
		Arrays.printArray(number,size);
		System.out.println("The list after sort");
		java.util.Arrays.sort(number);
		Arrays.printArray(number,size);
	
		PrintWriter writer=new PrintWriter(new FileWriter(new File("sorted.out")));
		int i=0;
			while(size<size)
			{				
				writer.println(number[size].toString());
				i++;
			}
			writer.close();
	}
}
	 
	