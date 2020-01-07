package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Messages;
import model.Messages;
import utils.JDBC;

public class MessageDAOImpl implements MessageDAO {

	public static Connection conn = JDBC.getConnection();
	
	@Override
	public Messages getMessages(int reim_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createMessages(int reim_id, int emp_id, String benco_message, String employee_message) {
		try {
			String sql = "CALL add_Messages(?, ?, ?, ?)";
			CallableStatement cs = conn.prepareCall(sql);
			
				cs.setInt(1, reim_id);
				cs.setInt(2, emp_id);
				cs.setString(3, benco_message);
				cs.setString(4, employee_message);
				
						
				
			cs.execute();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return false;
	}
	
	@Override
	public List<Messages> getAllSupervisorMessages(int emp_id) {
		String sql = "SELECT * FROM Messages WHERE emp_id = ?";
		List<Messages> Messages = new ArrayList<Messages>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, emp_id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Messages.add(new Messages(
						rs.getInt("reim_id"),
						rs.getInt("emp_id"),
						rs.getString("benco_message"),
						rs.getString("employee_message")));
	
				}
			return Messages;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	@Override
	public boolean updateMessages(int reim_id, String benco_message) {
		 String sql = "UPDATE messages SET employee_message = ? WHERE reim_id = ?";
	        
	        try {
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, benco_message);
	            ps.setInt(2, reim_id);
	                    
	            ps.executeQuery();
	            return true;
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;	
	}


	@Override
	public List<Messages> getEveryMessages() {
		String sql = "SELECT * FROM Messages";
		List<Messages> Messages = new ArrayList<Messages>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Messages.add(new Messages(
						rs.getInt("reim_id"),
						rs.getInt("emp_id"),
						rs.getString("benco_message"),
						rs.getString("employee_message")));
	
				}
			return Messages;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}




}
