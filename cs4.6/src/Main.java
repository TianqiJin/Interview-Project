
public class Main {
	public static void main(String[] args){
		Tree tree = new Tree();
		tree.insert(5);
		tree.insert(2);
		tree.insert(3);
		tree.insert(1);
		tree.insert(6);
		tree.insert(7);
		Node result = tree.find(7, tree.root);
//		if(result != null){
//			while(result != null){
//				System.out.println(result.element);
//				result = result.parent;
//			}
//		}
	}
}

class Node{
	Node leftChild;
	Node rightChild;
	Node parent;
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
						parent.leftChild.parent = parent;
						return;
					}
				}
				else{
					focus = focus.rightChild;
					if(focus == null){
						parent.rightChild = new Node(data);
						parent.rightChild.parent = parent;
						return;
					}
				}
			}
		}
	}
	
	public Node find(int data, Node node){
		Node result = null;
		//System.out.println(node.element);
		if(node == null)
			return null;
		if(node.element == data)
			return node;
		if(node.leftChild != null)
			result = find(data, node.leftChild);
		if(node.rightChild != null)
			result = find(data, node.rightChild);
		//System.out.println(result);
		return result;
	}
}