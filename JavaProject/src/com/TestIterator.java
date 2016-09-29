package com;

/**
 * @author Zenith
 */

import java.util.*;

public class TestIterator {
	public static void main(String[] args) {
		ArrayList<Object> aList = new ArrayList<>();
		aList.add("10");
		aList.add(21);
		aList.add("a");
		aList.add("Zenith");
		aList.add("Services");
		aList.add("INC");
		Iterator<Object> i = aList.iterator();
		while (i.hasNext()) {
			String s = (String) i.next();
			System.out.println(s);
			if("Zenith".equals(s)){
				i.remove();
			}
		}
		System.out.println(aList);
	}
}
