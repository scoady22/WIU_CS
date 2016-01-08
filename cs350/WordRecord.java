//WordRecord.java
//Sean Coady

import java.util.Scanner;

// a WordRecord contains a word (z) and it's frequency
public class WordRecord implements Comparable
{
  private String word;
  private int count;
  
  //post: initialize record to given values
  public WordRecord(String theWord, int theCount)
  {
    setWord(theWord);
	 setCount(theCount);
  }
  
  //post: default values for theWord and theCount
  public WordRecord()
  {
    this("",0);
  }
  
  //post: word is set to theWord
  public void setWord(String theWord)
  {
    this.word = theWord;
  }
  
  //post: count is set to theCount
  public void setCount(int theCount)
  {
    this.count = theCount;
  }
  
  //returns this word
  public String getWord()
  {
    return this.word;
  }
  
  //returns this words count
  public int getCount()
  {
    return this.count;
  }
  
  //post: returns string representation of this word record
  public String toString()
  {
    return this.word+" "+count;
  }
  
  //compare this record to rhs record, comparing alphebetically
  public int compareTo(Object rhs)
  {
    WordRecord rhsRecord = (WordRecord) rhs;
	 
	 return this.word.toLowerCase().compareTo(rhsRecord.word.toLowerCase());
  }
  
  //return true if rhs record has the same word as this record
  public boolean equals(Object rhs)
  {
    if(rhs instanceof WordRecord)
	 {
	   return this.compareTo(rhs)==0;
	 }
	 else
	 {
	   return false;
	 }
  }
  
  //post: increment count
  public void incrementCount()
  {
    this.count++;
  }
}