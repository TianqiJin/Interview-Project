
public class Main {
	public static void main(String[] args){
		int n = 3;
		int result = Fibb(n);
		System.out.println(result);
	}
	public static int Fibb(int n){
		if(n == 1 || n == 2)
			return 1;
		else{
			return Fibb(n-1) + Fibb(n-2);
		}
	}
}
