package algorithm;

import java.util.Arrays;

public class AlgorithmTest {
	
	public static int arrayLength = 20;
	
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
	
	public void benchmark(){
		int count = 0;
		float totalTime = 0;
		while(count < 100){
			//int[] testArray = buildArray();
			int[] testArray = buildWorstArray();
			long startTime = System.nanoTime();
			//testArray = countingSort.countingSort(testArray, arrayLength);
			//testArray = selectionSort.selectionSort(testArray);
			//testArray = insertionSort.insertionSort(testArray);
			//testArray = mergeSort.mergeSortSetup(testArray);
			//testArray = randomQuickSort.randomQuick(testArray);
			//testArray = quickSort.quickSortSetup(testArray);
			long endTime = System.nanoTime();
			float estTime = (endTime - startTime)/1000000000f;
			totalTime = totalTime + estTime;
			count++;
		}
		System.out.println(totalTime/count);
	}
	
	public static void main(String[] args){
		AlgorithmTest test = new AlgorithmTest();
		CountingSort countingSort = new CountingSort();
		SelectionSort selectionSort = new SelectionSort();
		InsertionSort insertionSort = new InsertionSort();
		MergeSort mergeSort = new MergeSort();
		RandomQuickSort randomQuickSort = new RandomQuickSort();
		QuickSort quickSort = new QuickSort();
		int[] testArray = test.buildArray();
		System.out.println("Original "+Arrays.toString(testArray));
		//testArray = countingSort.countingSort(testArray, arrayLength);
		//testArray = selectionSort.selectionSort(testArray);
		//testArray = insertionSort.insertionSort(testArray);
		//testArray = mergeSort.mergeSortSetup(testArray);
		//testArray = randomQuickSort.randomQuick(testArray);
		testArray = quickSort.quickSortSetup(testArray);
		System.out.println("Sorted "+Arrays.toString(testArray));
		//test.benchmark();
	}

}
