package cs_PostOrderBST_iterally;

public class Main {
	public static void main(String[] args){
		Tree tree = new Tree();
		tree.add(5);
		tree.add(3);
//		tree.add(2);
//		tree.add(1);
//		tree.add(6);
		tree.add(7);
		literallyPostOrder(tree.root);
	}
	public static void literallyPostOrder(TreeNode tnode){
		Stack stack = new Stack();
		if(tnode == null)
			return;
		stack.push(tnode);
		tnode.visited = true;
		while(!stack.isEmpty()){
			if(tnode.leftChild != null || tnode.rightChild != null){
				if(tnode.leftChild != null && !tnode.leftChild.visited){
					tnode.leftChild.visited = true;
					stack.push(tnode.leftChild);
					tnode = stack.peak();
				}
				else if(tnode.rightChild != null && !tnode.rightChild.visited){
					tnode.rightChild.visited = true;
					stack.push(tnode.rightChild);
					tnode = stack.peak();
				}
				else{
					stack.pop();
					tnode = stack.peak();
				}
			}
			else{
				stack.pop();
				tnode = stack.peak();
			}
		}
	}
}

class Node{
	Node next;
	TreeNode current;
}

class Stack{
	Node head;
	Node temp;
	public void push(TreeNode tnode){
		if(head == null){
			head = new Node();
			head.current = tnode;
			return;
		}
		temp = new Node();
		temp.current = tnode;
		temp.next = head;
		head = temp;
		return;
	}
	public void pop(){
		if(head != null){
			System.out.println(head.current.element);
			head = head.next;
		}		
		return;
	}
	public TreeNode peak(){
		if(head != null)
			return head.current;
		return null;
	}
	public boolean isEmpty(){
		if(head == null)
			return true;
		return false;
	}
}

class TreeNode{
	TreeNode leftChild;
	TreeNode rightChild;
	int element;
	boolean visited;
	TreeNode(int data){
		this.element = data;
	}
}

class Tree{
	TreeNode root;
	TreeNode focus;
	TreeNode parent;
	
	public void add(int data){
		if(root == null){
			root = new TreeNode(data);
			return;
		}
		else{
			focus = root;
			while(true){
				parent = focus;
				if(data < focus.element){
					focus = focus.leftChild;
					if(focus == null){
						parent.leftChild = new TreeNode(data);
						return;
					}
				}
				else{
					focus = focus.rightChild;
					if(focus == null){
						parent.rightChild = new TreeNode(data);
						return;
					}
				}
			}
		}
	}
}