package org.arpit.java2blog.service;

import java.util.List;

import org.arpit.java2blog.model.Employee;


/**
 * @author zenith
 *
 */

public interface EmployeeService {
	
	public void addEmployee(Employee employeeBean);

	public List<Employee> listEmployeess();
	
	public Employee getEmployee(int empid);
	
	public void deleteEmployee(int empid);
	
	public void updateEmployee(int emp_id, int salary);
}
