//RemoveStudentsBelowAverage.java
//Sean Coady
import list.List;
import list.LinkedList;
import java.util.Scanner;
import java.util.Iterator;
import java.io.*;


//reads in from file at command line, any list of student records
//prints out the original list of student records and avg gpa of students in original list
//removes all studens with below average gpas from the list
//new list of students >= to average gpa

public class RemoveStudentsBelowAverage
{
  public static void main(String[]args) throws IOException
  {
    List theList = new LinkedList();
	 
	 readStudentsFromFileIntoList(args[0],theList);
	 System.out.println("Original List: ");
	 printList(theList);
	 
	 double avgGpa=findAvgGpa(theList);
	 System.out.println("\n Average GPA: "+ avgGpa);
	 
	 removeBelowAverageStudents(theList, avgGpa);
	 System.out.println("\n List of students with above average GPAs");
	 printList(theList);
  }
  
  //reads list of student record info from file fileName, stores as StudentRecords in theList
  public static void readStudentsFromFileIntoList(String fileName, List theList) throws IOException
  {
    Scanner scanner = new Scanner(new File(fileName));
	 int count=0;
	 while(scanner.hasNextLine())
	 {
	   String line = scanner.nextLine();
		theList.add(count++,new StudentRecord(line));
	 }
	 
  }
  
  //prints theList, one element per line
  public static void printList( List theList)
  {
    Iterator theIterator = theList.iterator();
	 while(theIterator.hasNext())
	 {
	   System.out.println(theIterator.next() );
	 }
   
  }
  
  //returns the average gpa of the students 
  public static double findAvgGpa(List theList)
  {
   double total=0.0;
	StudentRecord theRecord;
	Iterator theIterator = theList.iterator();
	while(theIterator.hasNext())
	{
	  theRecord = (StudentRecord) theIterator.next();
	  total = total+ theRecord.getGpa();
	}
	double average = total / theList.size();
	return average;
  }
  
  //removes the record of ay student with gpa<averageGpa from theList
  public static void removeBelowAverageStudents(List theList, double avgGpa)
  {
	 StudentRecord theRecord;
	 Iterator theIterator = theList.iterator();
	 while(theIterator.hasNext())
	 { 
		theRecord = (StudentRecord) theIterator.next();
		if(theRecord.getGpa() < avgGpa)
		{
		  theIterator.remove();
		}
	 }
  }
  
}

    