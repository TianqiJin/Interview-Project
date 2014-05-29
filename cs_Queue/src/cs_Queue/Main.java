package cs_Queue;

public class Main {
	public static void main(String[] args){
		Queue queue = new Queue();
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.dequeue();
	}
}

class Node{
	Node next;
	int element;
	Node(int data){
		this.element = data;
	}
}

class Queue{
	Node head;
	Node tail;
	Node temp;
	
	public void enqueue(int data){
		if(head == null){
			head = new Node(data);
			tail = head;
		}
		else{
			tail.next = new Node(data);
			tail = tail.next;
		}
	}
	
	public void dequeue(){
		if(head != null){
			System.out.println(head.element);
			head = head.next;
		}
	}
}