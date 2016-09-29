package org.arpit.java2blog.dao;

import java.util.List;

import org.arpit.java2blog.model.Employee;

public interface EmployeeDao {
	
	Integer addEmployee(Employee emp);
	
	List<Employee> listEmployeess();
	
	Employee getEmployee(int emp_id);
	
	boolean deleteEmployee(int emp_id);
	
	void updateEmployee(int emp_id, int salary);
}
