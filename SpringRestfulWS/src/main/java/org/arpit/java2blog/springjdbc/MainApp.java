package org.arpit.java2blog.springjdbc;



import org.arpit.java2blog.model.Employee;

public class MainApp {
	
    public static void main(String[] args) {

            /*ConfigurableApplicationContext context = new FileSystemXmlApplicationContext
            		("D:/Zenith/WorkSpace1/SpringRestfulWS/src/main/webapp/WEB-INF/DataSource.xml");

            EmployeeDao employeeDAO = (EmployeeDao) context.getBean("employeeJDBCDao");*/

    	
            Employee employee1 = new Employee();
            employee1.setAddress("NEW JERSEY");
            employee1.setDepartment("IT SEC");
            employee1.setEmailId("mail@id.com");
            employee1.setFristName("OM PRAKESH");
            employee1.setLastName("ZENITH");
            employee1.setSalary(2345555);
            employee1.setUserId("OMUSER_ID");

          /*  Employee employee2 = employeeDAO.get(3);

            System.out.println("Address:"+employee2.getAddress()+"\nDepartment:"+employee2.getDepartment()+"\nEmailId:"+employee2.getEmailId()
            		+"\nFristName:"+employee2.getFristName()+"\nId:"+employee2.getId()+"\nLastName:"+employee2.getLastName()
            		+"\nSalary:"+employee2.getSalary()+"\nUserId:"+employee2.getUserId()); */

            
            /*      EmployeeDao employeeSpringJDBC = (EmployeeDao) context.getBean("employeeSpringJDBC");
        
           Employee empSpringJdbc = employeeSpringJDBC.get(3);
            System.out.println("2 Address:"+empSpringJdbc.getAddress()+"\nDepartment:"+empSpringJdbc.getDepartment()+"\nEmailId:"+empSpringJdbc.getEmailId()
            		+"\nFristName:"+empSpringJdbc.getFristName()+"\nId:"+empSpringJdbc.getId()+"\nLastName:"+empSpringJdbc.getLastName()
            		+"\nSalary:"+empSpringJdbc.getSalary()+"\nUserId:"+empSpringJdbc.getUserId()); */
            Employee getEmpSpringJdbc = new Employee();
            getEmpSpringJdbc.setAddress("princeton");
            getEmpSpringJdbc.setDepartment("IT MANAGER");
            getEmpSpringJdbc.setEmailId("om@id.com");
            getEmpSpringJdbc.setFristName("OM PRAKESH");
            getEmpSpringJdbc.setLastName("ZENITH");
            getEmpSpringJdbc.setSalary(2345555);
            getEmpSpringJdbc.setUserId("OMUSER_ID");
//            employeeSpringJDBC.save(getEmpSpringJdbc);
//            context.close();

    }

}
