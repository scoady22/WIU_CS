// TestSort
// Ahmed Hakami
// 09/23/2009

import utilities.Arrays;
import java.util.Scanner;
import java.io.*;

public class TestSort
{
	public static void main(String [] args)throws IOException
	{
		System.out.println("Type integer number");
		Scanner theScanner=new Scanner(System.in);
		int size= theScanner.nextInt();
		Integer[]number=Arrays.createRandomIntegerArray(size);
		System.out.println(" The Originaal list");
		Arrays.printArray(number,size);
		Arrays.selectionSort(number);
		System.out.println(" The list after sort");
		Arrays.printArray(number,size);
		printOutputToFile(number,"sorted.out",size);
				
		
	}
	// Print output to a file
	public static void printOutputToFile(Integer[]number,String fileName, int size)throws IOException
	{
		PrintWriter writer=new PrintWriter(new FileWriter(new File("sorted.out")));
		
		for(int i=0; i<size; i++)
		{			
	
			writer.println(number[i].toString() );
		
		}
		writer.close();	

	}
}