package dao;

import java.sql.SQLException;
import java.util.List;

import model.Employee;

public interface EmployeeDAO {


	public Employee getEmployee(int emp_id) throws SQLException;
	public Employee getEmployeeLogin(String email, String password) throws SQLException;
	public void createEmployee(Employee emp) throws SQLException;
	public List<Employee> getAllEmployees() throws SQLException;
	public void updateEmployee(int emp_id) throws SQLException;
	
}
