package algorithm;

import java.util.Arrays;

public class AlgorithmTest {
	
	public int[] array;
	public int[] tempArray;
	public static int arrayLength = 20;
	
	public AlgorithmTest(){
		array = new int[arrayLength];
	}
	
	//Build a random array
	public int[] buildArray(){
		int[] newArray = new int[arrayLength];
		for(int i = 0; i < arrayLength; i++){
			int random = (int )(Math.random() * arrayLength + 1);
			newArray[i] = random;
		}
		return newArray;
	}
	
	//Build a worst case array (sorted back to front) for benchmarking
	public int[] buildWorstArray(){
		int[] newArray = new int[arrayLength];
		int value = arrayLength;
		for(int i = 0; i < arrayLength; i++){
			newArray[i] = value;
			value--;
		}
		return newArray;
	}
	
	//Selection sort method
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
	
	//Insertion Sort Method
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

	//Merge sort methods (3 in total)
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
	
	//Quick Sort Methods (4 in total including a helper method swap)
	public void quickSortSetup(int[] arrayToSort, boolean random){
		this.array = arrayToSort;
		if(!random){
			quickSort(0, arrayToSort.length - 1);
		}else{
			randomQuickSort(0, arrayToSort.length - 1);
		}
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
	
	//Random quick sort
	public void randomQuickSort(int lowIndex, int highIndex){
		if(lowIndex < highIndex){
			int partition = randomPartition(lowIndex, highIndex);
			randomQuickSort(lowIndex, partition - 1);
			randomQuickSort(partition + 1, highIndex);
		}
	}
	
	public int randomPartition(int lowIndex, int highIndex){
		int p = lowIndex;
		int random = (int )(Math.random() * (highIndex-lowIndex) + lowIndex);
		int pivotValue = this.array[random];
		swap(random, highIndex);
		for(int i = lowIndex; i < highIndex; i++){
			if(this.array[i] < pivotValue){
				swap(p, i);
				p++;
			}
		}
		swap(highIndex, p);
		return p;
	}
	
	//Helper method
	public void swap(int first, int second){
		int temp = this.array[first];
		this.array[first] = this.array[second];
		this.array[second] = temp;
	}
	
	private int[] countingSort (int[] input, int highNum){
		//Initilase a new array with all elements being 0
		int[] count = new int [highNum + 1];
		int[] result = new int[highNum];
		for (int i=0; i<highNum; i++){
            count[i] = 0;
		};
		
		//Store a count of each value in the input array
		for (int i = 0; i < input.length; i++){
			int x = count[input[i]];
			x++;
			count[input[i]] = x;
		}
		
		//Count all values together
		for(int i = 1; i < count.length; i++){
			count[i] = count[i] + count[i-1];
		}
		
		//update result
		for(int i = 0; i < input.length; i++){
			result[count[input[i]]-1] = input[i];
			count[input[i]]--;
		}
		
		return result;
	}
	
	private void benchmark(){
		//AlgorithmTest test = new AlgorithmTest();
		int count = 0;
		float totalTime = 0;
		while(count < 100){
			//int[] testArray = buildArray();
			int[] testArray = buildWorstArray();
			//System.out.println("Original "+Arrays.toString(testArray));
			long startTime = System.nanoTime();
			//selectionSort(testArray);
			//insertionSort(testArray);
			//mergeSortSetup(testArray);
			////Deterministic Quick Sort
			quickSortSetup(testArray, false);
			////Randomized Quick Sort
			//quickSortSetup(testArray, true);
			long endTime = System.nanoTime();
			//System.out.println("Sorted "+Arrays.toString(testArray));
			float estTime = (endTime - startTime)/1000000000f;
			totalTime = totalTime + estTime;
			count++;
		}
		System.out.println(totalTime/count);
	}
	
	public static void main(String[] args){
		AlgorithmTest test = new AlgorithmTest();
		int[] testArray = test.buildArray();
		System.out.println("Original "+Arrays.toString(testArray));
		//test.selectionSort(testArray);
		//test.insertionSort(testArray);
		//test.mergeSortSetup(testArray);
		////Deterministic Quick Sort
		//test.quickSortSetup(testArray, false);
		////Randomized Quick Sort
		//test.quickSortSetup(testArray, true);
		testArray = test.countingSort(testArray, arrayLength);
		System.out.println("Sorted "+Arrays.toString(testArray));
		//test.benchmark();
	}

}
