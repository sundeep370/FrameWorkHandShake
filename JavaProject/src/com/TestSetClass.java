package com;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class TestSetClass {

	public static void main(String args[]) {

		Set<Employee> eSet = new HashSet<>();
		
		Employee emp1 = Employee.getInstance();
		emp1.setEmp_id(1);
		emp1.setFirstName("Om");
		emp1.setLastName("Prakesh");

		eSet.add(emp1);
		System.out.println("Set - HashCode:"+eSet.hashCode());
		Employee emp2 = Employee.getInstance();
		emp2.setEmp_id(2);
		emp2.setFirstName("Sundeep");
		emp2.setLastName("Seethalam");
		
		eSet.add(emp2);
		System.out.println("Set - HashCode:"+eSet.hashCode());
		Employee emp3 = Employee.getInstance();
		emp3.setEmp_id(3);
		emp3.setFirstName("Om");
		emp3.setLastName("Prakesh");

		eSet.add(emp3);
		
		Employee.getInstance().setEmp_id(4);
		Employee.getInstance().setFirstName("Sundeep");
		Employee.getInstance().setLastName("Seethalam");
		
		System.out.println("Set - HashCode:"+eSet.hashCode());
		System.out.println("Set - size:"+eSet.size());
		for (Employee e : eSet) {
			System.out.println("HashCode:"+e.hashCode());
		}
		

		System.out.println("END");
		/*TestSetClass t = new TestSetClass();
		t.getTreeSet();
		t.getHashSet();
		t.getLinkedHashSet();
		t.getSortedSet();*/
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
