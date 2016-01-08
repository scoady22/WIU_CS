//Test Quick Sort.java
//Ahmad Alshehri
//5-1-2009

import utilities.*;
import utilities.Arrays;
import java.util.Scanner;
import java.util.*;
import java.io.*;


public class TestReverseSort
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
		Comparator theC = new ReverseNormalOrderCompartor();
		Arrays.quickSort(theArray,theC);

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
	 
