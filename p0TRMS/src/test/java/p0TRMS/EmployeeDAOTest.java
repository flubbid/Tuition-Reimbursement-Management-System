package p0TRMS;

import java.sql.Connection;
import java.util.List;

import org.junit.Test;

import dao.EmployeeDAO;
import dao.EmployeeDaoImpl;
import junit.framework.TestCase;
import model.Employee;
import model.Event;
import service.EmployeeService;
import service.EventService;
import utils.JDBC;

public class EmployeeDAOTest extends TestCase {

	@Test
	public void testEmployeeDao() throws Exception{
		Connection conn = JDBC.getConnection();
		conn.setAutoCommit(false);
		
//		EmployeeDAO myEmp = new EmployeeDaoImpl();
		
//		List<Employee> empList = EmployeeService.getAllEmployees();
		
		Employee emp = EmployeeService.getEmployee(2);
				
		System.out.println(emp);
//		empList.forEach(System.out::println);
		String email = "admin@gmail.com";
		String password = "password";
		
		Employee emp1 = EmployeeService.getEmployeeLogin(email, password);
		System.out.println(emp1);
		
		Event e = EventService.getEvent(11);
		System.out.println(e);
		
	}
	
}
