// ReverseDoubles
// Ahmed Hakami
// 08/31/2009

 import java.io.*;

 public class ReverseDoubles
 {
	//interactively reads in a list of itegers,one per line(max of 10)
	// and prints out the list in reverse order
	public static void main(String [] args)throws IOException
	{

		Double [] data = new Double[10];

		System.out.println("Type in a list of integers, one per line."
				   +"\npress enter at blank line to stop" );
		int size = readDataIntoArray(data);
		System.out.println("\nYour data reversed: ");
		printDataReversed(data,size);
	}

	// interactively reads lidt of integers into data array
	// returns number of integers stored
	public static int readDataIntoArray(Double[]data) throws IOException
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
			data[count] = new Double(line);
			count++;
		}
		return count; //number or data elements stored
	}

	//print data[0..size-1]in reverse order
	public static void printDataReversed(Double[] data, int size)
	{
		int count=size-1;
		while( count>=0)
		{
			System.out.println(data[count]);
			count--;
		}
		count--;
	}
 }