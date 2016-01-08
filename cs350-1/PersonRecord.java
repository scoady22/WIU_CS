// PersonRecord.java
// Ahmad ALshehri
// 02/03/09

import java.io.*;
import java.util.Scanner;

// A PersonRecord contains one person's first name and their age

public class PersonRecord implements Comparable
{
  private String name;                                 
  private int age;                                  
  
  // initialize record to given values
  public PersonRecord( String newName, int newAge)
  {
   setName(newName);
	setAge(newAge);
  }
 
  // initialize record to empty record
  public PersonRecord()
  {
    this("",0);
  }
 
// initialize this record to the values contained in the given String
   public PersonRecord( String theString)
   {
	  Scanner scan = new Scanner(theString);
	  setName( scan.next());
	  setAge(scan.nextInt());
	}

   // change this record's name to theName
   public void setName( String newName)
   {
	  int i;
	  int size = newName.length() -1;
	  for (i=0; i<size; i++);
	  name = newName;
	 }

 // change this record's age to theAge
 public void setAge( int newAge)
 {
    if(newAge < 0 || newAge > 150)
	  {
	    throw new RuntimeException(newAge + " is not in the range 0-150 ");
	  }
	 age = newAge;
  }

  //return this record's name
  public String getName()
  {
    return name;
  }

  // return this record's age
  public int getAge()
  {
    return age;
  }
  
  //returns a String representation of this record
  public String toString()
  {
    return name + " " + age;
  }
  // compare this record and, order alphabetically by name
   public int compareTo(Object name)
   {
     PersonRecord rhsRecord= (PersonRecord)name;
	  	
	  return this.name.compareTo(rhsRecord.name); 
	}
 
   // returns true if this record has the same name as rhs record
   public boolean equals(Object name)
   { 
	  if(name instanceof PersonRecord)
	  {
	    return true;
	  }
	  return false; 
   }
 
 }  


