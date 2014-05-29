
public class Main {
	public static void main(String[] args){
		char[] testArray = {'a',' ','b',' ',' ','c',' '};
		replaceSpace(testArray);
	}
	
	public static void replaceSpace(char[] testArray){
		int count = 0;
		boolean[] position = new boolean[testArray.length];
		for(int i = 0; i < testArray.length; i++){
			if(testArray[i] == ' '){
				count++;
				position[i] = true;
			}
			else{
				position[i] = false;
			}
				
		}
		char[] newTestArray = new char[testArray.length + count];
		for(int i = 0, j = 0; i < position.length; i++){
			if(position[i] == false)
				newTestArray[j] = testArray[i];
			else{
				newTestArray[j] = '%';
				newTestArray[++j] = '2';
			}
			j++;
		}
		for(int i= 0; i < newTestArray.length; i++)
			System.out.print(newTestArray[i]);
	}
}
