import java.util.ArrayList;


public class Main {
	public static void main(String[] args){
		ArrayList array = new ArrayList();
		for(int i = 1; i <= 7; i++)
			array.add(i);
		Tree tree= new Tree();
		//System.out.println(array.size() / 2);
		createMinimalHeight(tree, array);
		tree.inorderTraversal(tree.root);
	}
	public static void createMinimalHeight(Tree tree, ArrayList array){
		if(array.size() == 1){
			tree.add((int)array.get(0));
			return;
		}
		ArrayList arrayLeft = new ArrayList();
		ArrayList arrayRight = new ArrayList();
		for(int i = 0; i < array.size()/2; i++){
			
			arrayLeft.add(array.get(i));
		}
			
		for(int i = array.size()/2 + 1; i < array.size(); i++){
			arrayRight.add(array.get(i));
		}
			
		tree.add((int)array.get(array.size()/2));
		createMinimalHeight(tree, arrayLeft);
		createMinimalHeight(tree, arrayRight);
			
			
		
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
	Node focus;
	Node parent;
	
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
	public void inorderTraversal(Node rootNode){
		if(rootNode != null){
			inorderTraversal(rootNode.leftChild);
			System.out.println(rootNode.element);
			inorderTraversal(rootNode.rightChild);
		}
	}
	
}