package algorithm;

public class SelectionSort {

	public int[] selectionSort(int[] toSort){
		int[] sorted = toSort;
		for(int i = 0; i < sorted.length; i++){
			int smallestIndex = i;
			for(int j = i+1; j < sorted.length; j++){
				if(sorted[j] < sorted[smallestIndex]){
					smallestIndex = j;
				}
			}
			//Swap smallest and i positions
			int temp = sorted[i];
			sorted[i] = sorted[smallestIndex];
			sorted[smallestIndex] = temp;
		}
		return sorted;
	}
}
