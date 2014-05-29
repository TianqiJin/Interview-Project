
public class Main {
	public static void main(String[] args){
		Linklist ll = new Linklist();
		ll.add(3);
		ll.add(4);
		ll.add(5);
		ll.add(6);
		ll.add(3);
		removeDuplicate(ll);
		//ll.removeIndex(4);
		ll.output();
	}
	public static void removeDuplicate(Linklist ll){
		Node first = ll.head;
		Node temp = first.next;
		int initial = 2;
		while(first.next != null){
			for(int i = initial; i <= ll.count; i++){
				if(temp.element == first.element){
					ll.removeIndex(i);
					//ll.output();
				}
					
				if(temp.next != null)
					temp = temp.next;
			}
			first = first.next;
			temp = first.next;
			initial++;
		}
		
	}
}
