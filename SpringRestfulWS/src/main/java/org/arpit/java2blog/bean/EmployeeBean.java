package org.arpit.java2blog.bean;

import java.util.Set;

public class EmployeeBean{
	

	
	public EmployeeBean() {
		super();
	}
	
	private long id;

	private String fristName;
	
	//@Column(name = "last_Name")
	private String lastName;
	
	//@Column(name = "email_id")
	private String emailId;
	
	//@Column(name = "salary")
	private int salary;
	
	//@Column(name = "department")
	private String department;
	
	private String userId;	
	
	//@Column(name = "address")
	private String address;

	private Set certificates;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFristName() {
		return fristName;
	}

	public void setFristName(String fristName) {
		this.fristName = fristName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the certificates
	 */
	public Set getCertificates() {
		return certificates;
	}

	/**
	 * @param certificates the certificates to set
	 */
	public void setCertificates(Set certificates) {
		this.certificates = certificates;
	}
		
	
}