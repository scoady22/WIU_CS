// Sort Person From File
// Ahmed Alshehri
// 15-2-2009.
import java.io.*;
import utilities.Arrays;

 public class SortPersonsFromFile
 {
	public static void main(String []args)throws IOException
   {
	  PersonRecord [] person = new PersonRecord[10];
	  int size= readPersonsIntoArray(person, args[0]);
								  	
	  System.out.println("The original list:");
     Arrays.printArray(person, size);
	  
	  System.out.println("The sorted list:");
	  Arrays.selectionSort(person);
     Arrays.printArray(person, size);
    }
	  // read person record assume there is name and age in one line 
	 public static int readPersonsIntoArray(PersonRecord[] person, String fileName)throws IOException
    {
      File inFile=new File(fileName);
	   BufferedReader fileReader=new BufferedReader(new FileReader(inFile));
      
	   String line = null;
	   int size=0; 	
	   					  
	   while(true)
	   {
	    
       line = fileReader.readLine();
       if (line==null)
		   break;
		 person[size]=new PersonRecord(line);
		 size++; 
	   }
	   return size;   
    }
 }
 