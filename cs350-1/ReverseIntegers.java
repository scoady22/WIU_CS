// ReverseIntegers
// Ahmed Hakami
// 08/31/2009

 import java.io.*;

 public class ReverseIntegers
 {
	//interactively reads in a list of itegers,one per line(max of 10)
	// and prints out the list in reverse order
	public static void main(String [] args)throws IOException
	{

		Integer [] data = new Integer[10];

		System.out.println("Type in a list of integers, one per line."
				   +"\npress enter at blank line to stop" );
		int size = readDataIntoArray(data);
	   maxArray(data, size);
		System.out.println("\nYour data reversed: ");
		printDataReversed(data,size);
	}

	// interactively reads lidt of integers into data array
	// returns number of integers stored
	public static int readDataIntoArray(Integer[]data) throws IOException
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
			data[count] = new Integer(line);
			count++;
		}
		return count; //number or data elements stored
	}

	//print data[0..size-1]in reverse order
	public static void printDataReversed(Integer[] data, int size)
	{
		int count=size-1;
		while( count>=0)
		{
			System.out.println(data[count]);
			count--;
		}
		count--;
	}
	public static void maxArray(Integer [] data, int size)
   {
	int count = 0;
	int max=0;
	while(count<size)
	{
		if(data[count]> max)
			 max = data[count];
		count++;
	}
	System.out.println("The largest integers in your  data is : " +  max);
}
}
 