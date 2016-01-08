// post: sorts ar into natural order using compareTO()
 public static void quickSort( Comparable[]ar)
 {
 	quickSort( ar,0,findArraySize(-1));   // sort only non-null part of array if its not full
 }
 	// post: sort ar[ lowIndex..highIndex] into natural order ( as determinde by compareTo method)
	private static void quickSort( Comparable[] ar, int lowIndex, highIndex)
	{
		if(lowIndex >= highIndex)
			return;                      // done: list of size 0 or 1 does not need sorting!
			
			// sort ar[lowIndex],ar[midIndex],ar[highIndex] then pick pivot to be middle of those three
			int midIndex=(lowIndex+highIndex)/2;
			if(ar[midIndex].compareTo(ar[lowIndex])<0)
				swap(ar,lowindex,midIndex);
			if(ar[highIndex].compareTo(ar[lowIndex])<0)
				swap(ar,lowindex,highIndex);
			if(ar[highIndex].compareTo(ar[midIndex])<0)
				swap(ar,midIndex,highIndex);
				
			if(lowIndex+3>highIndex)return;       // list of size 2 or 3 is already sorted!
			// set pivot==ar[midIndex] then store pivote at position highIndex-1 during partion 
			Comparable pivot = ar[midIndex];
			swap(ar,midIndex,highIndex-1);
			
			//do the partition: move elements  <= pivot to the left and element >= pivot to the right
			int left= lowIndex;
			int right= highIndex-1;
			while(true)
			{
				while( ar[++left].compareTo(pivot)<0)   //gets stuck when ar[left]>=pivot
					;
				while(pivot.compareTo(ar[--right])<0)    // gets stuck when ar[right]<=pivot
					;
				if (left>=right) break;                  // if they crossed, left is the cutpoint
				swap(ar,left,right);                     // else swap to unstick left and right
			}
			// restore pivot to " middle" of partitioned array
			swap(ar,left,highIndex-1);
			quickSort(ar,lowIndex, left-1);              // these elements are all<=pivot
			quickSort(ar,left+1,highIndex);              // these elements are all>=pivot
    }
}