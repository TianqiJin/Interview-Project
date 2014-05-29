import java.util.*;

public class Main {
	public static void main(String[] args){
		Stacks stacks = new Stacks();
		for(int i = 0 ; i < 6; i++ )
			stacks.push(i);
		stacks.pop();
		stacks.pop();
		stacks.pop();
		stacks.pop();
		stacks.push(10);
		stacks.pop();
	}
	
}


class Node{
	Node next;
	int element;
	Node(int data){
		this.element = data;
	}
}

class Stack{
	Node head;
	Node temp;
	int count = 0;
	
	public void push(int data){
		temp = new Node(data);
		temp.next = head;
		head = temp;
		count++;
	}
	
	public void pop(){
		if(head != null){
			System.out.println(head.element);
			head = head.next;
			count--;
		}
	}
	
	public boolean isEmpty(){
		if(count > 0)
			return false;
		else
			return true;
	}
}

class Stacks{
	ArrayList<Stack> stacks = new ArrayList<Stack>();
	int limit = 3;
	
	public void push(int data){
		if(stacks.isEmpty()){
			stacks.add(new Stack());
			stacks.get(stacks.size()-1).push(data);
		}
		else if(stacks.get(stacks.size()-1).count != limit)
			stacks.get(stacks.size()-1).push(data);
		else{
			stacks.add(new Stack());
			stacks.get(stacks.size()-1).push(data);
		}
	}
	
	public void pop(){
		if(stacks.isEmpty())
			System.out.println("Nothing in the stacks");
		else{
			for(int i = stacks.size()-1; i >= 0; i--){
				if(!stacks.get(i).isEmpty()){
					stacks.get(i).pop();
					break;
				}
			}
		}
	}
}