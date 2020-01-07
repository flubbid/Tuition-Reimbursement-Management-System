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
	
	public Employee getEmployee(int emp_id){
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
						rs.getInt("AVAILABLEREIMBURSEMENT"),
						rs.getString("POSITION")
						);
						
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public Employee getEmployeeLogin(String email, String password) {
		try {
			String sql = "SELECT * FROM employee WHERE email = ? and password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			
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
						rs.getInt("AVAILABLEREIMBURSEMENT"),
						rs.getString("POSITION")
						);
						
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Employee> getAllEmployees(){
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
					rs.getInt("AVAILABLEREIMBURSEMENT"),
					rs.getString("POSITION")
					));
		
			
		}
		return employee;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public List<Employee> getAllPeasants(int supervisor){
		try {
			String sql = "SELECT * FROM EMPLOYEE WHERE SUPERVISOR = ?";
			List<Employee> employee = new ArrayList<Employee>();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, supervisor);
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
						rs.getInt("AVAILABLEREIMBURSEMENT"),
						rs.getString("POSITION")
						));
				
				
			}
			return employee;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public boolean updateEmployeeBalance(int emp_id, int availMoney){
		String sql = "UPDATE Employee SET AvailableReimbursement = ? WHERE emp_id = ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, availMoney);
            ps.setInt(2, emp_id);
                    
            ps.executeQuery();
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;	
}




	@Override
	public void createEmployee(Employee emp) {
		// TODO Auto-generated method stub
		
	}

}
