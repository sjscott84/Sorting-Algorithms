package algorithm;

public class QuickSort {
	
	int [] array;
	//Quick Sort Methods (4 in total including a helper method swap)
	public int[] quickSortSetup(int[] arrayToSort){
		array = arrayToSort;
		quickSort(0, arrayToSort.length - 1);
		return array;
	}
	
	//Deterministic quick sort
	public void quickSort(int lowIndex, int highIndex){
		if(lowIndex < highIndex){
			int partition = partition(lowIndex, highIndex);
			quickSort(lowIndex, partition - 1);
			quickSort(partition + 1, highIndex);
		}
	}
	
	public int partition(int lowIndex, int highIndex){
		int p = lowIndex;
		for(int i = lowIndex; i < highIndex; i++){
			if(this.array[i] < this.array[highIndex]){
				swap(p, i);
				p++;
			}
		}
		swap(p, highIndex);
		return p;
	}

	
	//Helper method
	public void swap(int first, int second){
		int temp = this.array[first];
		this.array[first] = this.array[second];
		this.array[second] = temp;
	}

}
