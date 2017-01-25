package algorithm;

public class CountingSort {
	
	//Counting Sort
	public int[] countingSort (int[] input, int highNum){
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

}
