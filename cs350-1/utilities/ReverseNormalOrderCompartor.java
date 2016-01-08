// Reverse NormalOrderComparator.java
//Ahmad Alshehri
//4-30-2009.

package utilities;
import java.util.*;
// order teo comparableobjects in the reverse of their normal order. 
public class ReverseNormalOrderCompartor implements Comparator
{
	public int compare( Object lhs,Object rhs)
	{
		Comparable l=(Comparable)lhs;
		Comparable r=(Comparable)rhs;
	return -1* (l.compareTo(r));
	}
}