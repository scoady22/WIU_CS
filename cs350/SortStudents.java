//SortStudents.java
//Sean Coady

import java.io.*;
import java.util.Scanner;
import utilities.Arrays;

public class SortStudents
{
  //interactively read in a list of StudentRecords format: name gpa, max of 100
  //prints out the pre and post sorted list
  public static void main(String[]args) throws IOException
  {
    StudentRecord [] student = new StudentRecord[100];
	 
	 System.out.println("Type in a student's name and gpa (ex Joe 2.5). Max of 100."
	                  +"\nPress enter at a blank line to stop.");
	 //calls readArray to fill the array with StudentRecords
	 int size = readArray(student);
	 
	 System.out.println("The original list: ");
	 //calls printArray to print out the array of StudentRecords
	 printArray(student, size);
	 
	 //calls the selectionSort method from Arrays class to sort the array of StudentRecords
	 Arrays.selectionSort(student);
	 
	 System.out.println("The sorted list: ");
	 //calls printArray to now print out the sorted list of StudentRecords
	 printArray(student, size);
  }
  //interactively reads in a list of StudentRecords in format Joe 2.5
  //returns number of StudentRecords stored
  public static int readArray(StudentRecord[] student)
  {
    Scanner scanner = new Scanner(System.in);
	 int count = 0;
	 String line = null;
	 while(true)
	 {
	   line = scanner.nextLine();
		if(line.equals(""))
		  break;
		student[count] = new StudentRecord(line);
		count++;
	 }
	 return count;
	}
	//prints out the list of StudentRecords
	public static void printArray(StudentRecord[] student, int size)
	{
	  int count = 0;
	  while(count < size)
	  {
	    System.out.println(student[count].getName()+" "+student[count].getGpa());
		 count++;
	  }
	}
}