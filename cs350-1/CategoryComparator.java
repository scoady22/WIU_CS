//CategoryComparator
//Ahmed Hakami
//09/30/2009

import java.util.Comparator;
// orders 2 StormRecords by DECREASING category, so StormRecord with HIGHEST CATEGORY comes first
public class CategoryComparator implements Comparator
{
	//returns -int if lhs category is higher than rhs, 0 if category are==
	//			 +int if lhs category is lower than rhs
	public int compare( Object lhs, Object rhs )
	{
		StormRecord lhsRecord=(StormRecord)lhs;
		StormRecord rhsRecord=(StormRecord)rhs;
		

			return -1*(lhsRecord.getCategory()-rhsRecord.getCategory());
				 
	}
}