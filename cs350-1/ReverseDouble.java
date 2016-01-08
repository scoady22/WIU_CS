//ReserseDoubls
//Ahmad Alshehri
//01-27-09

import java.io.*;
public class ReverseDouble
{
//interactively reads in a list of inteegers, one per line(max of 10)
// and prints out the list in reverse order
public static void main( String [] args)throws IOException
{
   double [] data= new double [10];
   System.out.println("Type in a list of double, one per line."
                   + "\nPress enter at blank line to stop");
   int size = readDataIntoArray(data);
   System.out.println("\n Your data reversed:");
   printDataReversed(data,size);
   MaxArray(data,size);
}

// interactively reads list of integers into data array.
// returns number if inegers stored.
public static int readDataIntoArray(double [] data) throws IOException
{
  InputStreamReader reader= new InputStreamReader(System.in);
  BufferedReader keyReader = new BufferedReader(reader);
  String line=null;
  int count = 0;
  while(true)
  {
    line = keyReader.readLine();
    if(line.equals(""))
      break;
    data[count]= new Double(line);
    count++;
  }
  return count; // number of data elements stored

}

// print data [ 0... size-1] in revers order.

public static void printDataReversed(double [] data, int size)
{
	int count = size-1;
	while( count>=0)
	{
		System.out.println(data[count]);
		count--;
	}
	count--;
}

public static void MaxArray(double [] data, int size)
{
	int count = 0;
	double maxNumber=0;
	while(count<size)
	{
		if(data[count]> maxNumber)
			 maxNumber = data[count];
		count++;
	}
	System.out.println("The biggest number of data is : " +  maxNumber);
}


}