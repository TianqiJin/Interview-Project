package cs_allSubsetOfSet;
import java.nio.ByteBuffer;
import java.util.*;

public class Main {
	public static void main(String[] args){
		ArrayList list = new ArrayList<>();
		for(int i = 0; i < 3; i++)
			list.add(i);
		findAllSubset(list);
	
		
	}
	public static void findAllSubset(ArrayList list){
		int i = 3;
		StringBuilder sb = new StringBuilder();
		for(int j = 0; j < 3; j++){
			sb.append((i | 0) == 0? 0 : 1);
			i >>= 1;
			//System.out.println(tempInt);
		}
		System.out.println(sb);
		
	}
}
