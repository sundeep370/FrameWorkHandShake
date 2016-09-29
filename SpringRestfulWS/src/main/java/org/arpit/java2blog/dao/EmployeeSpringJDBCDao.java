package org.arpit.java2blog.dao;

import java.util.List;

import org.arpit.java2blog.model.Employee;
import org.arpit.java2blog.model.UserDetails;
import org.springframework.stereotype.Repository;

@Repository("employeeSpringJDBCDao")
public interface EmployeeSpringJDBCDao {
	
	void addEmployee(Employee emp);

	List<Employee> listEmployeess();

	Employee getEmployee(int emp_id);
	
	boolean deleteEmployee(int emp_id);
	
	UserDetails getUserDetails(String userName, String password);
}