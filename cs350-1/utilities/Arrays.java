// utilities.Arrays
//Ahmed Hakami
//09/18/2009

package utilities;
import java.util.Comparator;
import java.io.*;
import java.util.Random;


// contains useful service methods for Arrays
public class Arrays
{
	// swaps Objects ar[firstlndex] and ar[secondlndex]
	public static void swap( Object[] ar, int firstlndex, int secondlndex )
	{
		Object temp = ar[firstlndex];
		ar[firstlndex]=ar[secondlndex];
		ar[secondlndex]=temp;
	}
	// returns number of elements stored in array ar
	public static int findArraySize( Object[] ar)
	{
		// count up to last non-null element in array[0..ar.length-l]
		int count = 0;
		while( count < ar.length )
		{
			if( ar[count] == null) break;
			count++;
		}
		return count;
	}
	// sorts ar into ascending order using its natural ordering
	public static void selectionSort( Comparable[] ar )
	{
		int size = findArraySize( ar );
		// sortar[0..size-l]
		int i = 0;
		while( i < size )
		{
			// find index of smallest element in ar[i..size-l]
			int indexOfMin = i;
			int count = i+1;
			while( count < size)
			{
			  if( ar[count].compareTo(ar[indexOfMin])< 0)
					indexOfMin = count;
				count++;
			}
		
			// swap smallest element into ar[i]
			swap(ar,	indexOfMin,i);
			i++;
		}
	}	
	
	// sorts array ar uding theC to decide the ordering for the Objects in array
	public static void selectionSort( Object[] ar, Comparator theC )
	{
		int size = findArraySize( ar );
		// sortar[0..size-l]
		int i = 0;
		while( i < size )
		{
			// find index of smallest element in ar[i..size-l]
			int minPosition = i;
			int cnt = i+1;
			while( cnt < size)
			{
			  if( theC.compare(ar[cnt],ar[minPosition])< 0)
					minPosition = cnt;
				cnt++;
			}
		
			// swap smallest element into ar[i]
			swap(ar,	minPosition,i);
			i++;
		}
	}	
		
	// print all elements in ar[0..size-1]
	public static void printArray(Object[] ar, int size)throws IOException 
	{
	  int i = 0;
	  while(i<size)
	  {
	  System.out.println(ar[i]);
	  i++;
		}	
	  
	}
	
		// create and return a random array ofsize Integers
	public static Integer[] createRandomIntegerArray(int size)
	{
	  Integer [] ar= new Integer[size];
	  	  Random theGenerator= new Random(); // create random number generator using current time as seed
		  int i=0;
	  	  while(i<size)
	  	  {
        	  
	    		ar[i]=new Integer(theGenerator.nextInt(1000));// generator a random int in rang 0...999
		 		i++;
	  		}
			  return ar;
	}

	
}
