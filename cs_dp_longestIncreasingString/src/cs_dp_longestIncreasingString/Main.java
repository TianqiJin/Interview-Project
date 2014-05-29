package cs_dp_longestIncreasingString;

public class Main {
	public static void main(String[] args){
		int[] array = {1,2,5,3,4,7,8};
		int[] result = longestIncreasingString(array);
		int max = 0;
		for(int i = 0; i < result.length; i++){
			if(max < result[i])
				max = result[i];
		}
		System.out.println(max);
	}
	public static int[] longestIncreasingString(int[] array){
		int[] temp = new int[array.length];
		for(int i = 0; i < array.length; i++){
			temp[i] = 1;
		}
		for(int i = 1; i < array.length; i++){
			if(array[i] > array[i-1])
				temp[i] = temp[i-1] +1;
		}
		return temp;
	}
}
