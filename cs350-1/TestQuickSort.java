//Test Quick Sort.java
//Ahmad Alshehri
//4-30-2009

import java.io.*;
import utilities.Arrays;
import java.util.Scanner;

public class TestQuickSort
{
	public static void main( String [] args)throws IOException
	{
	
		Scanner sc = new Scanner (System.in);
		System.out.println(" read in a posoteve number n ");
		int n=sc.nextInt(); 
		Integer [] theArray = Arrays.createRandomIntegerArray(n);
		System.out.println("the old list");
		Arrays.printArray(theArray,n);
		System.out.println("______________");
		Arrays.quickSort(theArray);
		Arrays.printArray(theArray,n);
	
		PrintWriter writer=new PrintWriter(new FileWriter(new File("sorted.out")));
		int size=0;
			while(size<n)
			{				
				writer.println(theArray[size].toString());
				size++;
			}
			writer.close();
	}
}
	 
