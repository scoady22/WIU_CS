// SortStudents
//Ahmed Hakami
// 09/18/2009

import java.io.*;
import utilities.Arrays;

 public class SortStudents
 {
	public static void main(String []args)throws IOException
   {
	  StudentRecord [] Student = new StudentRecord[100];
	  System.out.println("type in up to 100 student record, one per line-enter an empty line to stop");
	  int size=readArray(Student);
								  	
	  System.out.println("The original list:");
     printArray(Student, size);
	  
	  System.out.println("The sorted list:");
	  Arrays.selectionSort(Student);
     printArray(Student, size);
    }
	  // read Student record assume there is name and gpa in one line 
	 public static int readArray(StudentRecord[] Student) throws IOException
	{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader keyReader = new BufferedReader(reader);

		String line=null;
		int count=0;
		while( true )
		{
			line = keyReader.readLine();
			if(line.equals(""))
			   break;
			Student[count] = new StudentRecord(line);
			count++;
		}
		return count; //number of student elments stored
	}
	 public static void printArray(Object [] ar, int size)
	{
	  int i = 0;
	  while(i<size)
	  {
	  
	  System.out.println(ar[i]);
	  i++;
		}	
   }
 }
 