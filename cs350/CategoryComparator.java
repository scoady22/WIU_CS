//CategoryComparator.java
//Sean Coady

import java.util.Comparator;

//orders 2 StormRecords by Decreasing category, so StormRecord with Highest category comes first
public class CategoryComparator implements Comparator
{
  //returns -int if lhs category is > rhs, 0 is lhs == rhs
  //+ int if lhs category is < rhs
  public int compare(Object lhs, Object rhs)
  {
    StormRecord lhsRecord = (StormRecord) lhs;
	 StormRecord rhsRecord = (StormRecord) rhs;
	 
	 return -1*(lhsRecord.getCategory() - rhsRecord.getCategory() );
  }
}