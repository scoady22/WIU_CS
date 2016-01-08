//SortIntegers
//Ahmed Hakami
//09/18/2009



import java.io.*;
import utilities.Arrays;

public class SortIntegers
{
	//interactively reads in any list of integers (maximum of 100), one per line
	// prints the out the original list (before it is sorted) and the sorted list
	public static void main(String []args)throws IOException
	{
		Integer[] number = new Integer[100];
		
		System.out.println("type in up to 100 integers, one per line-enter an empty line to stop");
		int size=readArray(number);
		
		System.out.println( "The original list:");
		printArray( number, size);
		
		Arrays.selectionSort(number);
				
		System.out.println( "The sorted list:");
		printArray( number, size);
    }
	 // interactively reads lidt of integers into data array
	// returns number of integers stored
	public static int readArray(Integer[]ar) throws IOException
	{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader keyReader = new BufferedReader(reader);

		String line=null;
		int count=0;
		while( true )
		{
			line = keyReader.readLine();
			if(line.equals(""))
			  break;
			ar[count] = new Integer(line);
			count++;
		}
		return count; //number or data elements stored
	}
   public static void printArray(Object [] ar, int size)
	{
	  int i = 0;
	  while(i<size)
	  {
	  
	  System.out.println(ar[i]);
	  i++;
		}	
	  
}

}	 