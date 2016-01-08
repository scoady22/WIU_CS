// TeamRecord.java
//Ahmad Alshehri
// 2-26-2009


import java.util.*;
public class TeamRecord implements Comparable
{
	private String name;
	private int won;
	private int lost;
	
	// initializ record to given value
	public TeamRecord( String thename, int thewon, int thelost)
	{
		setname(thename);
		setwon(thewon);
		setlost(thelost);
	}
	
	//initialize record to the empty record
	public TeamRecord()
	{
		this(" ",0,0);
	}
	
	//initialize record to values in the given string
	public TeamRecord(String recordInfo)
	{
		Scanner fileScan = new Scanner(recordInfo);
		setname(fileScan.next());
		setwon(fileScan.nextInt());
		setlost(fileScan.nextInt());
		
	}

	// change values in the name to theName
	public void setname( String thename)
	{
		name=thename;
	}
	
	// change value of won to theWon
	public void setwon( int thewon)
	{
		won=thewon; 
		
	}
	
	
	public void setlost( int thelost)
	{
		lost=thelost;
	}
	
	
	public String getName()
	{
		return name;
	}
	
	public int getWon()
	{
		return won;
	}
	
	public int getLost()
	{
		return lost;
	}
	
	// win ration
	public double findWinRatio()
	{
		
		
		return (double)won/(won+lost);
	}
		
	// return string representation of record
	
	public String toString()
	{
		return name+  + won +  + lost ;
	}
	
	
	public int compareTo( Object otherRecord)
	{
		TeamRecord oneRecord =(TeamRecord)otherRecord;
	
		return this.name.compareTo(oneRecord.name);
	}
	
	public boolean equals( Object otherRecord )
	{
		if(otherRecord instanceof TeamRecord)
			return this.compareTo(otherRecord)==0;
		else
			return false;
	}
}
