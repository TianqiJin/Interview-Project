
public class Main {
	public static void main(String[] args){
		Stack stack = new Stack();
		stack.push(5);
		stack.push(3);
		stack.push(7);
		stack.push(2);
		stack.push(9);
		stack.min();
	}
}


class Node{
	Node next;
	int element;
	int min;
	Node(int data){
		this.element = data;
		}
}

class Stack{
	Node head;
	Node temp;
	
	public void push(int data){
		temp = new Node(data);
		temp.next = head;
		if(temp.next != null){
			if(temp.element < temp.next.element)
				temp.min = temp.element;
			else
				temp.min = temp.next.min;
		}
		else
			temp.min = temp.element;
		head = temp;
	}
	
	public void pop(){
		temp = head;
		if(temp != null){
			System.out.println(temp.element);
			temp = temp.next;
		}
	}
	
	public void min(){
		System.out.println(head.min);
	}
	
	
}