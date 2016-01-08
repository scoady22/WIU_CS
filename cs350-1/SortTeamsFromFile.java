// SortTeamsFromFile.java
// Ahmad Alshehri
// 2-26-2009.


import java.io.*;
import java.util.Scanner;
import utilities.Arrays;


public class SortTeamsFromFile
{
	public static void main(String [] args)throws IOException
	{
		TeamRecord [] team= new TeamRecord[100];
		
		int size= readRecordFromFile( team, args[0]);
		
		Arrays.selectionSort(team);
		
		printData(team,size);
		
		
		
	}
	// read data 
	public static int readRecordFromFile( TeamRecord [] team, String fileName)throws IOException
	{
	 	Scanner fileScan = new Scanner(new File(fileName));
      String line;
      int size = 0;
      while(fileScan.hasNextLine())
      {
          line=fileScan.nextLine();
		    team[size]= new TeamRecord(line);
  
			size++;
      }
         
         return size;
	}
   
	
	public static void printData(TeamRecord [] team, int size)
	{
		int count = 0;
		while(count<size)
		{
				System.out.println( team[count].getName() + team[count].findWinRatio());
				count++;
		}
	}
	

}
