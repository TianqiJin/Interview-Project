
public class Main {
	public static void main(String[] args){
		int[] array = {1,2,3};
		findAllSubsets(array);
	}
	public static void findAllSubsets(int[] array){
		double length = 0;
		for(int i = 0; i < array.length; i++)
			length += Math.pow(2, i);
		for(int i = 0; i < (int)length; i++){
			String string = Integer.toBinaryString(i);
			for(int j = 0; j < string.length(); j++){
				if(string.charAt(j) == '1')
					System.out.print(array[j]);
			}
			System.out.println();
		}
	}
}
