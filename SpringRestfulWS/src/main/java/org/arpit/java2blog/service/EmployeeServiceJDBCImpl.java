package org.arpit.java2blog.service;

import java.util.List;

import org.arpit.java2blog.dao.EmployeeJDBCDao;
import org.arpit.java2blog.model.Employee;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zenith
 *
 */
@Service("employeeServiceJDBC")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EmployeeServiceJDBCImpl implements EmployeeServiceJDBC {

	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addEmployee(Employee employee) {
		ConfigurableApplicationContext context = new FileSystemXmlApplicationContext
        		("D:/Zenith/WorkSpace1/SpringRestfulWS/src/main/webapp/WEB-INF/DataSource.xml");

		EmployeeJDBCDao employeeJDBCDao = (EmployeeJDBCDao) context.getBean("employeeJDBCDao");
		
		employeeJDBCDao.addEmployee(employee);
	}
	
	public List<Employee> listEmployeess() {
		ConfigurableApplicationContext context = new FileSystemXmlApplicationContext
        		("D:/Zenith/WorkSpace1/SpringRestfulWS/src/main/webapp/WEB-INF/DataSource.xml");

		EmployeeJDBCDao employeeJDBCDao = (EmployeeJDBCDao) context.getBean("employeeJDBCDao");
		
		return employeeJDBCDao.listEmployeess();
	}

	public Employee getEmployee(int empid) {
		ConfigurableApplicationContext context = new FileSystemXmlApplicationContext
        		("D:/Zenith/WorkSpace1/SpringRestfulWS/src/main/webapp/WEB-INF/DataSource.xml");

		EmployeeJDBCDao employeeJDBCDao = (EmployeeJDBCDao) context.getBean("employeeJDBCDao");
		
		return employeeJDBCDao.getEmployee(empid);
	}
	
	public void deleteEmployee(int empid) {
		ConfigurableApplicationContext context = new FileSystemXmlApplicationContext
        		("D:/Zenith/WorkSpace1/SpringRestfulWS/src/main/webapp/WEB-INF/DataSource.xml");

		EmployeeJDBCDao employeeJDBCDao = (EmployeeJDBCDao) context.getBean("employeeJDBCDao");
		
		employeeJDBCDao.deleteEmployee(empid);
	}

}
