package org.arpit.java2blog.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.arpit.java2blog.dao.EmployeeDao;
import org.arpit.java2blog.model.Certificate;
import org.arpit.java2blog.model.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("employeeDao")
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {

	SessionFactory sessionfactory;
	
	    /**
	 * @return the sessionfactory
	 */
	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}


	/**
	 * @param sessionfactory the sessionfactory to set
	 */
	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Transactional
	public Integer addEmployee(Employee employee) {

		Session session = null;
		Transaction tx = null;
		Integer employeeID = 0;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			System.out.println("Creating the employee");
			 session.save(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if(null != session)
				session.close();
		}
		return employeeID;
	}

	@Transactional
	public Employee getEmployee(int emp_id) {
		Session session = null;
		Transaction tx = null;
		Employee employee = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			List<Employee> employees = session.createQuery("FROM Employee").list();
			for (Employee emp : employees) {
				if (emp_id == emp.getId()) {
					Set certificates = emp.getCertificates();
		            for (Iterator iterator2 = certificates.iterator(); iterator2.hasNext();){
		                  Certificate certName = (Certificate) iterator2.next(); 
		                  System.out.println("Certificate: " + certName.getCertificate()); 
		            }
					employee = emp;
					break;
				}
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if(null != session)
				session.close();
		}
		return employee;
	}

	@Transactional
	public List<Employee> listEmployeess() {
		Session session = null;
		Transaction tx = null;
		List<Employee> employees = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			employees = session.createQuery("FROM Employee").list();
			
			for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
				Employee employee = (Employee) iterator.next();
				System.out.println("First Name: " + employee.getFristName());
				System.out.println("Last Name: " + employee.getLastName());
				System.out.println("Salary:" + employee.getSalary());
				Set certificates = employee.getCertificates();
	            
				for (Iterator iterator2 = certificates.iterator(); iterator2.hasNext();){
	                  Certificate certName = (Certificate) iterator2.next(); 
	                  System.out.println("Certificate: " + certName.getCertificate()); 
	            }
	            
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if(null != session)
				session.close();
		}
		return employees;
	}

	@Transactional
	public boolean deleteEmployee(int emp_id) {

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			Employee employee = (Employee) session.get(Employee.class, new Long(emp_id));
			session.delete(employee);
			
//			Certificate certificate = (Certificate) session.get(Certificate.class, new Long(emp_id));
//			session.delete(certificate);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if(null != session)
				session.close();
		}

		return true;
	}

	/* Method to UPDATE salary for an employee */
	public void updateEmployee(int emp_id, int salary) {
		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			Employee employee = (Employee) session.get(Employee.class, emp_id);
			employee.setSalary(salary);
			session.update(employee);
			System.out.println("Update");
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
