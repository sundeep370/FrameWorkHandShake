package com;

import java.util.*;

/**
 * @author Owner
 *
 */
public class TestVector {
	
	public static void main(String[] args) {
		Vector<Object> vec = new Vector<>();
		vec.add(10);
		for (int i = 0; i < 9; i++) {
			vec.addElement(i);
		}
		System.out.println(vec.capacity());
		System.out.println(vec);
		vec.add(11);
		System.out.println(vec);
		System.out.println(vec.capacity()); // If one object is newly inserted than the initial
											//capacity, it will doubles it size

	}
}
