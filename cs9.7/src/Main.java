
public class Main {
	
	public void print(){
		System.out.println("this is parent class");
	}
	public static void main(String[] args){
		int A= 15;
		int B= 12345;
		 int C = 0;
	        int tempA = 0;
	        int tempB = 0;
	        while(tempA < Integer.toString(A).length() || tempB < Integer.toString(B).length()){
	            C = 10 * C + Integer.parseInt(Integer.toString(A).substring(tempA,tempA+1));
	            C = 10 * C + Integer.parseInt(Integer.toString(B).substring(tempB,tempB+1));
	            tempA++;
	            tempB++;
	        }
	        while(tempA < Integer.toString(A).length()){
	             C = 10 * C + Integer.parseInt(Integer.toString(A).substring(tempA,tempA+1));
	             tempA++;
	        }
	           
	        while(tempB < Integer.toString(B).length()){
	             C = 10 * C + Integer.parseInt(Integer.toString(B).substring(tempB,tempB+1));
	             tempB++;
	        }
	        System.out.println(C);
	           
	}
}

class child extends Main{
	@Override
	public void print(){
		System.out.println("this is child class");
	}
}


