//SortStormsFromeFile
//Ahmed Hakami
//09/30/2009

import java.io.*;
import java.util.Scanner;
import utilities.Arrays;
import java.util.Comparator;


// read in any list of up to 100 storm records(one per line) from file given on command line
// each storm contains a Storms; name year category
 public class SortStormsFromFile
  {
	public static void main(String []args)throws IOException
   {
	  StormRecord[]storm= new StormRecord[100];
	  int size= readDataFromFile(storm, args[0]);
								  	
	  System.out.println("The original list:");
     Arrays.printArray(storm, size);
	  
	  System.out.println("\nThe sorted list:");
		Arrays.selectionSort(storm);
    Arrays.printArray(storm, size);
		
	   System.out.println("\nThe list sorted by year:"); 
	  Comparator theC = new YearComparator();
		Arrays.selectionSort(storm, theC);
		Arrays.printArray(storm,size);
		
	  System.out.println("\nThe list sorted by decreasing Category:");
		theC = new CategoryComparator();
		Arrays.selectionSort(storm, theC);
		Arrays.printArray(storm,size);
	  
    }
	  // reads list of stormRecord from file
	  //returns 
	 public static int readDataFromFile(StormRecord[] storm, String fileName)throws IOException
    {
	 	Scanner scan = new Scanner( new File(fileName));
		String line = null;
		int size = 0;
		while( scan.hasNextLine())
		{
			line=scan.nextLine();
			
			storm[size]= new StormRecord(line);
			size++;
		}
		return size;
	 }
  }
	 
 