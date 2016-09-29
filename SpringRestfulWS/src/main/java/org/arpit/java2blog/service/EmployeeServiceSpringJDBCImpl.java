package org.arpit.java2blog.service;

import java.util.List;

import org.arpit.java2blog.dao.EmployeeSpringJDBCDao;
import org.arpit.java2blog.model.Employee;
import org.arpit.java2blog.model.UserDetails;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zenith
 *
 */
@Service("employeeServiceSpringJDBC")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EmployeeServiceSpringJDBCImpl implements EmployeeServiceSpringJDBC {

	
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addEmployee(Employee employee) {
		ConfigurableApplicationContext context = new FileSystemXmlApplicationContext
        		("D:/Zenith/WorkSpace1/SpringRestfulWS/src/main/webapp/WEB-INF/DataSource.xml");

		EmployeeSpringJDBCDao employeeSpringJDBCDao = (EmployeeSpringJDBCDao) context.getBean("employeeSpringJDBCDao");
        
		System.out.println("EmployeeServiceSpringJDBCImpl"+employee);
		employeeSpringJDBCDao.addEmployee(employee);
	}
	
	public List<Employee> listEmployeess() {
		ConfigurableApplicationContext context = new FileSystemXmlApplicationContext
        		("D:/Zenith/WorkSpace1/SpringRestfulWS/src/main/webapp/WEB-INF/DataSource.xml");

		EmployeeSpringJDBCDao employeeSpringJDBCDao = (EmployeeSpringJDBCDao) context.getBean("employeeSpringJDBCDao");
		
		System.out.println("EmployeeServiceSpringJDBCImpl:listEmployeess");
		return employeeSpringJDBCDao.listEmployeess();
	}

	public Employee getEmployee(int empid) {
		ConfigurableApplicationContext context = new FileSystemXmlApplicationContext
        		("D:/Zenith/WorkSpace1/SpringRestfulWS/src/main/webapp/WEB-INF/DataSource.xml");

		EmployeeSpringJDBCDao employeeSpringJDBCDao = (EmployeeSpringJDBCDao) context.getBean("employeeSpringJDBCDao");
		System.out.println("EmployeeServiceSpringJDBCImpl:getEmployee");
		return employeeSpringJDBCDao.getEmployee(empid);
	}
	
	public void deleteEmployee(int empid) {
		ConfigurableApplicationContext context = new FileSystemXmlApplicationContext
        		("D:/Zenith/WorkSpace1/SpringRestfulWS/src/main/webapp/WEB-INF/DataSource.xml");

		EmployeeSpringJDBCDao employeeSpringJDBCDao = (EmployeeSpringJDBCDao) context.getBean("employeeSpringJDBCDao");
		System.out.println("EmployeeServiceSpringJDBCImpl:employeeSpringJDBCDao");
		employeeSpringJDBCDao.deleteEmployee(empid);
	}

	
	public UserDetails getUserDetails(String userName, String password) {
		ConfigurableApplicationContext context = new FileSystemXmlApplicationContext
        		("D:/Zenith/WorkSpace1/SpringRestfulWS/src/main/webapp/WEB-INF/DataSource.xml");

		EmployeeSpringJDBCDao employeeSpringJDBCDao = (EmployeeSpringJDBCDao) context.getBean("employeeSpringJDBCDao");
		System.out.println("EmployeeServiceSpringJDBCImpl:getEmployee");
		return employeeSpringJDBCDao.getUserDetails(userName,password);
	}
	
}
