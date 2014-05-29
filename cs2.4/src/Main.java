
public class Main {
	public static void main(String[] args){
		int firstNum = 513;
		int secondNum = 295;
		LinkedList firstLL = new LinkedList();
		LinkedList secondLL = new LinkedList();
		LinkedList resultLL = new LinkedList();
		
		int tempResult;
		boolean flag = false;
		while((firstNum % 10) != 0){
			firstLL.add(firstNum % 10);
			firstNum = (firstNum - firstNum % 10) / 10;
		}
		while((secondNum % 10) != 0){
			secondLL.add(secondNum % 10);
			secondNum = (secondNum - secondNum % 10) / 10;
		}
		Node firstTemp = firstLL.head;
		Node secondTemp = secondLL.head;
		
		while(firstTemp != null){
			tempResult = firstTemp.element + secondTemp.element;
			
			if(flag)
				resultLL.add((tempResult + 1) % 10);
			else
				resultLL.add(tempResult % 10);
			if(tempResult >= 10)
				flag = true;
			else
				flag = false;
			if(firstTemp.next != null){
				firstTemp = firstTemp.next;
				secondTemp = secondTemp.next;
			}
			else
				break;
			
		}
		resultLL.output();
	}
}

class Node{
	int element;
	Node next;
	Node(int data){
		this.element = data;
	}
}

class LinkedList{
	Node head;
	Node tail;
	Node temp;
	
	public void add(int data){
		if(head == null){
			head = new Node(data);
			head.next = tail;
			tail = head;
		}
		else{
			tail.next = new Node(data);
			tail = tail.next;
		}
	}
	public void output(){
		temp = head;
		while(temp.next != null){
			System.out.println(temp.element);
			temp = temp.next;
		}
		System.out.println(temp.element);
	}
}