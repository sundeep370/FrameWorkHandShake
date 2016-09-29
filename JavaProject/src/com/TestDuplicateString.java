package com;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Zenith
 *
 */
public class TestDuplicateString {
	/*
	*//**
	 * @param inputString
	 * @param length
	 * @return
	 *//*
	static String getManString(String inputString, int length){
		if(inputString != null && inputString.trim().length()>0){
		StringBuffer str = new StringBuffer(inputString); 
		for(int i=0; i<str.length();i++){
			int count=0;
			for(int j=i+1; j<str.length();j++){
				if(str.charAt(i)==str.charAt(j)){  
					count++;
					if(count == length)
					{
						str.deleteCharAt(j);
					}
				}
				else
				{
					break;
				}
			}
		}
		return str.toString(); 
	  }
		return null;
	 }*/
	public static void main(String[] args) {	
		System.out.println("Please input your string: ");
		Scanner in = new Scanner(System.in);
		String str = in.next();
		System.out.println("Please input your integer: ");
		//int number = in.nextInt();
		//System.out.println("Output for the given inputs: "+getManString(str,number));
		TestDuplicateString dubStr = new TestDuplicateString();
		System.out.println("Output for the given inputs: "+dubStr.findDuplicateChars(str));
		
	}
	
	public Map<Character, Integer> findDuplicateChars(String str) {
		Map<Character, Integer> dupMap = new LinkedHashMap<Character, Integer>();
//		HashMap --Output for the given inputs: {D=1, E=1, O=2, M=1} // no order
//		LinkedHashMap --Output for the given inputs: {D=1, E=1, M=1, O=2} // hold the insertion order
//		TreeMap -- Output for the given inputs: {D=1, E=1, M=1, O=1}// order by assending s
		char[] chrs = str.toCharArray();
		for (Character ch : chrs) {
			if (dupMap.containsKey(ch)) {
				dupMap.put(ch, dupMap.get(ch) + 1);
			} else {
				dupMap.put(ch, 1);
			}
		}

		Set<Character> keys = dupMap.keySet();

		for (Character ch : keys) {
			if (dupMap.get(ch) > 1) {
				System.out.println(ch + "--->" + dupMap.get(ch));
			}
		}
		return dupMap;
	}
}