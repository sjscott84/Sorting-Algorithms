package algorithm;

public class InsertionSort {

	public int[] insertionSort (int[] toSort){
		int[] sorted = toSort;
		int current;
		for(int i = 1; i < toSort.length; i++){
			current = i;
			while(current > 0 && sorted[current] < sorted[current - 1]){
				int temp = sorted[current];
				sorted[current] = sorted[current - 1];
				sorted[current - 1] = temp;
				current = current - 1;
			}
		}
		return sorted;
	}
}
