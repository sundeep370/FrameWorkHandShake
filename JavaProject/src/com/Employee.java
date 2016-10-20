package com;

public class Employee {

	public String firstName;
	public String lastName;
	public int emp_id;
	
	public static Employee _emp = null;
	public static Employee getInstance(){
		if(null == _emp){
			_emp = new Employee();
		}
		return _emp;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	
	@Override
	public boolean equals(Object emp){
		Employee e = (Employee) emp;
		if((this.emp_id == e.getEmp_id())
				&& this.firstName.equals(e.getFirstName())
				&& this.lastName.equals(e.getLastName())){
			return true;
		}
		return false;
	}
	@Override
	public int hashCode(){
		
		/*if((this.emp_id == emp_id)
				&& this.firstName.hashCode() == firstName.hashCode()
				&& this.lastName.hashCode() == lastName.hashCode()){
			return true;
		}
		return false;*/
		final int result = 0;
		if(null != firstName && null != lastName){
		return result+this.emp_id+this.firstName.hashCode()+this.lastName.hashCode();
		} else {
			return result+this.emp_id; 
		}
	}
}
