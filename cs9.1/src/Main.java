
public class Main {
	public static void main(String[] args){
		int[] A = new int[5];
		int[] B = new int[2];
		int aBegin = 0;
		int bBegin = 0;
		int[] temp = new int[A.length];
		int tBegin = 0;
		while(aBegin < A.length && bBegin < B.length){
			if(A[aBegin] <= B[bBegin])
				temp[tBegin++] = A[aBegin++];
			else
				temp[tBegin++] = B[bBegin++];
		}
		while(aBegin < A.length)
			temp[tBegin++] = A[aBegin++];
		while(bBegin < B.length)
			temp[tBegin++] = B[bBegin++];
		for(int i = 0; i < temp.length; i++)
			A[i] = temp[i];
	}
}
