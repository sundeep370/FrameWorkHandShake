package org.arpit.java2blog.service;

import java.util.List;

import org.arpit.java2blog.model.Employee;
import org.arpit.java2blog.model.UserDetails;

/**
 * @author zenith
 *
 */
public interface EmployeeServiceSpringJDBC {
	
	public void addEmployee(Employee employee);

	public List<Employee> listEmployeess();
	
	public Employee getEmployee(int empid);
	
	public void deleteEmployee(int empid);
	
	public UserDetails getUserDetails(String userName, String password);
}
