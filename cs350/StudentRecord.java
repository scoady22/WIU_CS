//StudentRecord.java
//Sean Coady

import java.util.Scanner;

//A StudentRecord contains a name and a GPA
public class StudentRecord implements Comparable
{
  private String name;
  private double gpa;
  
  //initialize record to given values
  public StudentRecord(String theName, double theGpa)
  {
    this.setName(theName);
	 this.setGpa(theGpa);
  }
  
  //initialize record to the empty record
  public StudentRecord( )
  {
    this("",0.0);
  }
  
  //initialize record to values in given string
  public StudentRecord(String recordValues)
  {
    Scanner scanner = new Scanner(recordValues);
	 this.setName(scanner.next());
	 this.setGpa(scanner.nextDouble());
  }
  
  //name is set to theName
  public void setName(String theName)
  {
    this.name = theName+" ";
  }
  
  //gpa is set to theGpa
  public void setGpa(double theGpa)
  {
    if(theGpa < 0 || theGpa > 4.0)
	 {
	   throw new RuntimeException(theGpa + "is out of range (0-4.0)");
	 }
	 this.gpa = theGpa;
  }
  
  //returns name
  public String getName( )
  {
    return this.name;
  }
  
  //returns Gpa
  public double getGpa( )
  {
    return this.gpa;
  }
  
  //returns string representation of record
  public String toString( )
  {
    return (this.name + ""+ this.gpa);
  }
  //compare this record to StudentRecord otherStudent, order alphabetically by name
  //assumes that no two StudentRecords have the same name
  public int compareTo(Object otherStudent)
  {
    StudentRecord otherRecord = (StudentRecord)otherStudent;
	 return this.name.compareTo(otherRecord.name);
  }
  //compare this record to Any otherObject (otherObject need not be a StudentRecord)
  //returns true if otherObject is a StudentRecord and this record has the same name as
  //otherObject, and returns false otherwise
  public boolean equals(Object otherObject)
  {
    if(otherObject instanceof StudentRecord)
	   return this.compareTo(otherObject) == 0;
	 else
	 return false;
  }
}