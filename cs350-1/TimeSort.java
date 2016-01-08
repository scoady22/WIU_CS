// TimeSort
// Ahmed Hakami
// 09/23/2009

import utilities.Arrays;
import java.util.Scanner;


public class TimeSort
{
	public static void main(String [] args)
	{
	
		System.out.println(" Type in positive number");
		Scanner sc=new Scanner(System.in);
		int size= sc.nextInt();
		
		Integer[]number=Arrays.createRandomIntegerArray(size);
		
		long startTime=System.currentTimeMillis();
		
		Arrays.selectionSort(number);
		
		long endTime=System.currentTimeMillis();
		long timeInMillis= endTime-startTime;
		
		System.out.println("It took "+timeInMillis+" milliseconds");
	}
}