//utilities.Arrays
//Sean Coady

package utilities;
import java.util.Random;
import java.io.*;
import java.util.Comparator;

//contains useful service methods for Arrays

public class Arrays
{
  //swaps Objects ar[firstIndex] and ar[secondIndex]
  public static void swap(Object[] array, int firstIndex, int secondIndex)
  {
    Object temp = array[firstIndex];
	 array[firstIndex] = array[secondIndex];
	 array[secondIndex] = temp;
  }
  
  //returns number of elements stored in array ar
  public static int findArraySize(Object[] array)
  {
    //count up to last non null element in array[0..length-1)
	 int count = 0;
	 while(count < array.length)
	 {
	   if(array[count] == null) break;
		  count++;
	 }
	 return count;
  }
  
  //sorts ar into ascending order using its natural ordering
  public static void selectionSort(Comparable[] array)
  {
    int size = findArraySize(array);
	 //sort array array[0...size-1]
	 int i = 0;
	 while(i < size)
	 {
	   //find index of min element in array[i..size-1]
		int indexOfMin = i;
		int count = i+1;
		while(count<size)
		{
		  if(array[count].compareTo(array[indexOfMin]) < 0)
		    indexOfMin = count;
		  count++;
		}
		//swap smallest element into array[i]
		swap(array,indexOfMin,i);
		
		i++;
	 }
  }
  //print all elements in array[0.size-1]
  public static void printArray(Object[] array, int size)
  {
    int i = 0;
	 while(i < size)
	 {
	   System.out.println(array[i]);
		i++;
	 }
  }
  //create and return a random array of size integers
  public static Integer[] createRandomIntegerArray(int size)
  {
    Integer[] array = new Integer[size];
	 Random theGenerator = new Random(); // create random number generator using current time as seed
	 int count = 0;
	 while(count < size)
	 {
	   array[count] = new Integer(theGenerator.nextInt(1000) ); //generates random int 0-999
		count++;
	 }
	 return array;
  }
  //sorts array using theC to decide the ordering for the Objects in array
  public static void selectionSort(Object[] array, Comparator theC)
  {
    int size = findArraySize(array);
	 //sort array[0..size-1]
	 int i = 0;
	 while(i < size)
	 {
	   //find index of smallest element in array[i..size-1]
		int minPosition = i;
		int cnt = i+1;
		while(cnt <size )
		{
		  if(theC.compare(array[cnt], array[minPosition]) < 0)
		    minPosition = cnt;
		  cnt++;
		}
		
		//swap smallest element into array[i]
		swap(array, minPosition, i);
		i++;
	 }
  }
}