
public class Main {
	public static void main(String[] args){
		LinkedList ll = new LinkedList();
		for(int i = 0; i < 1; i++)
			ll.add(i);
		ll.deleteMiddle();
		ll.output();
	}
}


class Node{
	Node next;
	int element;
	Node(int data){
		this.element = data;
	}
}

class LinkedList{
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
		}
		else{
			tail.next = new Node(data);
			tail = tail.next;
			count++;
		}
		return;
	}
	
	public void deleteMiddle(){
		int middle = Math.round(count/2);
		//System.out.println(middle);
		if(middle == 1 || middle == 0){
			head = head.next;
			return;
		}
		else{
			temp = head;
			for(int i = 1; i < middle - 1; i++){
				temp = temp.next;
			}
			temp.next = temp.next.next;
			return;
		}
	}
	
	public void output(){
		temp = head;
		while(temp.next != null){
			System.out.println(temp.element);
			temp = temp.next;
		}
		System.out.println(temp.element);
	}
}