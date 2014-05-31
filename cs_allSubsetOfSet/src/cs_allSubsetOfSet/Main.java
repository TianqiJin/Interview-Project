package cs_allSubsetOfSet;
import java.nio.ByteBuffer;
import java.util.*;

public class Main {
	public static void main(String[] args){
		ArrayList list = new ArrayList();
		for(int i = 0; i < 3; i++)
			list.add(i);
		findAllSubset(list);
	
		
	}
	public static void findAllSubset(ArrayList list){
		int length = (int)Math.pow(2, list.size());
		ArrayList<StringBuilder> al = new ArrayList<StringBuilder>();
		for(int i = 0; i < length; i++){
			String temp = Integer.toBinaryString(i);
			//System.out.println(temp);
			StringBuilder sb = new StringBuilder();
			int distinct = list.size() - temp.length();
			int distinctTemp = distinct;
			for(int j = 0; j < list.size(); j++){
				if(temp.length() == list.size())
					sb.append(temp.charAt(j));
				else{
					
					if(distinct > 0)
						sb.append('0');
					else
						sb.append(temp.charAt(j-distinctTemp));
					distinct--;
				}
			}
			al.add(sb);
		}
		for(int i = 0; i < al.size(); i++){
			for(int j = 0; j < al.get(i).length(); j++){
				if(al.get(i).charAt(j) == '1')
					System.out.print(list.get(j));
			}
			System.out.println();
		}
		
	}
}
