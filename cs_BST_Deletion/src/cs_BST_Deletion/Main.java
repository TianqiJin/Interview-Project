package cs_BST_Deletion;

public class Main {
	public static void main(String[] args){
		Tree tree = new Tree();
		tree.add(5);
		tree.add(4);
		tree.add(3);;
		tree.add(1);
		tree.add(2);
		tree.add(7);
	    tree.add(6);
	    tree.add(8);
	    tree.delete(5);
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
	
	public void delete(int data){
		focus = root;
		while(true){
			if(focus.element == data){
				if(focus.rightChild == null && focus.leftChild == null){
					if(data < parent.element){
						parent.leftChild = null;
						return;
					}
					else{
						parent.rightChild = null;
						return;
					}
				}
				else if(focus.rightChild != null && focus.rightChild != null){
					Node temp = findLargestElementInLeftTree(focus);
					if(temp.rightChild == null){
						focus.element = temp.element;
						if(temp.leftChild == null){
							focus.leftChild = null;
							return;
						}
						else{
							focus.leftChild = temp.leftChild;
							return;
						}
					}
					focus.element = temp.rightChild.element;
					if(temp.rightChild.leftChild == null){
						temp.rightChild = null;
						return;
					}
					else{
						temp.rightChild = temp.rightChild.leftChild;
						return;
					}
				}
				else if(focus.rightChild != null && focus.leftChild == null){
					if(data < parent.element){
						parent.leftChild = focus.rightChild;
						return;
					}
					else{
						parent.rightChild = focus.rightChild;
						return;
					}
				}
				else if(focus.rightChild == null && focus.leftChild != null){
					if(data < parent.element){
						parent.leftChild =focus.leftChild;
						return;
					}
					else{
						parent.rightChild = focus.leftChild;
						return;
					}
				}
			}
			parent = focus;
			if(data < focus.element)
				focus = focus.leftChild;
			else
				focus = focus.rightChild;
		}
	}
	
	public Node findLargestElementInLeftTree(Node node){
		Node temp = node.leftChild;
		if(temp.rightChild == null)
			return temp;
		else{
			while(temp.rightChild.rightChild != null){
				temp = temp.rightChild;
			}
			return temp;
		}
	}
	
	public void inorderTraversal(Node node){
		if(node != null){
			inorderTraversal(node.leftChild);
			System.out.println(node.element);
			inorderTraversal(node.rightChild);
		}
	}
}