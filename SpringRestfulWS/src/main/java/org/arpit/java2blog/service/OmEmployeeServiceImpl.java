package org.arpit.java2blog.service;

import java.util.ArrayList;
import java.util.List;

import org.arpit.java2blog.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("omEmployeeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class OmEmployeeServiceImpl implements  EmployeeService {

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Employee> listEmployeess() {
		// TODO Auto-generated method stub
		return new ArrayList<Employee>();
	}

	@Override
	public Employee getEmployee(int empid) {
		// TODO Auto-generated method stub
//		return super.getEmployee(empid);
		System.out.println("8***************Calling Om Impl");
		return new Employee("Chinta", "ONAKKA");
	}

	@Override
	public void deleteEmployee(int empid) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateEmployee(int emp_id, int salary) {
		// TODO Auto-generated method stub
		
	}

}
