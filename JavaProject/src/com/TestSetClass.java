package com;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class TestSetClass {

	public static void main(String args[]) {

		Employee emp1 = new Employee();
		emp1.setEmp_id(1);
		emp1.setFirstName("Om");
		emp1.setLastName("Prakesh");

		Employee emp2 = new Employee();
		emp2.setEmp_id(1);
		emp2.setFirstName("Om");
		emp2.setLastName("Prakesh");

		Set<Employee> eSet = new HashSet<>();
		eSet.add(emp1);
		eSet.add(emp2);

		System.out.println(eSet.size());
		for (Employee e : eSet) {
			System.out.println(e.hashCode());
		}
		System.out.println(eSet.hashCode());

		System.out.println();
		TestSetClass t = new TestSetClass();
		t.getTreeSet();
		t.getHashSet();
		t.getLinkedHashSet();
		t.getSortedSet();
	}

	public void getTreeSet() {
		// Create a tree set
		TreeSet<String> ts = new TreeSet<>();

		// Add elements to the tree set
		ts.add("C");
		ts.add("A");
		ts.add("B");
		ts.add("E");
		ts.add("F");
		ts.add("D");
		System.out.println(ts);

	}

	public void getHashSet() {
		// Create a tree set
		Set<String> ts = new HashSet<>();

		// Add elements to the tree set
		ts.add("C");
		ts.add("A");
		ts.add("B");
		ts.add("E");
		ts.add("F");
		ts.add("D");
		System.out.println(ts);

	}

	public void getLinkedHashSet() {
		// Create a tree set
		Set<String> ts = new LinkedHashSet<>();

		// Add elements to the tree set
		ts.add("C");
		ts.add("A");
		ts.add("B");
		ts.add("E");
		ts.add("F");
		ts.add("D");
		System.out.println(ts);

	}

	public void getSortedSet() {
		SortedSet<String> sSet = new TreeSet<>();

		// Add elements to the set
		sSet.add("C");
		sSet.add("A");
		sSet.add("B");
		sSet.add("E");
		sSet.add("F");
		sSet.add("D");

		System.out.println(sSet);
		// Iterating over the elements in the set
		Iterator<String> it = sSet.iterator();

		while (it.hasNext()) {
			// Get element
			Object element = it.next();
			System.out.println(element.toString());
		}
	}
}
