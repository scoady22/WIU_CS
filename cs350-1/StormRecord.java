// StormRecord.java
// Ahmed Hakami
// 09


import java.io.*;
import java.util.Scanner;
// each Storm Record stores a unique Storm name,the year it occurred,and it's Category(1..5)
public class StormRecord implements Comparable
{
  private String name;                                 
  private int year;
  private int category;                                 
  
  // initialize this record to given values
  public StormRecord( String theName, int theYear, int theCategory)
  {
   setName(theName);
	setYear(theYear);
	setCategory(theCategory);
  }
 
  // initialize this record to empty record
  public StormRecord()
  {
    this("",1,1);
  }
 
// initialize this record to values in  given String
   public StormRecord( String recordValue)
   {
	  Scanner thescanner = new Scanner(recordValue);
	  setName( thescanner.next());
	  setYear(thescanner.nextInt());
	  setCategory(thescanner.nextInt());
	}

   // change value of this name to theName
   public void setName( String theName)
   {
	  	  this.name = theName;
	 }

 //change value of this year to theYear
 public void setYear(int theYear)
 {
		 this.year = theYear;
  }
  //change value of this category to theCategory
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
	
  //returns  String representation of record
  public String toString()
  {
    return name + " " + year + " " + category;
  }
 
 	// compare this record to rhs, order alphabetically by name
	// return -int if this <rhs, 0 if this ==rhs +int if this > rhs
	public int compareTo( Object rhs)
	{
		StormRecord rhsRecord =(StormRecord)rhs;
		
		return this.name.compareTo(rhsRecord.name);
	}
	
	// returns true if this storm's name is same as storm name
	public boolean equals( Object rhs)
	{
		if(rhs instanceof StormRecord)
		
		return (this.compareTo(rhs) ==0.);
		else
			return false;
	}			


 }  


