package cs_BFS;

public class Main {
	public static void main(String[] args){
		Queue queue = new Queue();
	}
}


class Node{
	Node rightChild;
	Node leftChild;
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
	
	public void enqueue(Node node){
		if(head == null){
			head = node;
			tail = head;
		}
		else{
			tail.next = node;
			tail = tail.next;
		}
	}
	
	public Node dequeue(){
		if(head != null){
			temp = head;
			head = head.next;
			return temp;
		}
		return null;
	}
}