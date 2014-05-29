
public class main {
	public static void main(String[] args){
		String testString = "abcd";
		allUniqueString(testString);
	}
	public static void allUniqueString(String string){
		for(int i = 0; i < string.length(); i++){
			for(int j = i+1; j < string.length(); j++){
				if(string.charAt(i) == string.charAt(j))
					return;
			}
		}
		System.out.println("Found");
	}
}
