package com;

import java.util.HashSet;
import java.util.Set;

public class SetClass {

	
	public static void main(String args[]){
		
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
		for(Employee e :eSet){
			System.out.println(e.hashCode());
		}
		System.out.println(eSet.hashCode());
	}
}
