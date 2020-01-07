package dao;

import java.sql.SQLException;
import java.util.List;

import model.Employee;

public interface EmployeeDAO {


	public Employee getEmployee(int emp_id);
	public Employee getEmployeeLogin(String email, String password);
	public void createEmployee(Employee emp);
	public List<Employee> getAllEmployees();
	public List<Employee> getAllPeasants(int supervisor);

	public boolean updateEmployeeBalance(int emp_id, int availMoney);
	
}
