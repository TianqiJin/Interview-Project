public class Linkedlist {
	Node head;
	Node tail;
	Node temp;
	int count;
	
	public void add(int data){
		if(head == null){
			head = new Node(data);
			head.next = tail;
			tail = head;
			count++;
			return;
		}
		else{
			tail.next = new Node(data);
			tail = tail.next;
			count++;
			return;
		}
	}
	
	public void get(int index){
		if(index == 1){
			System.out.println(head.element);
		}
		else{
			temp = head;
			for(int i = 1; i < index; i++){
				temp = temp.next;
			}
			System.out.println(temp.element);
		}
	}
}
