package com;

/**
 * @author Zenith
 *
 */
import java.util.*;

public class TestArrayList {
	public static void main(String[] args) {
		ArrayList<Object> aList = new ArrayList<>();
		aList.add("10");
		aList.add(10);
		aList.add('Z');
		aList.add("Zenith");
		
		System.out.println(aList);
		
		aList.remove(2);
		System.out.println(aList);
		System.out.println("Index 2:"+aList.get(2));
		// System.out.println(a);
		aList.add(2, 11);
		System.out.println(aList);
	}
}