package cs_BinarySearchTree;


public class Main {
	public static void main(String[] args){
		Tree tree = new Tree();
		tree.insert(3);
		tree.insert(2);
		tree.insert(1);
		tree.inorderTraversal(tree.root);
	}
}

class Node{
	Node leftChild;
	Node rightChild;
	int element;
	Node(int data){
		this.element = data;
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
	
	public void inorderTraversal(Node rootNode){
		if(rootNode != null){
			inorderTraversal(rootNode.leftChild);
			System.out.println(rootNode.element);
			inorderTraversal(rootNode.rightChild);
		}
	}
}