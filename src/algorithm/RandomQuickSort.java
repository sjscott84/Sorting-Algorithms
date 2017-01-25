package algorithm;

public class RandomQuickSort {
	
	int[] array;
	
	public int[] randomQuick(int[] arrayToSort){
		array = arrayToSort;
		randomQuickSort(0, array.length - 1);
		return array;
	}
	
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

}
