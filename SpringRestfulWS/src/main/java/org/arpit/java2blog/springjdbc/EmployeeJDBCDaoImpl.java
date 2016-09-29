/**
 * 
 */
package org.arpit.java2blog.springjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.arpit.java2blog.dao.EmployeeJDBCDao;
import org.arpit.java2blog.model.Employee;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Owner
 * 
 */
public class EmployeeJDBCDaoImpl implements EmployeeJDBCDao {

	public DataSource dataSource;

	/**
	 * @return the dataSource
	 */
	public DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * @param dataSource
	 *            the dataSource to set
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Transactional(rollbackFor = Exception.class)
	public void addEmployee(Employee employee) {
		Connection conn = null;
		try {
			System.out.println("JDBC addEmployee:"+employee);
			if(null != employee && employee.getFristName().length() > 0){
				System.out.println("JDBC addEmployee:"+employee);
				conn = dataSource.getConnection();
				conn.setAutoCommit(false);
				String sql = "SELECT MAX(EMP_ID) EMP_ID FROM EMPLOYEE";
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					employee.setId(1 + rs.getInt("EMP_ID"));
				}
	
				ps.clearParameters();
				ps.close();
	
				System.out.println("JDBC addEmployee:"+employee.getId());
				
				sql = "INSERT INTO employee (emp_id, frist_name, last_name, user_id, email_id, salary, department, address) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
				ps = conn.prepareStatement(sql);
				ps.setLong(1, employee.getId());
				ps.setString(2, employee.getFristName());
				ps.setString(3, employee.getLastName());
	
				ps.setString(4, employee.getUserId());
				ps.setString(5, employee.getEmailId());
				ps.setLong(6, employee.getSalary());
	
				ps.setString(7, employee.getDepartment());
				ps.setString(8, employee.getAddress());
				ps.executeUpdate();
				conn.commit();
				ps.close();
			}

		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	@Transactional(rollbackFor = Exception.class)
	public Employee getEmployee(int id) {
		String sql = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ?";
		Employee employee = null;
		Connection conn = null;
		try {
			if(id > 0){
				conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
	
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					employee = new Employee();
					employee.setId(rs.getLong("emp_id"));
					employee.setAddress(rs.getString("address"));
					employee.setDepartment(rs.getString("department"));
					employee.setEmailId(rs.getString("email_id"));
					employee.setFristName(rs.getString("frist_name"));
					employee.setLastName(rs.getString("last_name"));
					employee.setSalary(rs.getInt("salary"));
					employee.setUserId(rs.getString("user_id"));
				}
				rs.close();
				ps.close();
			} else {
				employee = new Employee();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return employee;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public List<Employee> listEmployeess() {
		// TODO Auto-generated method stub
		List<Employee> list = new ArrayList<Employee>();
		String sql = "SELECT * FROM EMPLOYEE";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setId(new Integer(rs.getString("EMP_ID")));
				employee.setAddress(rs.getString("ADDRESS").toString());
				employee.setDepartment(rs.getString("DEPARTMENT").toString());
				employee.setEmailId(rs.getString("EMAIL_ID").toString());
				employee.setFristName(rs.getString("FRIST_NAME").toString());
				employee.setLastName(rs.getString("LAST_NAME").toString());
				employee.setUserId(rs.getString("USER_ID").toString());
				employee.setSalary(new Integer(rs.getInt("SALARY")));
				list.add(employee);
			}
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return list;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean deleteEmployee(int emp_id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM EMPLOYEE WHERE EMP_ID = ?";
		boolean flag = false;
		Connection conn = null;
		try {
			if(emp_id > 0){
				conn = dataSource.getConnection();
				conn.setAutoCommit(false);
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, emp_id);
				int updateResponse = ps.executeUpdate();
				System.out.println("JDBC deleteEmployee" + updateResponse);
				conn.commit();
				flag = true;
			}
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			flag = false;
			
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return flag;
	}

}
