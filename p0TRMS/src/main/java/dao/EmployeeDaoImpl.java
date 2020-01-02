package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;
import utils.JDBC;

public class EmployeeDaoImpl implements EmployeeDAO {

	public static Connection conn = JDBC.getConnection();
	
	public Employee getEmployee(int emp_id) throws SQLException {
		try {
			String sql = "SELECT * FROM employee WHERE emp_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, emp_id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return new Employee(
						rs.getInt("EMP_ID"),
						rs.getString("FIRSTNAME"),
						rs.getString("LASTNAME"),
						rs.getString("EMAIL"),
						rs.getString("PASSWORD"),
						rs.getInt("DEPT_ID"),
						rs.getInt("SUPERVISOR"),
						rs.getDouble("AVAILABLEREIMBURSEMENT")
						);
						
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}



	public List<Employee> getAllEmployees() throws SQLException {
		try {
		String sql = "SELECT * FROM EMPLOYEE";
		List<Employee> employee = new ArrayList<Employee>();
		
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
		while(rs.next()) {
			employee.add(new Employee(
					rs.getInt("EMP_ID"),
					rs.getString("FIRSTNAME"),
					rs.getString("LASTNAME"),
					rs.getString("EMAIL"),
					rs.getString("PASSWORD"),
					rs.getInt("DEPT_ID"),
					rs.getInt("SUPERVISOR"),
					rs.getDouble("AVAILABLEREIMBURSEMENT")
					));
		
			
		}
		return employee;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public void updateEmployee(int empId) throws SQLException {
		// TODO Auto-generated method stub

	}



	@Override
	public void createEmployee(Employee emp) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
