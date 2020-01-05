package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Employee;
import model.Event;
import utils.JDBC;

public class EventDAOImpl implements EventDAO {
	
	public static Connection conn = JDBC.getConnection();
	
	@Override
	public Event getEvent(int evt_id) {
		try {
			String sql = "SELECT * FROM Event WHERE evt_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, evt_id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return new Event(
						rs.getInt("EVT_ID"),
						rs.getString("evtTyoe"),
						rs.getString("NAME"),
						rs.getString("DESCRIPTION"),
						rs.getInt("COST"),
						rs.getString("BEGINDATE"),
						rs.getString("ENDDATE"),
						rs.getString("TIME"),
						rs.getString("ADDRESS"),
						rs.getString("ADDRESS2"),
						rs.getString("CITY"),
						rs.getString("STATE"),
						rs.getInt("ZIPCODE")
						);
						
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	

	@Override
	public boolean createEvent(String evtType, String name, String description, int cost, String beginDate, String endDate, String time, String address, String address2, String city, String state, int zipcode) {
		try {
			String sql = "CALL add_Event(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			CallableStatement cs = conn.prepareCall(sql);

			cs.setString(1, evtType);
			cs.setString(2, name);
			cs.setString(3, description);
			cs.setInt(4, cost);
			cs.setString(5, beginDate);
			cs.setString(6, endDate);
			cs.setString(7, time);
			cs.setString(8, address);
			cs.setString(9, address2);
			cs.setString(10, city);
			cs.setString(11, state);
			cs.setInt(12, zipcode);
			
						
				
			cs.execute();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return false;
	}
	

	@Override
	public List<Event> getAllEvents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEvent(int evt_id) {
		// TODO Auto-generated method stub

	}

}
