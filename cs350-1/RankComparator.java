//RankComparator.java
// Ahmad Alshehri
// 2-26-2009

import java.io.*;
import java.util.Comparator;
public class RankComparator implements Comparator
{
	
	public int compare(Object lhs,Object rhs)
	{
				
		TeamRecord left=(TeamRecord)lhs;
		TeamRecord right=(TeamRecord)rhs;
		
		double diff= (left.findWinRatio()-right.findWinRatio());
		if(diff>0)
		return -1;
		else 
		if(diff<0)
		return+1;
		else
		return 0;
	}
}