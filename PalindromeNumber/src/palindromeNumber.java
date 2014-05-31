
public class palindromeNumber {
	public static void main(String[] args){
		int num = 12;
		IsPalindrome(num);
	}
	public static void IsPalindrome(int num){
		int newNum = 0;
		int tempNum = num;
		int temp;
		while(tempNum != 0){
			temp = tempNum % 10;
			newNum = newNum * 10 + temp;
			tempNum = (tempNum -temp) / 10;
		}
		if (num == newNum)
			System.out.println("True");
		else
			System.out.println("False");
	}
}
