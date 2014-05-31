package cs_DoublyLinkedList;
import java.util.*;

public class Main {
	public static void main(String[] args){
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.add(3);
		dll.add(4);
		dll.add(5);
		dll.output();
		dll.outputReverse();
	}
}

class Node{
	Node next;
	Node prev;
	int element;
	Node(int data){
		this.element = data;
	}
}

class DoublyLinkedList{
	Node head;
	Node tail;
	Node temp;
	
	public void add(int data){
		Node newNode = new Node(data);
		if(head == null){
			
			head = newNode;		
			tail = head;		
			System.out.println(head.next);
			
		}
		else{
			tail.next = newNode;
			System.out.println(head.next);
			newNode.prev = tail;
			tail = tail.next;
			//System.out.println(tail.prev);
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
	public void outputReverse(){
		temp = tail;
		while(temp.prev != null){
			System.out.println(temp.element);
			temp = temp.prev;
		}
		System.out.println(temp.element);
	}
}