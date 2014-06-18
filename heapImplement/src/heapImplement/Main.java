package heapImplement;

public class Main {
	public static void main(String[] args){
		int[] heap = {3,2,1,0,5};
		for(int i = heap.length-1; i > 0; i--){
			int parent = (i-1)/2;
			swap(heap, i, parent);
		}
		for(int i = 0; i < heap.length; i++){
			System.out.println(heap[i]);
		}
	}
	public static void swap(int[]heap, int i, int parent){
		if(heap[i] >= heap[parent]){
			int temp = heap[i];
			heap[i] = heap[parent];
			heap[parent] = temp;
		}
		return;
	}
	
}
