
public class Main {
	public static void main(String[] args){
		int[] array = {6,7,8,1,2,3,4,5};
		int element = 3;
		int position;
		int point = sepratePoint(array, 0, array.length-1);
		if(array[point + 1] <= element && element <= array[array.length - 1])
			position = findElement(array, point+1, array.length-1,element);
		else if(array[point -1] >= element && element >= array[0])
			position = findElement(array, 0, point-1,element);
		System.out.println(point);
	}
	public static int sepratePoint(int[] array, int low, int high){
		int middle = (low+high)/2;
		if(middle - low == 1 || high - middle == 1){
			if(middle - low == 1 && high - middle == 1)
				return middle;
			else if(middle - low == 1 && array[middle+1] < array[high])
				return middle;
			else if(high - middle ==1 && array[low] < array[middle-1])
				return middle;
		}
		else if(array[low] < array[middle-1] && array[high] > array[middle+1])
			return middle;
		else{
			if(array[middle - 1] < array[low])
				return sepratePoint(array, low, middle-1);
			else if(array[middle + 1] > array[high])
				return sepratePoint(array, middle+1, high);
		}
		return -1;
	}
	
}
