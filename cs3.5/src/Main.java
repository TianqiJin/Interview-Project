
public class Main {
	public static void main(String[] args){
		myQueue queue = new myQueue();
		for(int i = 0; i < 6; i++)
			queue.enqueue(i);
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
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
	int count;
	
	public void push(int data){
		temp = new Node(data);
		temp.next = head;
		head = temp;
		count++;
	}
	
	public Node pop(){
		if(head != null){
			temp = head;
			head = head.next;
			count--;
			return temp;
		}
		else
			return null;
	}
	
	public boolean isEmpty(){
		if(count > 0)
			return false;
		else
			return true;
	}
			
}


class myQueue{
	Stack stack1 = new Stack();
	Stack stack2 = new Stack();
	int limit = 3;
	
	public void enqueue(int data){
		if(stack1.count == limit){
			while(!stack1.isEmpty())
				stack2.push(stack1.pop().element);
			stack1.push(data);
		}
		else
			stack1.push(data);
	}
	
	public void dequeue(){
		if(!stack2.isEmpty())
			System.out.println(stack2.pop().element);
		else{
			if(!stack1.isEmpty()){
				while(!stack1.isEmpty())
					stack2.push(stack1.pop().element);
				System.out.println(stack2.pop().element);
			}
			else
				System.out.println("No data");
		}
	}
	
}