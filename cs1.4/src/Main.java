import java.util.Arrays;

public class Main {
	public static void main(String[] args){
		char[] testChar = {'a','b','c','d','d'};
		char[] testChar2 = {'b','c','a','d','e'};
		int[] count = new int[256];
		int[] count2 = new int[256];
		for(int i = 0; i < testChar.length-1; i++){
			count[(int)testChar[i]]++;
			for(int j = i+1; j < testChar.length; j++ ){
				if(testChar[i] == testChar[j])
					count[(int)testChar[i]]++;
			}
		}
		for(int i = 0; i < testChar2.length-1; i++){
			count2[(int)testChar2[i]]++;
			for(int j = i+1; j < testChar2.length; j++ ){
				if(testChar2[i] == testChar2[j])
					count2[(int)testChar2[i]]++;
			}
		}
		
		if(testChar.length == testChar2.length){
			if(Arrays.equals(count, count2))
				System.out.println("Found");
		}
		
	}
}
