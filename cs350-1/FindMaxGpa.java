// FindMaxGpa.java
// Ahmed Hakami
// 09/06/09

import java.io.*;
public class FindMaxGpa
{
// interactively read in any list ( max of 10 ) of student records
// print by the max gpa in the list
public static void main( String [] args) throws IOException
 {
  
	StudentRecord [] student = new StudentRecord[10];
	
//prompts user for records
   System.out.println("Enter Name : Gpa ");
	
   int size = readRecords( student );
	
   double maxGpa = findHighestGpa( student, size );
	
// print out the maxgpa
   System.out.println("The max gpa : " + maxGpa);
	
	printComparisonResults(student, size, maxGpa);
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
	
// returns the max gpa of the records stored in student[ 0..size-1]
public static double findHighestGpa( StudentRecord [] student, int size )
   { 
	  double max = 0.0;
	  for( int i=0; i<size; i++)
	  { 
		  if( student[i].getGpa()>= max)
		  max = student[i].getGpa();
		}   
		return max;	
	}
// print out each StudentRecord and whether that student's how much below the max
public static void printComparisonResults( StudentRecord [] student, int size, double max)
  {
    int i=0;  
    for( i=0; i<size; i++)
	  {
	    if( student[i].getGpa() == max)
		   System.out.println(student[i].getName() + " " +student[i].getGpa() + " is equal the max gpa  " 
			+ max);
		 else
		   System.out.println(student[i].getName() + " " +student[i].getGpa() + " is below the max gpa " 
			+ (max-student[i].getGpa()));
	  }
	}
} 