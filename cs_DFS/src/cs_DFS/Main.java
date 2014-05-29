package cs_DFS;

public class Main{
	public static void main(String[] args){
		Tree tree = new Tree();
		tree.add(5);
		tree.add(3);
		tree.add(1);
		tree.add(6);
		tree.add(7);

		
		DFS(tree.root);
	}
	public static void DFS(Node root){
		Stack stack = new Stack();
		Node temp;
		if(root != null){
			root.visited = true;
			System.out.println(root.element);
			stack.push(root);
		}
		temp = root;
		while(!stack.isEmpty()){
			if(temp.leftChild != null || temp.rightChild != null){
				if(temp.leftChild != null && !temp.leftChild.visited){
					temp.leftChild.visited = true;
					//System.out.println("!!!!!!!!!!!!");
					System.out.println(temp.leftChild.element);
					stack.push(temp.leftChild);
					temp = stack.peek();
				}
					
				else if(temp.rightChild != null && !temp.rightChild.visited){
					temp.rightChild.visited = true;
					//System.out.println("@@@@@@@@@@@@@");
					System.out.println(temp.rightChild.element);
					stack.push(temp.rightChild);
					temp = stack.peek();
				}
				else{
					stack.pop();
					temp = stack.peek();
					//System.out.println("##############");
				}
				
			}
			else{
				stack.pop();
				temp = stack.peek();
			}
			
		}
	}
}

class Node{
	Node next;
	Node leftChild;
	Node rightChild;
	boolean visited;
	int element;
	Node(int data){
		this.element = data;
	}
}



class Stack{
	Node head;
	Node temp;
	public void push(Node node){
		if(head == null)
			head = node;
		else{
			temp = node;
			temp.next = head;
			head = temp;
		}
	}
	public void pop(){
		if(head != null){
			temp = head;
			head = head.next;
			return;
		}
		return;
	}
	public boolean isEmpty(){
		if(head == null)
			return true;
		return false;
	}
	public Node peek(){
		return head;
	}
}

class Tree{
	Node root;
	Node parent;
	Node focus;
	
	public void add(int data){
		if(root == null){
			root = new Node(data);
			return;
		}
		else{
			focus = root;
			while(true){
				parent = focus;
				if(data < focus.element){
					focus = focus.leftChild;
					if(focus == null){
						parent.leftChild = new Node(data);
						return;
					}
				}
				else{
					focus = focus.rightChild;
					if(focus == null){
						parent.rightChild = new Node(data);
						return;
					}	
				}
			}
		}
	}
	
}
