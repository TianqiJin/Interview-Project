package cs_dp_minimumChanges;

public class Main {
	public static void main(String[] args){
		int[] coinArray = {1,3,5};
		int sum = 11;
		minimumChanges(coinArray, sum);
	}
	public static void minimumChanges(int[] coinArray, int sum){
		int[] temp = new int[sum + 1];
		temp[0] = 0;
		for(int i = 1; i < temp.length; i++)
			temp[i] = Integer.MAX_VALUE;
		for(int i = 1; i < temp.length; i++){
			for(int j = 0; j < coinArray.length; j++){
				if(i >= coinArray[j] && temp[i] > temp[i-coinArray[j]])
					temp[i] = temp[i-coinArray[j]] + 1;
			}
		}
		System.out.println(temp[sum]);
	}
}
