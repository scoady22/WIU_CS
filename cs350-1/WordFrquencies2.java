// WordFrquencies2.java
// Ahmad Alshehri
// 05-07-09

import java.util.*;
import java.io.*;
public class WordFrquencies2
{
	public static void main(String [] args)throws IOException
	{
		Map theMap = new HashMap();
		String inComeFile = args[0];
		String outPutFile = args[1];
		theMap = readFile(theMap,inComeFile);
		
		System.out.println("  Word frequencies counts for file rhyme " );
		printFile(theMap, outPutFile);
		
		System.out.println(" thefile contain" + theMap.size() + " distinct word's");
		
		System.out.println(" The words that occurred most often are: ");
		printOfetenWord(theMap);
	}
	
	
	public static SortedMap readFile(SortedMap theMap, String inComeFile) throws IOException
	{
		Scanner scan = new Scanner(new File(inComeFile));
		scan.useDelimiter("[^a-zA-Z]+");
		String word = null;
		WordRecord theRecord ; 
		
		while(scan.hasNext())
		{
			word = scan.next();
			word = word.toLowerCase();
			if( ! theMap.containsKey(word))
			{
				theRecord = new WordRecord(word,1);	
				theMap.put( word, theRecord);
			}
			else 
			{
				 theRecord =(WordRecord) theMap.get(word);
				 theRecord.incrementCount();
			}
		}
		return theMap;
	}
	
	public static void printOfetenWord(SortedMap theMap)throws IOException
	{
		Iterator theIterator = theMap.values().iterator();
		int x = biggestCount(theMap);
		WordRecord theRecord;
		while(theIterator.hasNext())
		{
			theRecord = (WordRecord) theIterator.next();
			if ( theRecord.getCount() == x)
					System.out.println(theRecord);
		}
	}
	
	public static int biggestCount(SortedMap theMap)throws IOException
	{
		int high = 0; 
		Iterator theIterator = theMap.values().iterator();
		WordRecord theRecord;
		while(theIterator.hasNext())
		{
			theRecord = (WordRecord) theIterator.next();
			if(theRecord.getCount() > high)
				high = theRecord.getCount();
		}
		return high;
	}
	public static void printFile(SortedMap theMap, String outName)throws IOException
	{
		PrintWriter writer = new PrintWriter(new FileWriter(new File(outName)));
		WordRecord theRecord;
		Iterator theIterator = theMap.values().iterator();
		while(theIterator.hasNext())
		{
			theRecord = (WordRecord)(theIterator.next());
			System.out.println(theRecord);
			writer.println(theRecord);
		}
		writer.close();
	}

	public static void printInFile(SortedMap theMap, String outFile)throws IOException
	{
		PrintWriter writer = new PrintWriter(new FileWriter(new File(outFile)));
		WordRecord theRecord;
		Iterator theIterator = theMap.values().iterator();
		while(theIterator.hasNext())
		{
			theRecord = (WordRecord)(theIterator.next());
			writer.println(theRecord);
			
		}
		writer.close();
	}

}