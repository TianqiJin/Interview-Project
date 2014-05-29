package cs_SortingAlgorithm;

public class Main {
	public static void main(String[] args){
		int[] array = {49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,56,54,56,17,18,23,34,15,35,25,53,51};
		//BucketSort(array);
		//QuickSort(array, 0, array.length-1);
		//BubbleSort(array); 
		MergeSort(array, 0, array.length-1);
		printArray(array);
		
	}
	public static void BucketSort(int[] array){
		int maxValue = 99;
		int[] bucket = new int[maxValue+1];
		int position = 0;
		for(int i = 0; i < array.length; i++)
			bucket[array[i]]++;
		for(int i = 0; i < bucket.length; i++){
			for(int j = 0; j < bucket[i]; j++)
				array[position++] = i;
		}
	}
	public static void BubbleSort(int[] array){
		int temp;
		for(int i = array.length; i > 0; i--){
			for(int j = 0; j < i-1; j++){
				if(array[j+1] < array[j]){
					temp = array[j+1];
					array[j+1] = array[j];
					array[j] = temp;
				}
			}
		}
	}
	

	
//	public static void QuickSort(int[] array, int low, int high){
//		if(low < high){
//			int middle = getMiddle(array, low, high);
//			QuickSort(array, low, middle-1);
//			QuickSort(array, middle+1, high);
//		}
//	}
//	public static int getMiddle(int[] array, int low, int high){
//		int key = array[low];
//		while(low < high){
//			while(low < high && array[high] >= key)
//				high--;
//			array[low] = array[high];
//			while(low < high && array[low] <= key)
//				low++;
//			array[high] = array[low];
//		}
//		array[low] = key;
//		return low;
//	}
	public static void MergeSort(int[] array, int left, int right){
		if(left < right){
			int center = (left + right)/2;
			MergeSort(array, left, center);
			MergeSort(array, center+1, right);
			merge(array, left, center, right);
		}
	}
	public static void merge(int[] array, int low, int center, int right){
		int[] temp = new int[array.length];
		int tmp = low;
		int rightBegin = center+1;
		int begin = low;
		while(low <= center && rightBegin <= right){
			if(array[low] <= array[rightBegin])
				temp[tmp++] = array[low++];
			else
				temp[tmp++] = array[rightBegin++];
		}
		while(low <= center){
			temp[tmp++] = array[low++];
		}
		while(rightBegin <= right)
			temp[tmp++] = array[rightBegin++];
		
		while(begin <= right){
			array[begin] = temp[begin];
			begin++;
		}
			
	}
//	public static void merge(int[] array, int left, int center, int right){
//		int[] temp = new int[array.length];
//		int rightBegin = center +1;
//		int tmp = left;
//		int begin = left;
//		while(left <= center && rightBegin <= right){
//			if(array[left] <= array[rightBegin])
//				temp[tmp++] = array[left++];
//			else
//				temp[tmp++] = array[rightBegin++];
//		}
//		while(left <= center)
//			temp[tmp++] = array[left++];
//		while(rightBegin <= right)
//			temp[tmp++] = array[rightBegin++];
//		while(begin <= right){
//			array[begin] = temp[begin];
//			begin++;
//		}
//			
//	}
	public static void printArray(int[] array){
		for(int i = 0; i < array.length; i++)
			System.out.println(array[i]);
	}
}

