package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;

public class Sort<T extends Comparable<T>> implements ISort<T> {

	@Override
	public IHeap<T> heapSort(ArrayList<T> unordered) {
		// TODO Auto-generated method stub
		return null;
	}

	public void sortSlow(ArrayList<T> unordered) {
		if(unordered==null || unordered.isEmpty())return;
		for(int i=0;i<unordered.size()-1;i++){
			for(int j=0;j<unordered.size()-1-i;j++){
				int comp=unordered.get(j).compareTo(unordered.get(j+1));
				if(comp>0){
					T temp=unordered.get(j);
					unordered.set(j,unordered.get(j+1));
					unordered.set(j+1,temp);
				}
			}
		}
	}

	@Override
	public void sortFast(ArrayList<T> unordered) {
		if(unordered==null || unordered.isEmpty())return;
		mergeSort(unordered,0,unordered.size()-1);
	}
		public void merge(ArrayList<T> unordered, int l, int m, int r)
		{
			int i, j, k;
			int n1 = m - l + 1;
			int n2 =  r - m;

			/* create temp arrays */
			ArrayList<T>L=new ArrayList<T>(n1);
			ArrayList<T>R=new ArrayList<T>(n2);

			/* Copy data to temp arrays L[] and R[] */
			for (i = 0; i < n1; i++)
				L.add(unordered.get(l + i));
			for (j = 0; j < n2; j++)
				R.add(unordered.get(m + 1+ j));

			/* Merge the temp arrays back into arr[l..r]*/
			i = 0; // Initial index of first subarray
			j = 0; // Initial index of second subarray
			k = l; // Initial index of merged subarray
			while (i < n1 && j < n2)
			{

				int comp=L.get(i).compareTo(R.get(j));
				if (comp<=0)
				{
					unordered.set(k,L.get(i)) ;
					i++;
				}
				else
				{
					unordered.set(k,R.get(j)) ;
					j++;
				}
				k++;
			}

		/* Copy the remaining elements of L[], if there
		   are any */
			while (i < n1)
			{
				unordered.set(k,L.get(i)) ;
				i++;
				k++;
			}

		/* Copy the remaining elements of R[], if there
		   are any */
			while (j < n2)
			{
				unordered.set(k,R.get(j)) ;
				j++;
				k++;
			}
		}

	/* l is for left index and r is right index of the
       sub-array of arr to be sorted */
	void mergeSort(ArrayList<T> unordered, int l, int r)
	{
		if (l < r)
		{
			// Same as (l+r)/2, but avoids overflow for
			// large l and h
			int m = l+(r-l)/2;

			// Sort first and second halves
			mergeSort(unordered, l, m);
			mergeSort(unordered, m+1, r);

			merge(unordered, l, m, r);
		}
	}

}
