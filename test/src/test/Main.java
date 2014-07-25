package test;
import java.util.*;

public class Main {
	public static void main(String[] args){
		String s1 = "abc";
		String s2;
		boolean result = true;;
		
		s2 = s1;
		s1 = null;
		System.out.println(s2.substring(1,3));
	}
}

