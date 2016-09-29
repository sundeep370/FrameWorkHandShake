package org.arpit.java2blog.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.arpit.java2blog.model.Certificate;
import org.arpit.java2blog.model.Employee;
import org.arpit.java2blog.model.UserDetails;
import org.arpit.java2blog.service.EmployeeService;
import org.arpit.java2blog.service.EmployeeServiceJDBC;
import org.arpit.java2blog.service.EmployeeServiceSpringJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService empService;
	@Autowired
	EmployeeServiceJDBC empJDBCService;
	@Autowired
	EmployeeServiceSpringJDBC empSpringService;

	// credentials
	private HashMap<String, String> credentials = null;

	private HttpSession session = null;
	// Hibernate
	@RequestMapping(value = "/createEmployee/{firstName}/{lastName}", method = RequestMethod.POST, headers = "Accept=text/plain")
	public void createEmployee(HttpServletRequest request, @RequestHeader Map<String, String> headers,
			@PathVariable String firstName, @PathVariable String lastName) {
		System.out.println("HeaderNames:" + request.getHeaderNames()+",RequestURL:"+request.getRequestURL()
				+",RequestURL:"+request.getServletContext());
		String authStringEnc = "";
		
		session = request.getSession(false);
		if (session != null) {
			System.out.println("Session is not null, creating new session for the user.");
			session.invalidate();
			session = request.getSession();
			System.out.println("Session not null");
		}
		
		session = request.getSession();
		HashMap<String,String> map = new HashMap<String, String>();
		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			map.put(key, value);
			
			if("authorization".equalsIgnoreCase(key)){
				authStringEnc = value;
			}
		}
		System.out.println("1 authStringEnc"+authStringEnc);
		
		/*if (null != map && !map.isEmpty() && map.containsKey("authorization"))
			authStringEnc = map.get("authorization");
		
		System.out.println("2 authStringEnc"+authStringEnc);*/
		if (isValidate(authStringEnc)) {

			Employee employee = new Employee();
			employee.setAddress("PLAINBORO NJ");
			employee.setDepartment("SALES FORCE");
			employee.setEmailId(firstName + lastName + "@ZENITH.COM");
			employee.setFristName(firstName);
			employee.setLastName(lastName);
			employee.setUserId(lastName + "_ID");
			employee.setSalary(3000000);

			HashSet<Certificate> certificate = new HashSet<Certificate>();
			certificate.add(new Certificate("MCA", employee));
			certificate.add(new Certificate("MBA", employee));
			certificate.add(new Certificate("PMP", employee));

			employee.setCertificates(certificate);
			session.setAttribute("employee", employee);
			System.out.println("employee=" + employee);

			empService.addEmployee((Employee)session.getAttribute("employee"));
			System.out.println("Done Storing=");
			
			
		}
	}

	@RequestMapping(value = "/listEmployeess", method = RequestMethod.GET)
	public List<Employee> listEmployeess() {
		System.out.println("listEmployeess=");
		List<Employee> empList = empService.listEmployeess();

		System.out.println("listEmployeess=" + empList.size());
		List<Employee> listOfemployee = new ArrayList<Employee>();

		for (Employee emp : empList) {
			Employee eb = new Employee();
			eb.setAddress(emp.getAddress());
			eb.setAddress(emp.getFristName());
			eb.setAddress(emp.getLastName());
			listOfemployee.add(eb);
		}
		return listOfemployee;
	}

	@RequestMapping(value = "/getEmployeeById/{emp_id}", method = RequestMethod.GET)
	public Employee getEmployeeById(@PathVariable int emp_id) {
		System.out.println("getEmployeeById=" + emp_id);
		Employee emp = empService.getEmployee(emp_id);

		Employee eb = new Employee();
		eb.setAddress(emp.getAddress());
		eb.setAddress(emp.getFristName());
		eb.setAddress(emp.getLastName());
		System.out.println("" + eb);
		return eb;
	}

	@RequestMapping(value = "/delete/{emp_id}", method = RequestMethod.POST)
	public void deleteEmployee(@PathVariable int emp_id) {
		System.out.println("deleteEmployee=" + emp_id);
		//
		empService.deleteEmployee(emp_id);
	}

	// Spring JDBC
	@RequestMapping(value = "/createSpringEmployee/{firstName}/{lastName}/{userId}/{department}", method = RequestMethod.POST)
	public void saveEmp(@RequestHeader Map<String, String> headers,
			@PathVariable String firstName, @PathVariable String lastName,
			@PathVariable String userId, @PathVariable String department) {
		String authStringEnc = "";
		for (String elem : headers.keySet()) {
			System.out.println(elem + " : " + headers.get(elem));
			if ("authorization".equalsIgnoreCase(elem))
				authStringEnc = headers.get(elem);
		}
		if (isValidate(authStringEnc)) {
			Employee employee = new Employee();
			employee.setAddress("PRINCETON NJ");
			employee.setDepartment(department);
			employee.setEmailId(firstName + lastName + "@ZENITH.COM");
			employee.setFristName(firstName);
			employee.setLastName(lastName);
			employee.setUserId(userId);
			employee.setSalary(30);
			empSpringService.addEmployee(employee);
		}
	}

	@RequestMapping(value = "/getAllSpringEmployee", method = RequestMethod.GET)
	public void getAllEmployees() {
		List<Employee> list = empSpringService.listEmployeess();
		System.out.println("List" + list.size());
	}

	@RequestMapping(value = "/getEmployee/{emp_id}", method = RequestMethod.GET)
	public void getEmployee(@PathVariable int emp_id) {
		Employee employee = empSpringService.getEmployee(emp_id);
		System.out.println("employee" + employee.getFristName());
	}

	@RequestMapping(value = "/deletEmployee/{emp_id}", method = RequestMethod.DELETE)
	public void deletEmployee(@PathVariable int emp_id) {
		empSpringService.deleteEmployee(emp_id);
		System.out.println("employee" + emp_id);
	}

	// JDBC

	@RequestMapping(value = "/createJDBCEmployee/{firstName}/{lastName}/{userId}", method = RequestMethod.POST)
	public void saveJDBCEmp(@PathVariable String firstName,
			@PathVariable String lastName, @PathVariable String userId) {

		System.out.println("saveJDBCEmp=" + firstName + "," + lastName + ","
				+ userId);
		Employee employee = new Employee();
		employee.setAddress("PRINCETON NJ");
		employee.setDepartment("JAVA DEV");
		employee.setEmailId("SUNDEEP@ZENITH.COM");
		employee.setFristName(firstName);
		employee.setLastName(lastName);
		employee.setUserId(userId);
		employee.setSalary(30);
		empJDBCService.addEmployee(employee);
	}

	@RequestMapping(value = "/getJDBCEmployee/{emp_id}", method = RequestMethod.GET)
	public void getJDBCEmployee(@PathVariable int emp_id) {
		Employee employee = empJDBCService.getEmployee(emp_id);
		System.out.println("getJDBCEmployee" + employee.getFristName());
	}

	@RequestMapping(value = "/getAllJDBCEmployees", method = RequestMethod.GET)
	public void getAllJDBCEmployees() {
		System.out.println("getAllJDBCEmployees");
		List<Employee> employee = empJDBCService.listEmployeess();
		System.out.println("getAllJDBCEmployees" + employee.size());
	}

	@RequestMapping(value = "/deletJDBCEmployee/{emp_id}", method = RequestMethod.DELETE)
	public void deletJDBCEmployee(@PathVariable int emp_id) {
		empJDBCService.deleteEmployee(emp_id);
		System.out.println("deletJDBCEmployee" + emp_id);
	}

	private boolean isValidate(String authStringEnc) {

		boolean isValid = false;
		if (authStringEnc != null && authStringEnc != "") {
			authStringEnc = authStringEnc.replace("Basic", "");
			byte[] authEncBytes = Base64.decodeBase64(authStringEnc.getBytes());
			String authString = new String(authEncBytes);
			String[] parts = authString.split(":");
			if (parts != null && parts.length > 1) {
				String userName = parts[0];
				String password = parts[1];
				UserDetails userDetails = empSpringService.getUserDetails(
						userName, password);
//				System.out.println("userDetails :" + userDetails);
				credentials = new HashMap<String, String>();
				credentials.put(userDetails.getUserName(),
						userDetails.getPassword());
				if (!credentials.isEmpty()) {
					isValid = true;
//					System.out.println("isValid :" + isValid);
				}

			}
		}
		return isValid;
	}

	public HashMap<String, String> getCredentials() {
		return credentials;
	}

	public void setCredentials(HashMap<String, String> credentials) {
		this.credentials = credentials;
	}

}
