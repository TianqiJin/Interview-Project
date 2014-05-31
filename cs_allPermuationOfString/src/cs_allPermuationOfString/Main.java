package cs_allPermuationOfString;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args){
		String string = "abc";
		if(string.equals(null) || string.length() == 1)
			return;
		ArrayList<String> al = new ArrayList<String>();
		al = findAllPermuation(string, al);
		
		
		for(int i = 0; i< al.size(); i++){
			
			System.out.println(al.get(i));
		}
		
	}
	public static ArrayList<String> findAllPermuation(String string, ArrayList<String>al){
		if(string.length() == 1){
			al.add(string);
			return al;
		}
			
		else{
			char seperatedChar = string.charAt(string.length()-1);
			string = string.substring(0,string.length()-1);
			al = findAllPermuation(string, al);
			int size = al.size();
			for(int i = 0; i < size; i++){
				char[] temp = al.get(i).toCharArray();
				for(int j = 0; j <= temp.length; j++){
					char[] newSubString = new char[temp.length+1];
					for(int m = 0; m < newSubString.length; m++){
						if(m == j)
							newSubString[m] = seperatedChar;
						else{
							if(m > j)
								newSubString[m] = temp[m-1];
							else
								newSubString[m] = temp[m];
						}
					}
					StringBuilder sb = new StringBuilder();
					for(int n = 0; n < newSubString.length; n++)
						sb.append(newSubString[n]);
					al.add(sb.toString());
				}
				
			}
			return al;
		}
	}
}
