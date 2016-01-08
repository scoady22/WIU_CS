// WordRecord.java
// Ahmed Hakami
// 10-12-2009

import java.util.Scanner;

// A word record contains a word z=and his frequency
public class WordRecord implements Comparable
{
	private String word;
	private int count;
	
	// post: initialize record to given values
	public WordRecord(String theWord, int theCount)
	{ 
		setWord (theWord);
		setCount (theCount);
	}
		
	
	//post: default values for theWord and thwCoun
	public WordRecord ()
	{
		this ("", 0);
	}
	
	//post: word is set to theWord
	public void setWord(String theWord)
	{ 	
		this.word = theWord;
		
	}
	
	//post: count is set to theCount
	public void setCount(int theCount)
	{
		this.count= theCount;
	}
   
	//post: return word
	public String getWord()
	{ 
		return this.word;
	}
	
	//post: return count
	public int getCount()
	{ 
		return this.count;
	}
	
	
	//post: return string representation of record
	public String toString()
	{ 
		return this.word + " " + count;
	}
	
	//compare record the rhs record, order alphabetically by name	
	public int compareTo(Object rhs)
	{
		WordRecord rhsRecord =(WordRecord)rhs;
	
		return this.word. toLowerCase ().compareTo(rhsRecord.word.toLowerCase());
	}

	//return true if rhs record has the same word as this record
	public boolean equals(Object rhs)
	{
		if(rhs instanceof WordRecord)
			return this.compareTo(rhs)==0;
		else
			return false;
	}
	
	//post: increment count
	public void incrementCount()
	{
	  this.count++;
	}

	
}