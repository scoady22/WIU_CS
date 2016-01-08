//StudentRecord.java
//Sean Coady

import java.util.Scanner;

//A StudentRecord contains a name and a score
public class StudentRecord 
{
  private String name;
  private int score;
  
  //initialize record to given values
  public StudentRecord(String theName, int theScore)
  {
    this.setName(theName);
	 this.setScore(theScore);
  }
  
  //initialize record to the empty record
  public StudentRecord( )
  {
    this("",0);
  }
  
  //initialize record to values in given string
  public StudentRecord(String recordValues)
  {
    Scanner scanner = new Scanner(recordValues);
	 this.setName(scanner.next());
	 this.setScore(scanner.nextInt());
  }
  
  //name is set to theName
  public void setName(String theName)
  {
    this.name = theName+" ";
  }
  
  //score is set to theScore
  public void setScore(int theScore)
  {
    if(theScore < 0 || theScore > 10)
	 {
	   throw new RuntimeException(theScore + "is out of range (0-10)");
	 }
	 this.score = theScore;
  }
  
  //returns name
  public String getName( )
  {
    return this.name;
  }
  
  //returns score
  public int getScore( )
  {
    return this.score;
  }
  
}