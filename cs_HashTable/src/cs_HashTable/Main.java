package cs_HashTable;

public class Main {
	public static void main(String[] args){
		HashTable ht = new HashTable();
		ht.put(5, 11);
		ht.put(5, 12);
		System.out.println(ht.get(5));
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
	Node temp;
	Node tail;
	public void add(int data){
		if(head == null){
			head = new Node(data);
			tail = head;
			return;
		}
		else{
			tail.next = new Node(data);
			tail = tail.next;
			return;
		}
	}
}

class HashTable{
	LinkedList[] ll = new LinkedList[128];
	public void put(int key, int value){
		int hash = key % 128;
		if(ll[hash] == null){
			ll[hash] = new LinkedList();
		}
			
		ll[hash].add(value);
		return;
	}
	public int get(int key){
		int hash = key % 128;
		if(ll[hash] == null)
			return -1;
		else{
			return ll[hash].tail.element;
		}
	}
}


