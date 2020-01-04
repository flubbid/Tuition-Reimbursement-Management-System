package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Event;
import model.Grade;
import utils.JDBC;

public class GradeDAOImpl implements GradeDAO {

public static Connection conn = JDBC.getConnection();
	
	@Override
	public Grade getGrade(int grade_id) {
		try {
			String sql = "SELECT * FROM Grade WHERE grade_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, grade_id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return new Grade(
						rs.getInt("grade_ID"),
						rs.getString("GFORMAT"),
						rs.getString("PASSING")

						);
						
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public Grade createGrade(Grade grade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Grade> getAllGrades() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Grade updateGrade(int grade_id) {
		return null;
		// TODO Auto-generated method stub

	}

}
