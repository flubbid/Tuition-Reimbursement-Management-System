package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Dept;
import model.Grade;
import utils.JDBC;

public class DeptDAOImpl implements DeptDAO {

	public static Connection conn = JDBC.getConnection();
	
	@Override
	public Dept getDept(int dept_id) {
		try {
			String sql = "SELECT * FROM Dept WHERE dept_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, dept_id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return new Dept(
						rs.getInt("dept_ID"),
						rs.getInt("deptHead"),
						rs.getString("deptName")

						);
						
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public Dept createDept(Dept dept) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dept> getAllDepts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dept updateDept(int dept_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
