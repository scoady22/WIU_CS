//FindAverageGpa.java
//Sean Coady

import java.io.*;
import java.util.Scanner;

public class FindAverageGpa
{
  //read in a list of StudentRecords
  //prints out the average gpa and whether each student's gpa is >= or < average
  public static void main(String [] args) throws IOException
  {
    final int MAX_SIZE = 10;
	 StudentRecord[] student = new StudentRecord[MAX_SIZE];
	 
	 System.out.println("Type in a student's name and gpa (ex. Joe 2.5). Max of 10."
	                   +"\nPress enter at a blank line to stop.");
	 
	 int size = readRecords(student);
	 
	 double averageGpa = calculateAverageGpa(student, size);
	 System.out.println("The average GPA is "+averageGpa);
	 
	 printComparisonResults(student, size, averageGpa);
  }
  
  //interactively read in any number of StudentRecords (name, gpa) into student array
  //return the number of records read and stored
  public static int readRecords(StudentRecord [] student) throws IOException
  {
    String line = null;
	 Scanner scanner = new Scanner(System.in);
	 int count = 0;
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
  
  //returns the average gpa of the records stored in student[0..size-1]
  public static double calculateAverageGpa(StudentRecord[] student, int size)
  {
    int count = 0;
	 double totalGpa = 0.0;
	 double tempGpa = 0.0;
	 double avgGpa = 0.0;
	 while(count < size)
	 {
	   tempGpa = student[count].getGpa();
		totalGpa = totalGpa + tempGpa;
		count++;
	 }
	 avgGpa = totalGpa / size;
	 return avgGpa;
  }
  //print out each StudentRecord and whether that student's gpa is >= or < averageGpa
  public static void printComparisonResults(StudentRecord[] student, int size, double averageGpa)
  {
    int count = 0;
	 double gpa = 0.0;
	 while(count < size)
	 {
	   gpa = student[count].getGpa();
		if(gpa >= averageGpa)
		{
		  System.out.println(student[count].getName()+"'s GPA: "+gpa+" is greater than or equal to the Average GPA("+averageGpa+").");
		                                            
		}
		else
		{
		  System.out.println(student[count].getName()+"'s GPA: "+gpa+" is less than the average GPA("+averageGpa+").");
		}
	  count++;
	}
 }
}
		             
	   
	 