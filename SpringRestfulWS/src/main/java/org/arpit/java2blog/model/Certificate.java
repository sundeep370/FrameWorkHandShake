package org.arpit.java2blog.model;

public class Certificate {

	private int id;
	private String certificate;
	private Employee employee;
	
	public Certificate(String name, Employee employee) {
		this.certificate = name;
		this.employee = employee;
	}

	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	

	/**
	 * @return the certificate
	 */
	public String getCertificate() {
		return certificate;
	}

	/**
	 * @param certificate the certificate to set
	 */
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!this.getClass().equals(obj.getClass()))
			return false;

		Certificate obj2 = (Certificate) obj;
		if ((this.id == obj2.getId()) && (this.certificate.equals(obj2.getCertificate()))) {
			return true;
		}
		return false;
	}

	public int hashCode() {
		int tmp = 0;
		tmp = (id + certificate).hashCode();
		return tmp;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}