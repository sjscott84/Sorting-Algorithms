package algorithm;

public class MergeSort {
	
	public int[] array;
	public int[] tempArray;
	
	//Merge sort methods (3 in total)
	public int[] mergeSortSetup(int[] arrayToSort){
		array = arrayToSort;
		tempArray = new int[arrayToSort.length];
		//First call to merge sort
		mergeSort(0, arrayToSort.length-1);
		return array;
	}
	
	public void mergeSort(int lowIndex, int highIndex){
		//System.out.println(lowIndex+" "+highIndex);
		if(lowIndex < highIndex){
			int middle = lowIndex + (highIndex - lowIndex)/2;
			mergeSort(lowIndex, middle);
			mergeSort(middle+1, highIndex);
			mergeParts(lowIndex, middle, highIndex);
		}	
	}
	
	public void mergeParts(int low, int middle, int high){
		//Add relevant elements from array to tempArray based on low and high
        for (int i = low; i <= high; i++) {
           this.tempArray[i] = this.array[i];
        }
		int i = low;
		int j = middle + 1;
		int k = low;
		while(i <= middle && j <= high){
			if(this.tempArray[i] <= this.tempArray[j]){
				this.array[k] = this.tempArray[i];
				i++;
			}else{
				this.array[k] = this.tempArray[j];
				j++;
			}
			k++;
		}
		while(i <= middle) {
			this.array[k] = this.tempArray[i];
			k++;
			i++;
		}	
	}
}
