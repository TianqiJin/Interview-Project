package cs_Stack;

public class Main {
	public static void main(String[] args){
		Stack stack = new Stack();
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.pop();
		stack.pop();
	}
}

class Node{
	Node next;
	int element;
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
		head = temp;
	}
	public void pop(){
		if(head != null){
			System.out.println(head.element);
			head = head.next;
		}
	}
}
