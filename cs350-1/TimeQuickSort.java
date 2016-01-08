//Time Quick Sort.java
//Ahmad Alshehri
//4-30-2009


import utilities.Arrays;
import java.util.*;


public class TimeQuickSort
{
	public static void main(String [] args)
	{
	
		System.out.println(" Type in positive number n");
		Scanner sc=new Scanner(System.in);
		int size= sc.nextInt();
		
		Integer[]number=Arrays.createRandomIntegerArray(size);
		
		long startTime=System.currentTimeMillis();
		
		Arrays.quickSort(number);
		
		long endTime=System.currentTimeMillis();
		long timeInMillis= endTime-startTime;
		
		System.out.println(timeInMillis);
	}
}