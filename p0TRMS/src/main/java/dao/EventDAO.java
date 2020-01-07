package dao;

import java.sql.SQLException;
import java.util.List;

import model.Event;

public interface EventDAO {
	public Event getEvent(int evt_id);
	public Event getEventDescription(String eventDescription);
	public boolean createEvent(String evtType, String name, String description, int cost, String beginDate, String endDate, String time, String address, String address2, String city, String state, int zipcode);
	public List<Event> getAllEvents();
	public void updateEvent(int evt_id);
}
