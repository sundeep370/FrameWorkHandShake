package com;


import java.util.*;

/**
 * @author Zenith
 *
 */
public class TestEnumeration {
	public static void main(String[] args) {
		Vector<Object> vector = new Vector<>();
		vector.add("21");
		vector.add("a");
		vector.addElement("Element 1");
		vector.add("Zenith");
		vector.add("Services");
		System.out.println(vector);

		Enumeration<Object> e = vector.elements();
		while (e.hasMoreElements()) {
			String str = (String) e.nextElement();
			System.out.println(str);
		}
		System.out.println(vector);
	}
}
