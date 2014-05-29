package cs_dp_ZigZag;

public class Main {
	public static void main(String[] args){
		int[] array = {1, 7, 4, 9, 2, 5};
		findLongestZigZag(array);
	}
	public static void findLongestZigZag(int[] array){
		int[] temp = new int[array.length-1];
		int max = 1;
		int tempResult = 1;
		for(int i = 0; i < array.length-1; i++){
			if(array[i] - array[i+1] > 0)
				temp[i] = 1;
			else if(array[i] - array[i+1] < 0)
				temp[i] = -1;
			else
				temp[i] = 0;
		}
		for(int i = 0; i < temp.length; i++)
			System.out.println(temp[i]);
		for(int i = 0; i < temp.length - 1; i++){
			if(temp[i] != 0){
				if(temp[i] != temp[i+1])
					tempResult++;
				else{
					if(max < tempResult){
						max = tempResult;
						tempResult = 1;
					}
				}
			}
			else{
				if(max < tempResult){
					max = tempResult;
					tempResult = 1;
				}
			}
		}
		if(max < tempResult){
			max = tempResult;
			tempResult = 1;
		}
		System.out.println(max+1);
	}
}
