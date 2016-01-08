//WordCounts2.java
//Sean Coady

import java.util.*;
import java.io.*;

public class WordCounts2
{
  //Lists out distinct words from args[0] input file to args[1] output file
  //while also telling frequency of each distinct word, and which appeared the most
  public static void main(String[]args) throws IOException
  {
    Map theMap = new HashMap();
	 String inputFile = args[0];
	 
	 String outputFile = args[1];
	 PrintWriter writer = new PrintWriter( new FileWriter(new File(outputFile)));
	 theMap = readFile(theMap,inputFile);
	 
	 System.out.println("Word frequencies count for file: ");
	 writer.println("Word frequencies count for file: ");
	 printFile(theMap, writer);
	 
	 System.out.println(args[0]+" contains "+theMap.size()+" distinct words.");
	 writer.println(args[0]+" contains "+theMap.size()+" distinct words.");
	 
	 System.out.println("The words which occurred most frequently are: ");
	 writer.println("The words which occurred most frequently are: ");
	 printOftenWord(theMap,writer);
	 writer.close();
  }
  
  //post: reads distinct words from file input name fileName and store them in theMap
  //with frequency, and return number of distinct words
  public static Map readFile(Map theMap, String inputFile) throws IOException
  {
    Scanner scanner = new Scanner(new File(inputFile));
	 scanner.useDelimiter("[^a-zA-Z']+");
	 String word = null;
	 WordRecord theRecord;
	 
	 while(scanner.hasNext())
	 {
	   word = scanner.next();
		word=word.toLowerCase();
		if(!theMap.containsKey(word))
		{
		  theRecord = new WordRecord(word,1);
		  theMap.put(word,theRecord);
		}
		else
		{
		  theRecord = (WordRecord)theMap.get(word);
		  theRecord.incrementCount();
		}
	 }
	 return theMap;
  }
  
  
  public static void printOftenWord(Map theMap, PrintWriter writer) throws IOException
  {
    Iterator theIterator = theMap.values().iterator();
	 int count = biggestCount(theMap);
	 WordRecord theRecord;
	 
	 while(theIterator.hasNext())
	 {
	   theRecord = (WordRecord)(theIterator.next());
		if(theRecord.getCount() == count)
		{
		  System.out.println(theRecord);
		  writer.println(theRecord);
		}
	 }
  }
  
  public static int biggestCount(Map theMap) throws IOException
  {
    int high =0;
	 Iterator theIterator = theMap.values().iterator();
	 WordRecord theRecord;
	 
	 while(theIterator.hasNext())
	 {
	   theRecord = (WordRecord)(theIterator.next());
		if(theRecord.getCount()> high)
		{
		  high = theRecord.getCount();
		}
    }
	 return high;
  }
  
  public static void printFile(Map theMap, PrintWriter writer) throws IOException
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
	   
	
	