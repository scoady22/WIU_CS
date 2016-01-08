// FindOldestAgeFile.java
// Ahmad ALshehri
// 02/03/09

import java.io.*;
import java.util.Scanner;

public class FindOldestAgeInFile
{
    public static void main(String [] args)throws IOException
	 {
         PersonRecord [] person = new PersonRecord[10];
         
         int size = readDataInArray(person,args[0]);
      
         int i= findOldestAge(person, size);
   		   
			printLAstData(person,size,i);
      
      }
   // count and return the number
	       public static int readDataInArray(PersonRecord [] person,String fileName)throws IOException
		 {
         Scanner fileScan = new Scanner(new File(fileName));
         String line;
         int count = 0;
         while(fileScan.hasNextLine())
         {
            line=fileScan.nextLine();
            Scanner lineScan=new Scanner(line);
            
            person[count]= new PersonRecord(line);
            count++;
				
         }
         int size = count;
         return size;
      }
   
       public static int findOldestAge(PersonRecord [] person, int size)
      {
   		   	
			int A = 0;  
         int H = 0;
         if( person[A].getAge() > H)
         {
            H = person[A].getAge();
            A++;
         }
				 
			System.out.println(" the oldest age was " + H);
			return H;
			
         
      }
   
 	public static void printLAstData(PersonRecord [] person, int size, int i)
	{
		int F=0; // F increas everytime
		while(F<size)
		{
			person[F].getName();
			person[F].getAge();
			int H = person[F].getAge()-i;
			System.out.println(person[F].getName() + person[F].getAge() + " is  " + H); 
			F++;
	 }
  }
}