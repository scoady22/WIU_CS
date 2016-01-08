// FindAverageGpa.java
// Ahmed Hakami
// 09/06/09

import java.io.*;
public class FindAverageGpa
{
// interactively read in any list ( max of 10 ) of student records
// print by the average gpa in the list
public static void main( String [] args) throws IOException
 {
  
	StudentRecord [] student = new StudentRecord[10];
	
//prompts user for records
   System.out.println("Enter Name : Gpa ");
	
   int size = readRecords( student );
	
   double avgGpa = calculateAverageGpa( student, size );
	
// print out the avergpa
   System.out.println("The average gpa : " + avgGpa);
	
	printComparisonResults(student, size, avgGpa);
  }
 
// interactively read in any number of StudentRecords(name gpa)into the student array
// return the number of records read and stored
public static int readRecords( StudentRecord [] student) throws IOException
  {
    BufferedReader keyReader = new BufferedReader( new InputStreamReader(System.in));
	 String line = null;
	 int count = 0;
	 while ( true )
	  {
	    line= keyReader.readLine();
		 if( line.equals(""))
		  
		    break;
		  
		 student[count] = new StudentRecord( line );
		 count++;
	  }
	return count;
	}
	
// returns the average gpa of the records stored in student[ 0..size-1]
public static double calculateAverageGpa( StudentRecord [] student, int size )
   { 
	  double avg = 0.0;
	  double avgSum = 0.0;
	  for( int i=0; i<size; i++)
	   {
		  avgSum = avgSum + student[i].getGpa();
		}
	  avg = avgSum / size;
		return avg;	
	}
// print out each StudentRecord and whether that student's gpa is>= or < avg
public static void printComparisonResults( StudentRecord [] student, int size, double avg)
  {
    int i=0;  
    for( i=0; i<size; i++)
	  {
	    if( student[i].getGpa() >= avg)
		   System.out.println(student[i].getName() + " " +student[i].getGpa() + " is >=  " + avg);
		 else
		   System.out.println(student[i].getName() + " " +student[i].getGpa() + " is < " + avg);
	  }
	}
} 