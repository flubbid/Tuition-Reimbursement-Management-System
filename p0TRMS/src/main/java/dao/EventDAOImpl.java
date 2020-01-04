package dao;

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
						rs.getString("NAME"),
						rs.getString("DESCRIPTION"),
						rs.getDouble("COST"),
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
	public Event createEvent(Event evt) {
		return evt;
		// TODO Auto-generated method stub

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
