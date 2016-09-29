package org.arpit.java2blog.service;

import java.util.List;

import org.arpit.java2blog.model.Employee;


/**
 * @author zenith
 *
 */

public interface EmployeeServiceJDBC {
	
	public void addEmployee(Employee employee);

	public List<Employee> listEmployeess();
	
	public Employee getEmployee(int empid);
	
	public void deleteEmployee(int empid);
}
