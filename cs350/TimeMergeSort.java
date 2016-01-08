//TimeMergeSort.java
//Sean Coady

import java.util.*;
import utilities.Arrays;

public class TimeMergeSort
{
  public static void main(String[] args) 
  {
    Scanner scanner = new Scanner(System.in);
	 System.out.println("Type in a positive integer: ");
	 int size = scanner.nextInt();
	 Integer [] number = Arrays.createRandomIntegerArray(size);
	 java.util.Arrays.sort(number);
	 long startTime = System.currentTimeMillis();
	 java.util.Arrays.sort(number);
	 long endTime = System.currentTimeMillis();
	 long timeMillis = endTime - startTime;
	 System.out.println(timeMillis);
  }
}