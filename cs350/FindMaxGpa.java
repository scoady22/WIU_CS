//FindMaxGpa.java
//Sean Coady
import java.io.*;
import java.util.Scanner;

public class FindMaxGpa
{
  //read in a list of StudentRecords
  //prints out the max GPA and how far below the student is from Max.
  public static void main(String[]args) throws IOException
  {
    final int MAX_SIZE = 10;
	 StudentRecord[] student = new StudentRecord[MAX_SIZE];
	 
	 System.out.println("Type in a list of Student names and GPAs. (ex. Joe 2.5) Max of 10."
	                   +"\nPress enter at a blank line to stop.");
	 int size = readRecords(student);
	 
	 double maxGpa = calculateMaxGpa(student, size);
	 System.out.println("The highest GPA in this list is: "+maxGpa+" .");
	 
	 printComparisonResults(student, size, maxGpa);
  }
  
  //interactively reads in a list of StudentRecords(name gpa) into student array
  //returns the number of records read and stored
  public static int readRecords(StudentRecord[]student) throws IOException
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
  
  //calculates the highest gpa in student array, returns maxGpa
  public static double calculateMaxGpa(StudentRecord[] student, int size)
  {
    int count = 0;
	 double tempGpa = 0.0;
	 double highGpa = 0.0;
	 while(count < size -1)
	 {
	   tempGpa = student[count].getGpa();
		if(tempGpa > highGpa)
		 highGpa = tempGpa;
		count++;
	 }
	return highGpa;
  }
  
  //prints out each StudentRecord and states how far below the Max Gpa theirs was.
  //prints out student with highest gpa
  public static void printComparisonResults(StudentRecord[] student, int size, double maxGpa)
  {
    int count = 0;
	 double gpa = 0.0;
	 double gpaD = 0.0;
	 while(count < size)
	 {
	   gpa = student[count].getGpa();
		if(gpa == maxGpa)
		{
		  System.out.println(student[count].getName()+"'s GPA of: "+gpa+" was the highest in this list.");
	   }
		else
		{
		  gpaD = maxGpa - student[count].getGpa();
		  System.out.println(student[count].getName()+"'s GPA of: "+gpa+" was "+gpaD+" below the highest GPA: "+maxGpa+".");
		}
	  count++;
	 }
  }
}