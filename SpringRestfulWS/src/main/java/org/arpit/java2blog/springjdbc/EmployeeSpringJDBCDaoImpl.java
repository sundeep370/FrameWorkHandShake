package org.arpit.java2blog.springjdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.arpit.java2blog.dao.EmployeeSpringJDBCDao;
import org.arpit.java2blog.model.Employee;
import org.arpit.java2blog.model.UserDetails;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

public class EmployeeSpringJDBCDaoImpl implements EmployeeSpringJDBCDao {

	public DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addEmployee(Employee emp) {
		System.out.println("EmployeeServiceSpringJDBCImpl" + emp);
		try {
			if (null != emp && emp.getFristName().length() > 0) {
				String sql = "INSERT INTO EMPLOYEE "
						+ "(EMP_ID, ADDRESS, DEPARTMENT, EMAIL_ID, FRIST_NAME, LAST_NAME, SALARY, USER_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

				jdbcTemplate.update(
						sql,
						new Object[] { emp.getId(), emp.getAddress(),
								emp.getDepartment(), emp.getEmailId(),
								emp.getFristName(), emp.getLastName(),
								emp.getSalary(), emp.getUserId() });
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public List<Employee> listEmployeess() {
		// TODO Auto-generated method stub
		List<Employee> list = new ArrayList<Employee>();
		try {
			String sql = "SELECT * FROM EMPLOYEE";
			System.out.println("listEmployeess");
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> empList = jdbcTemplate.queryForList(sql);
			for (Map<String, Object> map : empList) {
				Employee employee = new Employee();
				employee.setId(new Integer(map.get("EMP_ID").toString()));
				employee.setAddress(map.get("ADDRESS").toString());
				employee.setDepartment(map.get("DEPARTMENT").toString());
				employee.setEmailId(map.get("EMAIL_ID").toString());
				employee.setFristName(map.get("FRIST_NAME").toString());
				employee.setLastName(map.get("LAST_NAME").toString());
				employee.setUserId(map.get("USER_ID").toString());
				employee.setSalary(new Integer(map.get("SALARY").toString()));
				list.add(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Employee getEmployee(int emp_id) {
		// TODO Auto-generated method stub
		Employee employee = null;
		try {
			if (emp_id > 0) {
				String sql = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ?";

				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				employee = (Employee) jdbcTemplate.queryForObject(sql,
						new Object[] { emp_id }, new EmployeeRowMapper());
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return employee;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean deleteEmployee(int emp_id) {
		if (emp_id > 0) {
			String sql = "DELETE FROM EMPLOYEE WHERE EMP_ID = ?";
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			jdbcTemplate.update(sql, new Object[] { emp_id });
		}
		return true;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public UserDetails getUserDetails(String userName, String password) {
		// TODO Auto-generated method stub
		UserDetails userDetails = null;
		try {
			if (null != userName && !userName.isEmpty()) {
				String sql = "SELECT * FROM USER_DETAILS WHERE USER_NAME = ?";

				System.out.println("Dao layer ");
				
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				List<Map<String, Object>> empList = jdbcTemplate.queryForList(sql, new Object[] { userName });
				for (Map<String, Object> map : empList) {
					
					if(userName.equalsIgnoreCase(map.get("USER_NAME").toString())
							&& password.equalsIgnoreCase(map.get("PASSWORD").toString())){
						userDetails = new UserDetails();
						userDetails.setUserName(map.get("USER_NAME").toString());
						userDetails.setPassword(map.get("PASSWORD").toString());
					}
					
				}
				
				System.out.println("userDetails ="+userDetails.getUserName()+","+userDetails.getPassword());
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return userDetails;
	}
	
}