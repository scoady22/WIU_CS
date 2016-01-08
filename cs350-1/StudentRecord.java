// StudentRecord.java
// Ahmed Hakami
// 09/18/2009


import java.io.*;
import java.util.Scanner;

// A StudentRecord contains one person's first name and their gpa

public class StudentRecord implements Comparable
{
  private String name;                                 
  private double gpa;                                  
  
  // initialize record to given values
  public StudentRecord( String theName, double theGpa)
  {
   setName(theName);
	setGpa(theGpa);
  }
 
  // initialize record to empty record
  public StudentRecord()
  {
    this("",0);
  }
 
// initialize record to values in  given String
   public StudentRecord( String recordValue)
   {
	  Scanner thescanner = new Scanner(recordValue);
	  setName( thescanner.next());
	  setGpa(thescanner.nextDouble());
	}

   // name is set to theName
   public void setName( String theName)
   {
	  	  this.name = theName;
	 }

 // gpa is set to theGpa
 public void setGpa( double theGpa)
 {
    if(theGpa < 0 || theGpa > 4.0)
	  {
	    throw new RuntimeException(theGpa + " set of between 0.0-4.0 ");	 
	  }
	 this.gpa = theGpa;
  }

  //return name
  public String getName()
  {
    return name;
  }

  // return gpa
  public double getGpa()
  {
    return gpa;
  }
  
  //returns  String representation of record
  public String toString()
  {
    return name + " " + gpa;
  }
 
 	// compare this record to rhs record, order alphabetically by name
	// (assumes that no two Students have the same name)
	public int compareTo( Object rhs)
	{
		StudentRecord rhsRecord =(StudentRecord)rhs;
		
		return this.name.compareTo(rhsRecord.name);
	}
	
	// returns true if this record has the same name as rhs record
	public boolean equals( Object rhs)
	{
		if(rhs instanceof StudentRecord)
		
		return (this.compareTo(rhs) ==0.);
		else
			return false;
	}			


 }  


