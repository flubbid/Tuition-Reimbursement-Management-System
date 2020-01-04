package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
						rs.getDouble("reimTotAmount"),
						rs.getDouble("reimAmtApproved"),
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
	public void createReimbursement(Reimbursement reim) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Reimbursement> getAllReimbursement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement updateReimbursement(int reim_id) {
		// TODO Auto-generated method stub
		return null;
	}


}
