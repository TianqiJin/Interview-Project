package cs_BinarySearchTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class Main {
	
	public static void main(String[] args){
		Tree tree = new Tree();
		tree.root = new Node(-1);
		tree.root.left = new Node(0);
		tree.root.right = new Node(1);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		tree.postOrderTraversal(tree.root, map);
		System.out.println(tree.max);
		
	}
}

class Node{
	
	Node left;
	Node right;
	int val;
	Node(int data){
		this.val = data;
	}
}

class Tree{
	static int max = Integer.MIN_VALUE;
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
				if(data < focus.val){
					focus = focus.left;
					if(focus == null){
						parent.left = new Node(data);
						return;
					}
				}
				else{
					focus = focus.right;
					if(focus == null){
						parent.right = new Node(data);
						return;
					}
				}
			}
		}
	}
	
	public boolean searchTree(Node node, int target){
		boolean result = false;
		if(node != null){
			if(node.val == target)
				return true;
			result = searchTree(node.left, target);
			if(result == false)
				result = searchTree(node.right, target);
		    return result;
			
		}
		return false;
	}
	
	public void preOrderTraversal(Node node){
		Stack<Node> stack = new Stack<Node>();
		while(node != null){
			stack.push(node);
			System.out.println(node.val);
			node = node.left;
		}
		while(!stack.isEmpty()){
			node = stack.pop();
			if(node.right != null){
				node = node.right;
				while(node != null){
					stack.push(node);
					System.out.println(node.val);
					node = node.left;
				}
			}
		}
	}
	public void inOrderTraversal(Node node){
		Stack<Node> stack = new Stack<Node>();
		while(node != null){
			stack.push(node);
			node = node.left;
		}
		while(!stack.isEmpty()){
			node = stack.pop();
			System.out.println(node.val);
			if(node.right != null){
				node = node.right;
				while(node != null){
					stack.push(node);
					node = node.left;
				}
			}
		}
	}
	public void postOrderTraversal(Node root, Map<Integer, Integer>map){
        if(root != null){
            postOrderTraversal(root.left, map);
            postOrderTraversal(root.right, map);
            if(root.left == null && root.right == null){
                map.put(root.val, root.val);
                if(max < (int)map.get(root.val))
                    max = (int)map.get(root.val);
            }
                
            else if(root.left == null && root.right != null){
                int rightValue = (int)map.get(root.right.val);
                map.put(root.val, Math.max(root.val, root.val+rightValue));
                if(max < (int)map.get(root.val))
                    max = (int)map.get(root.val);
            }
            else if(root.left != null && root.right == null){
                int leftValue = (int)map.get(root.left.val);
                map.put(root.val, Math.max(root.val, root.val+leftValue));
                if(max < (int)map.get(root.val))
                    max = (int)map.get(root.val);
            }
            else{
            	System.out.println(max);
                int leftValue = (int)map.get(root.left.val);
                int rightValue = (int)map.get(root.right.val);
                map.put(root.val, Math.max(root.val, Math.max(root.val+leftValue, root.val+rightValue)));
                
                if(max < Math.max(root.val+rightValue+leftValue, Math.max(root.val, Math.max(root.val+leftValue, root.val+rightValue))))
                   max = Math.max(root.val+rightValue+leftValue, Math.max(root.val, Math.max(root.val+leftValue, root.val+rightValue)));
                 System.out.println(max);
            }
            //System.out.println(max);
        }
        
        return;
    }
}