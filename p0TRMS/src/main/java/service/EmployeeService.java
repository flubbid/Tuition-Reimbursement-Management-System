package service;

import java.sql.SQLException;
import java.util.List;

import dao.EmployeeDAO;
import dao.EmployeeDaoImpl;
import model.Employee;

public class EmployeeService {

	public static EmployeeDAO ed = new EmployeeDaoImpl();
	
	public static Employee getEmployeeLogin(String email, String password){
			return ed.getEmployeeLogin(email, password);	
	}
	
	public static Employee getEmployee(int emp_id) {
		return ed.getEmployee(emp_id);
	}
	
	
	public static List<Employee> getAllPeasants(int supervisor) {
		return ed.getAllPeasants(supervisor);
	}
	
	public static List<Employee> getAllEmployees(){
		return ed.getAllEmployees();
	}
	public static boolean updateEmployeeBalance(int emp_id, int availMoney) {
		return ed.updateEmployeeBalance(emp_id, availMoney);
	}
	
}
