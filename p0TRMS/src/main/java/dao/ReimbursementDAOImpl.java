package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Event;
import model.Reimbursement;
import utils.JDBC;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	public static Connection conn = JDBC.getConnection();
	
	@Override
	public Reimbursement getReimbursement(int reim_id) {
		try {
			String sql = "SELECT * FROM Reimbursement WHERE reim_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reim_id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return new Reimbursement(
						rs.getInt("reim_id"),
						rs.getInt("emp_id"),
						rs.getInt("grade_id"),
						rs.getInt("evt_id"),
						rs.getInt("reimTotAmount"),
						rs.getInt("reimAmtApproved"),
						rs.getString("reimStatus"),
						rs.getString("dateSub"),
						rs.getString("approvalDate"),
						rs.getString("justification")
						);
						
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	

	@Override
	public boolean createReimbursement(int emp_id, int grade_id, int reimTotAmount, String reimStatus, int reimAmtApproved,
			String dateSub, String approvalDate, String justification, int evt_id) {
		try {
			String sql = "CALL add_Reimbursement(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			CallableStatement cs = conn.prepareCall(sql);
			
				cs.setInt(1, emp_id);
				cs.setInt(2, grade_id);
				cs.setInt(3, reimTotAmount);
				cs.setString(4, reimStatus);
				cs.setInt(5, reimAmtApproved);
				cs.setString(6, dateSub);
				cs.setString(7, approvalDate);
				cs.setString(8, justification);
				cs.setInt(9, evt_id);
						
				
			cs.execute();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return false;
	}
	

	@Override
	public List<Reimbursement> getAllSupervisorReimbursement(int emp_id) {
		String sql = "SELECT * FROM Reimbursement WHERE emp_id = ?";
		List<Reimbursement> Reimbursement = new ArrayList<Reimbursement>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, emp_id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Reimbursement.add(new Reimbursement(
						rs.getInt("reim_id"),
						rs.getInt("emp_id"),
						rs.getInt("grade_id"),
						rs.getInt("evt_id"),
						rs.getInt("reimTotAmount"),
						rs.getInt("reimAmtApproved"),
						rs.getString("reimStatus"),
						rs.getString("dateSub"),
						rs.getString("approvalDate"),
						rs.getString("justification")));		
				}
			return Reimbursement;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Reimbursement> getAllSupervisorReimbursement(String position) {
		String sql = "SELECT * FROM Reimbursement WHERE reimstatus = ?";
		List<Reimbursement> Reimbursement = new ArrayList<Reimbursement>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, position);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Reimbursement.add(new Reimbursement(
						rs.getInt("reim_id"),
						rs.getInt("emp_id"),
						rs.getInt("grade_id"),
						rs.getInt("evt_id"),
						rs.getInt("reimTotAmount"),
						rs.getInt("reimAmtApproved"),
						rs.getString("reimStatus"),
						rs.getString("dateSub"),
						rs.getString("approvalDate"),
						rs.getString("justification")));		
			}
			return Reimbursement;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Reimbursement> getEveryReimbursement() {
		String sql = "SELECT * FROM Reimbursement";
		List<Reimbursement> Reimbursement = new ArrayList<Reimbursement>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
	
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Reimbursement.add(new Reimbursement(
						rs.getInt("reim_id"),
						rs.getInt("emp_id"),
						rs.getInt("grade_id"),
						rs.getInt("evt_id"),
						rs.getInt("reimTotAmount"),
						rs.getInt("reimAmtApproved"),
						rs.getString("reimStatus"),
						rs.getString("dateSub"),
						rs.getString("approvalDate"),
						rs.getString("justification")));		
			}
			return Reimbursement;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateReimbursement(int reim_id, String reimStatus) {
		 String sql = "UPDATE Reimbursement SET reimStatus = ? WHERE reim_id = ?";
	        
	        try {
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, reimStatus);
	            ps.setInt(2, reim_id);
	                    
	            ps.executeQuery();
	            return true;
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;	
	}

}
