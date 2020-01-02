package p0TRMS;

import java.sql.Connection;
import java.util.List;

import org.junit.Test;

import dao.EmployeeDAO;
import dao.EmployeeDaoImpl;
import junit.framework.TestCase;
import model.Employee;
import service.EmployeeService;
import utils.JDBC;

public class EmployeeDAOTest extends TestCase {

	@Test
	public void testEmployeeDao() throws Exception{
		Connection conn = JDBC.getConnection();
		conn.setAutoCommit(false);
		
//		EmployeeDAO myEmp = new EmployeeDaoImpl();
		
//		List<Employee> empList = EmployeeService.getAllEmployees();
		
		Employee emp = EmployeeService.getEmployee(1);
				
		System.out.println(emp);
//		empList.forEach(System.out::println);
		
	}
	
}
