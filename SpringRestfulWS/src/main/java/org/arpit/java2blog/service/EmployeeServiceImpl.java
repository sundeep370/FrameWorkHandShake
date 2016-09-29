package org.arpit.java2blog.service;

import java.util.List;

import org.arpit.java2blog.dao.EmployeeDao;
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
@Service("employeeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addEmployee(Employee employeeBean) {
		ConfigurableApplicationContext context = new FileSystemXmlApplicationContext
        		("D:/Zenith/WorkSpace1/SpringRestfulWS/src/main/webapp/WEB-INF/DataSource.xml");

		EmployeeDao employeeDao = (EmployeeDao) context.getBean("employeeDao");
		
		employeeDao.addEmployee(employeeBean);
		
	}
		
	public List<Employee> listEmployeess() {
		ConfigurableApplicationContext context = new FileSystemXmlApplicationContext
        		("D:/Zenith/WorkSpace1/SpringRestfulWS/src/main/webapp/WEB-INF/DataSource.xml");

		EmployeeDao employeeDao = (EmployeeDao) context.getBean("employeeDao");
		
		return employeeDao.listEmployeess();
	}

	public Employee getEmployee(int empid) {
		ConfigurableApplicationContext context = new FileSystemXmlApplicationContext
        		("D:/Zenith/WorkSpace1/SpringRestfulWS/src/main/webapp/WEB-INF/DataSource.xml");
		System.out.println("****************** calling Sundeep");
		EmployeeDao employeeDao = (EmployeeDao) context.getBean("employeeDao");
		
		return employeeDao.getEmployee(empid);
	}
	
	public void deleteEmployee(int empid) {
		ConfigurableApplicationContext context = new FileSystemXmlApplicationContext
        		("D:/Zenith/WorkSpace1/SpringRestfulWS/src/main/webapp/WEB-INF/DataSource.xml");

		EmployeeDao employeeDao = (EmployeeDao) context.getBean("employeeDao");
		
		employeeDao.deleteEmployee(empid);
	}


	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateEmployee(int emp_id, int salary) {
		ConfigurableApplicationContext context = new FileSystemXmlApplicationContext
        		("D:/Zenith/WorkSpace1/SpringRestfulWS/src/main/webapp/WEB-INF/DataSource.xml");

		EmployeeDao employeeDao = (EmployeeDao) context.getBean("employeeDao");
		employeeDao.updateEmployee(emp_id, salary);
	}

}
