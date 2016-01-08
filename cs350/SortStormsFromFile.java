//SortStormsFromFile.java
//Sean Coady

import java.io.*;
import java.util.Scanner;
import utilities.Arrays;
import java.util.Comparator;

//reads in up to 100 StormRecords from file given in command line argument, one per line
//each StormRecord contains a storm name (name), year (year), and category (category)

public class SortStormsFromFile
{
  public static void main(String [] args) throws IOException
  {
    StormRecord [] storm = new StormRecord[100];
	 int size = readDataFromFile(storm, args[0]);
	 
	 System.out.println("The original list");
	 Arrays.printArray(storm, size);
	 //sorts array by name alphabetically
	 System.out.println("\nThe Sorted List");
	 Arrays.selectionSort(storm);
	 Arrays.printArray(storm, size);
	 //sorts array by increasing year
	 System.out.println("\nThe list sorted by year");
	 Comparator theC = new YearComparator();
	 Arrays.selectionSort(storm,theC);
	 Arrays.printArray(storm,size);
	 //sorts array by decreasing category
	 System.out.println("\nThe list sorted by decreasing category");
	 theC = new CategoryComparator();
	 Arrays.selectionSort(storm, theC);
	 Arrays.printArray(storm,size);
  }
  
  //reads list of StormRecords from file
  //returns
  public static int readDataFromFile(StormRecord[] storm, String fileName) throws IOException
  {
    Scanner scanner = new Scanner(new File(fileName));
	 String line = null;
	 int size = 0;
	 while(scanner.hasNextLine())
	 {
	   line = scanner.nextLine();
		
		storm[size] = new StormRecord(line);
		size++;
    }
	 return size;
  }
}
	 
	 