// splitlistbyage.java
// Ahmad Alshehri
// 4-13-2009.

import java.util.Iterator;
import java.io.*;
import java.util.Scanner;
import list.*;

// application read name's from file 
public class SplitListByAge
{
	public static void main(String [] args)throws IOException
   {
      List theList = new LinkedList();
      int size = readPersonFromFileInToList(args[0], theList);
      System.out.println("original List");
      printList(theList);
      double averageAge = findAverageAge(theList);// remember theList knows its own size: theList.size()
      System.out.println("\naverage age=" + averageAge);
     
      List theNewList = spiltTheList( theList,averageAge) ;
      System.out.println("\n Persons with age older than or equal to averageAge:");
      printList(theList);
      System.out.println("\n List of Persons with age younger than average Age:");
      printNewData(theNewList);
      
   }
   	
 // read person name and age from file.
 public static int readPersonFromFileInToList(String fileName, List theList)throws IOException
 {
     Scanner filesc = new Scanner(new File(fileName));
     String line;
     int i=0;
     while(filesc.hasNextLine())
     {
         line=filesc.nextLine();
          theList.add(i, new PersonRecord(line));
         	
         i++;
     }
    int size =i;
    return  size;
}	
   	
// calculate average age.
   public static double findAverageAge( List theList)
   {
     Iterator theIterator = theList.iterator();
     int ages=0;
     PersonRecord theRecord = null;
     while(theIterator.hasNext())
     {
       theRecord = (PersonRecord) theIterator.next();
       ages = ages + theRecord.getAge();
         
    }
      
     double averageAge = ages/theList.size();
     return averageAge;
   }
   	
   //if the person's  age less than tha avrageAge add  this name to new list
  public static List spiltTheList(List theList, double avrAge)
  {
  	 PersonRecord theRecord = null;
    Iterator theIterator = theList.iterator();
    int i = 0;
    List theNewList = new LinkedList();
    while(theIterator.hasNext())
    {
    	 theRecord =(PersonRecord)theIterator.next();
       if(theRecord.getAge()< avrAge) 
       {
           theIterator.remove();
           theNewList.add(i,theRecord );
            i++;
        }
     }
     return theNewList;
  }
   
//print data from theList
  public static void printList(List theList)
  {
      Iterator theIterator = theList.iterator();
      while (theIterator.hasNext())
      {
          System.out.println(theIterator.next());
      }
  }
   
 // print data that come from theNewList.
    public static void printNewData(List theNewList)
    {
        Iterator theIterator = theNewList.iterator();
        while ( theIterator.hasNext() )
        {
           System.out.println(theIterator.next());
        }
    } 
   
}
