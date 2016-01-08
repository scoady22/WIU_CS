//YearComparator
//Ahmed Hakami
//09/30/2009

import java.util.Comparator;
// orders 2 StormRecords by increasing year, so StormRecord with lowest year comes first
public class YearComparator implements Comparator
{
	//returns -int if lhs year is lower than rhs, 0 if year are==
	//			 +int if lhs year is higher than rhs
	public int compare( Object lhs, Object rhs )
	{
		StormRecord lhsRecord=(StormRecord)lhs;
		StormRecord rhsRecord=(StormRecord)rhs;
		
		
			return (lhsRecord.getYear() - rhsRecord.getYear());
				 
	}
}