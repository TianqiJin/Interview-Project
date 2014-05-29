import java.util.*;

public class Main {
	public static void main(String[] args){
		Tree tree = new Tree();
		Stack stack = new Stack();
		tree.insert(3);
		tree.insert(2);
		tree.insert(1);
		//tree.insert(0);
		//tree.insert(5);
		balanceOrNot(tree.root,stack);
	}
	
	public static void balanceOrNot(Node root, Stack stack){
		Node temp;
		ArrayList<Integer> al =new ArrayList<Integer>();
		if(root != null){
			root.visited = true;
			System.out.println(root.element);
			stack.push(root);
			temp = root;
			while(!stack.isEmpty()){
				if(temp.leftChild != null || temp.rightChild != null){
					if(temp.leftChild != null && !temp.leftChild.visited){
						temp.leftChild.visited = true;
						System.out.println(temp.leftChild.element);
						stack.push(temp.leftChild);
					}
					else if(temp.rightChild != null && !temp.rightChild.visited){
						temp.rightChild.visited = true;
						System.out.println(temp.rightChild.element);
						stack.push(temp.rightChild);
					}
					else{
						stack.pop();
					}
					temp = stack.peek();
				}
				else{
					al.add(stack.count);
					stack.pop();
					temp = stack.peek();
				}
			}
			if(al.size() == 1){
				if(al.get(0) > 1){
					System.out.println("Unbalanced");
					return;
				}
			}
			for(int i = 0; i < al.size()-1; i++){
				for(int j = i+1; j < al.size(); j++){
					if(Math.abs(al.get(i)-al.get(j)) > 1){
						System.out.println("Unbalanced");
						return;
					}
				}
			}
			System.out.println("Balanced");
		}
	}
}


class Node{
	Node leftChild;
	Node rightChild;
	Node next;
	int element;
	boolean visited;
	Node(int data){
		this.element = data;
	}
}

class Stack{
	Node head;
	Node temp;
	int count;
	public void push(Node node){
		temp = node;
		temp.next = head;
		head = temp;
		count++;
	}
	public void pop(){
		if(head != null){
			head = head.next;
			count--;
			return;
		}
	}
	public Node peek(){
		if(head != null)
			return head;
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
	Node parent;
	Node focus;
	
	public void insert(int data){
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