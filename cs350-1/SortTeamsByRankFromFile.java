// SortTeamsByRankFromFile.java
// Ahmad Alshehri
// 2-26-2009


import java.io.*;
import java.util.Scanner;
import utilities.Arrays;
import java.util.Comparator;


public class SortTeamsByRankFromFile
{
	public static void main(String [] args)throws IOException
	{
		TeamRecord[]team= new TeamRecord [100];
		
		int size = readfromFile(team, args[0]);
		
		Comparator theC = new RankComparator();
	
		Arrays.selectionSort(team, theC);
	
		Arrays.printArray(team,size);
		
	}
	
	
	public static int readfromFile(TeamRecord [] team, String fileName)throws IOException 
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
	

}
