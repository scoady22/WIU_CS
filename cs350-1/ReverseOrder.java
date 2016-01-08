// ReverseOrder.java
// Ahmed Hakami
// 08/31/2009

import java.io.*;

 public class ReverseOrder
 {
	// reads in a list of movie titles,one per line (max of 10)
	// and prints out the list in revers order
	public static void main (String [] args) throws IOException
	{
		String [] data = new String [10];

		System.out.println ("What are your favorite movies?"
				  				  +"\nType in their titles, one per line"
								  + "\nPress enter to stop" );
		int size = readDataIntoArray (data);
      maxLineLength(data, size);
		
		System.out.println ("\nYour data reversed: ");
		printDataReversed (data,size);
	
   }
	// interactively reads list of lines into data array
	// returns number of lines stored
	public static int readDataIntoArray(String[]data) throws IOException
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
			data[count] = line;
			count++;
		}
		return count; //number of data elments stored
	}

	//print data[0..size-1]in reverse order
	public static void printDataReversed( String[] data, int size)
	{
		int count=size-1;
		while( count>=0)
		{
			System.out.println(data[count]);
			count--;
		}
	}
	
	public static void maxLineLength(String[] data, int size)
	{
		int count = 0;
		int maxLength = 0;
		while (count < size )
		{
			if (data[count].length() > maxLength)
			{
					maxLength = data[count].length();
			}	
		    count++;
		}
	   System.out.println("The largest line in your data has " + maxLength + " Characters");		
    }
 } 

