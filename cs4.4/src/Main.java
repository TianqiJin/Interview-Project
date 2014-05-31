import java.util.ArrayList;


public class Main {
	public static void main(String[] args){
		Tree tree = new Tree();
		Queue queue = new Queue();
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(0);
		modifiedBFS(tree, queue);
	}
	public static void modifiedBFS(Tree tree, Queue queue){
		Node temp;
		Node temp2;
		ArrayList<LinkedList> al = new ArrayList<LinkedList>();
		if(tree.root != null){
			tree.root.visited = true;
			queue.enqueue(tree.root);
			temp = queue.head;
			al.add(new LinkedList());
			al.get(temp.height - 1).add(temp);
			System.out.println(temp.element);
			while(!queue.isEmpty()){
				if(temp.leftChild != null || temp.rightChild != null){
					if(temp.leftChild != null && !temp.leftChild.visited){
						temp.leftChild.visited = true;
						System.out.println(temp.leftChild.element);
						queue.enqueue(temp.leftChild);
					}
					if(temp.rightChild != null && !temp.rightChild.visited){
						temp.rightChild.visited = true;
						System.out.println(temp.rightChild.element);
						queue.enqueue(temp.rightChild);
					}
					temp2 = queue.dequeue();
					temp = queue.head;
					if(temp2.height != al.get(al.size()-1).head.height){
						al.add(new LinkedList());
						al.get(temp2.height - 1).add(temp2);
					}
					else
						al.get(temp2.height - 1).add(temp2);
				}
				else{
					temp2 = queue.dequeue();
					temp = queue.head;
					if(temp2.height != al.get(al.size()-1).head.height){
						al.add(new LinkedList());
						al.get(temp2.height - 1).add(temp2);
					}
					else
						al.get(temp2.height - 1).add(temp2);
				}
			}
		}
		System.out.println(al.size());
	}
}


class Node{
	Node leftChild;
	Node rightChild;
	Node next;
	int element;
	int height;
	boolean visited;
	Node(int data){
		this.element = data; 
	}
}

class LinkedList{
	Node head;
	Node tail;
	Node temp;
	
	public void add(Node node){
		if(head == null){
			head = node;
			tail = head;
			return;
		}
		else{
			tail.next = node;
			tail = tail.next;
			return;
		}
	}
}
class Queue{
	Node head;
	Node tail;
	Node temp;
	int count;
	
	public void enqueue(Node node){
		if(head == null){
			head = node;
			tail = head;
			count++;
			return;
		}
		else{
			tail.next = node;
			tail = tail.next;
			count++;
			return;
		}
	}
	
	public Node dequeue(){
		if(head != null){
			temp = head;
			head = head.next;
			count--;
			return temp;
		}
		return null;
	}
	
	public boolean isEmpty(){
		if(count > 0)
			return false;
		return true;
	}
}

class Tree{
	Node root;
	Node focus;
	Node parent;
	int count;
	
	public void insert(int data){
		if(root == null){
			root = new Node(data);
			root.height = 1;
			return;
		}
		else{
			focus = root;
			count = 1;
			while(true){
				parent = focus;
				if(data < focus.element){
					focus = focus.leftChild;
					count++;
					if(focus == null){
						parent.leftChild = new Node(data);
						parent.leftChild.height = count;
						return;
					}
				}
				else{
					focus = focus.rightChild;
					count++;
					if(focus == null){
						parent.rightChild = new Node(data);
						parent.rightChild.height = count;
						return;
					}
				}
			}
		}
	}
}