//StormRecord.java
//Sean Coady

import java.io.*;
import java.util.Scanner;

//each StormRecord contains a Storm name, the year in which it occurred, and the category
public class StormRecord implements Comparable
{
  private String name;
  private int year;
  private int category;
  
  //initialize this record to the given value
  public StormRecord(String theName, int theYear, int theCategory)
  {
    setName(theName);
	 setYear(theYear);
	 setCategory(theCategory);
  }
  //initialize this record to empty record
  public StormRecord()
  {
    this("",1,1);
  }
  
  //initialize this record to values given in String
  public StormRecord(String recordValue)
  {
    Scanner scanner = new Scanner(recordValue);
	 setName(scanner.next());
	 setYear(scanner.nextInt());
	 setCategory(scanner.nextInt());
  }
  
  //change value of this to theName
  public void setName(String theName)
  {
    this.name = theName;
  }
  
  //change value of this to theYear
  public void setYear(int theYear)
  {
    this.year = theYear;
  }
  
  //change value of this to theCategory
  public void setCategory(int theCategory)
  {
    this.category = theCategory;
  }
  
  //return this record's name
  public String getName()
  {
    return name;
  }
  //return this record's year
  public int getYear()
  {
    return year;
  }
  //return this record's category
  public int getCategory()
  {
    return category;
  }
  //returns String representation of record
  public String toString()
  {
    return name+ " "+year+" "+category;
  }
  //compare this record to rhs, order alphebetically by name
  //return -int if this < rhs , 0 if this == rhs, +int if this > rhs
  public int compareTo(Object rhs)
  {
    StormRecord rhsRecord = (StormRecord)rhs;
	 return this.name.compareTo(rhsRecord.name);
  }
  //returns true if storm's name equals storms name
  public boolean equals(Object rhs)
  {
    if(rhs instanceof StormRecord)
	 {
	 return (this.compareTo(rhs) == 0);
	 }
	 else
	 {
	 return false;
    } 
  }
}