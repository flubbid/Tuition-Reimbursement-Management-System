package service;

import java.sql.SQLException;
import java.util.List;

import dao.EmployeeDAO;
import dao.EmployeeDaoImpl;
import model.Employee;

public class EmployeeService {

	public static EmployeeDAO ed = new EmployeeDaoImpl();
	
	public static Employee getEmployeeLogin(String email, String password) throws SQLException {
			return ed.getEmployeeLogin(email, password);	
	}
	
	public static Employee getEmployee(int emp_id) throws SQLException {
		return ed.getEmployee(emp_id);
	}
	
	public static List<Employee> getAllEmployees() throws SQLException {
		return ed.getAllEmployees();
	}
	
}
