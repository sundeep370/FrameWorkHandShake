package org.arpit.java2blog.dao;

import java.util.List;

import org.arpit.java2blog.model.Employee;
import org.springframework.stereotype.Repository;

@Repository("employeeJDBCDao")
public interface EmployeeJDBCDao {
	
	public void addEmployee(Employee emp);
		
	public List<Employee> listEmployeess();

	public Employee getEmployee(int emp_id);

	public boolean deleteEmployee(int emp_id);
}