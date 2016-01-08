// FindAverageAge.java
// Ahmad ALshehri
// 02/03/09

import java.io.*;
public class FindAverageAge
{
// interactively reads in the list ( max of 10 ) of person records
// print the list followed by the average age in the list
public static void main( String [] args) throws IOException
 {
   int MAX_SIZE = 10;
	PersonRecord [] person = new PersonRecord[MAX_SIZE];
	
//prompts user for records
   System.out.println("enter (name  age)");
	
// read records and count
   int size = readKeyRecordsIntoArray( person );
	
// calculate tha average
   double average = averageAge( person, size );
	
// print out the average
   System.out.println("The average age is " + average);
	System.out.println("");
	printComparisonResults(person, size, average);
  }
 
// reads in records from Keyboard
public static int readKeyRecordsIntoArray( PersonRecord [] person) throws IOException
  {
    BufferedReader keyReader = new BufferedReader( new InputStreamReader(System.in));
	 String line = null;
	 int count = 0;
	 while ( true )
	  {
	    line= keyReader.readLine();
		 if( line.equals(""))
		  
		    break;
		  
		 person[count] = new PersonRecord( line );
		 count++;
	  }
	return count;
	}
	
// calculated the average age
public static double averageAge( PersonRecord [] person, int size )
   { 
	  double average = 0.0;
	  double averageSum = 0.0;
	  for( int x=0; x<size; x++)
	   {
		  averageSum = averageSum + person[x].getAge();
		}
	  average = averageSum / size;
		return average;	
	}
// prints the comparison results for the records
public static void printComparisonResults( PersonRecord [] person, int size, double average)
  {
    for( int x=0; x<size; x++)
	  {
	    if( person[x].getAge() >= average)
		   System.out.println(person[x].getName() + "" +person[x].getAge() + "is>=" + average);
		 else
		   System.out.println(person[x].getName() + "" +person[x].getAge() + "is<" + average);
	  }
	}
} 