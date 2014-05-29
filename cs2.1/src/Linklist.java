
public class Linklist {
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
	}
	
	public void remove(int data){
		if(head.element == data){
			head = head.next;
			count--;
			return;
		}
		else{
			temp = head;
			while(temp.next != null){
				if(temp.next.element == data){
					temp.next = temp.next.next;
					count--;
					return;
				}
				temp = temp.next;
			}
		}
	}
	
	public void removeIndex(int index){
		if(index == 0){
			head = head.next;
			return;
		}
		else{
			temp = head;
			for(int i = 1; i < index - 1; i++){
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
