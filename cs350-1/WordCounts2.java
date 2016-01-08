// WordCounts2.java
// Ahmed Hakami
// 10-12-2009

import java.util.*;
import java.io.*;
public class WordCounts2
{

	//List out distinct words from the args[0] input file to the args[1] output file along with
	//thire frequncy telling how many distinct words there the word that appear the most
	//read number of distinct word and them with thier frequncy
	public static void main(String [] args)throws IOException
	{
		Map theMap = new HashMap();
		String inPutFile = args[0];
		
		String outPutFile = args[1];
		PrintWriter writer = new PrintWriter(new FileWriter(new File(outPutFile)));
		theMap = readFile(theMap, inPutFile);
		
		System.out.println("  Word frequencies counts for file; " );
		writer.println("  Word frequencies counts for file; " );
		printFile(theMap, writer);
		
		System.out.println( args[0] + " contain " + theMap.size() + " distinct word's");
		writer.println( args[0] + " contain " + theMap.size() + " distinct word's");
		
		System.out.println(" The words that occurred most frequently are: ");
		writer.println(" The words that occurred most frequently are: ");
		printOftenWord(theMap,writer);
		writer.close();
	}
	
	
	//post:  read distinct word from the input file named fileName and store them in yheMap along
	//			with there frequncy, return number of distinct words
	public static Map readFile( Map theMap, String inPutFile) throws IOException
	{
		Scanner fileScanner = new Scanner(new File(inPutFile));
		fileScanner.useDelimiter("[^a-zA-Z']+");
		String word = null;
		WordRecord theRecord ; 
		
		while(fileScanner.hasNext())
		{
			word = fileScanner.next();
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
	
	//post: print out the list of words that occurred biggest frequncy in the filename
	public static void printOftenWord( Map theMap, PrintWriter writer )throws IOException
	{
		Iterator theIterator = theMap.values().iterator();
		int count = biggestCount(theMap);
		WordRecord theRecord;
		while(theIterator.hasNext())
		{
			theRecord = (WordRecord) theIterator.next();
			if ( theRecord.getCount() == count )
			{
					System.out.println(theRecord);
					writer.println(theRecord);
			}
		}
	}
	
	
	public static int biggestCount( Map theMap )throws IOException
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
	
	//post: print out the words
	public static void printFile( Map theMap, PrintWriter writer )throws IOException
	{
	
		WordRecord theRecord;
		Iterator theIterator = theMap.values().iterator();
		while(theIterator.hasNext())
		{
			theRecord = (WordRecord)(theIterator.next());
			System.out.println(theRecord);
			writer.println(theRecord);
		}
		
	}

}