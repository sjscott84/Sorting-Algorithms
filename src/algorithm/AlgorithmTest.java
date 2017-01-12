package algorithm;

import java.util.Arrays;

public class AlgorithmTest {
	
	public int[] array;
	public int[] tempArray;
	public int arrayLength = 10;
	
	public AlgorithmTest(){
		array = new int[arrayLength];
	}
	
	public int[] buildArray(){
		int[] newArray = new int[arrayLength];
		for(int i = 0; i < arrayLength; i++){
			int random = (int )(Math.random() * arrayLength + 1);
			newArray[i] = random;
		}
		return newArray;
	}
	
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

	//Save the array to be sorted and create a temporary array
	public void mergeSortSetup(int[] arrayToSort){
		this.array = arrayToSort;
		this.tempArray = new int[arrayToSort.length];
		//First call to merge sort
		mergeSort(0, arrayToSort.length-1);
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
	
	public static void main(String[] args){
		AlgorithmTest test = new AlgorithmTest();
		int[] testArray = test.buildArray();
		System.out.println("Original "+Arrays.toString(testArray));
		test.selectionSort(testArray);
		//test.insertionSort(testArray);
		//test.mergeSortSetup(testArray);
		System.out.println("Sorted "+Arrays.toString(testArray));
	}

}
