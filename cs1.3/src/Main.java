public class  Main{
	public static void main(String[] args){
		char[] testArray = {'b','b','a','c','c','d','e'};
		testArray = removeDuplicate(testArray);
		for(int i = 0; i < testArray.length; i++)
			System.out.println(testArray[i]);
	}
	public static char[] removeDuplicate(char[] string){
		int m;
		for(int i = 0; i < string.length; i++){
			for (int j = i+1; j < string.length; j++){
					if(string[i] == string[j]){
						if(j != string.length-1){
							for(m = j+1; m < string.length; m++){
								if(string[m] != string[j])
									break;
							}
							if(m == string.length){
								for(int n = j; n < string.length; n++)
									string[n] = ' ';
								return string;
							}
							string[j] = string[m];
							j = m;
						}
						else{
							if(string[i] == string[j]){
								string[j] = ' ';
							}
					}
				
				
				}
				
			}
		}
		return string;
		
	}
}