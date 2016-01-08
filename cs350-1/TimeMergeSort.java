// TimeMergeSort
// Ahmed Hakami
// 11/30/2009

import java.util.*;
import utilities.Arrays;


public class TimeMergeSort
{
	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		int size = sc.nextInt();
		System.out.println(" read in posoteve integer n ");
		Integer [] number = Arrays.createRandomIntegerArray(size);
		java.util.Arrays.sort(number);
		long startTime=System.currentTimeMillis();
		java.util.Arrays.sort(number);
		long endTime=System.currentTimeMillis();
		long TimeMills=endTime-startTime;
		System.out.println(TimeMills);
		
	}
}
