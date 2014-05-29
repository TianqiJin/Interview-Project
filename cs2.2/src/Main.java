public class Main {
	public static void main(String[] args){
		Linkedlist ll = new Linkedlist();
		int n = 5;
		for(int i = 1 ; i <= 10; i++)
			ll.add(i);
		grabNToLast(ll, n);
		
	}
	public static void grabNToLast(Linkedlist ll, int n){
		for(int i = n; i <= ll.count; i++)
			ll.get(i);
	}

}



