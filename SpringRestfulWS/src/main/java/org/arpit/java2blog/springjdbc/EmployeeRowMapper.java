package org.arpit.java2blog.springjdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.arpit.java2blog.model.Employee;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Employee>	{
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee employee = new Employee();
			employee.setId(rs.getInt("EMP_ID"));
			employee.setAddress(rs.getString("ADDRESS").toString());
			employee.setDepartment(rs.getString("DEPARTMENT").toString());
			employee.setEmailId(rs.getString("EMAIL_ID").toString());
			employee.setFristName(rs.getString("FRIST_NAME").toString());
			employee.setLastName(rs.getString("LAST_NAME").toString());
			employee.setUserId(rs.getString("USER_ID").toString());
			employee.setSalary(rs.getInt("SALARY"));
			return employee;
		}
}