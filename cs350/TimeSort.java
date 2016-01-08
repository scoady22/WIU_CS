//Sean Coady
//TimeSort.java

import java.util.Scanner;
import java.io.*;
import utilities.Arrays;

//prompts user for a positive integer, size, which determines array size
//fills array with random, size integers and prints output
//times (in ms) how long this takes
public class TimeSort
{
  public static void main(String [] args)
  {
    System.out.println("Type in a positive integer");
    Scanner scanner = new Scanner(System.in);
    int size = scanner.nextInt();
  
    Integer[] number = Arrays.createRandomIntegerArray(size);
  
    long startTime = System.currentTimeMillis();
    Arrays.selectionSort(number);
  
    long endTime = System.currentTimeMillis();
    long timeInMillis = endTime - startTime;
  
    System.out.println("The sort took "+timeInMillis+" milliseconds.");
  }
}
