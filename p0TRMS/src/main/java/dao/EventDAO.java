package dao;

import java.sql.SQLException;
import java.util.List;

import model.Event;

public interface EventDAO {
	public Event getEvent(int evt_id);
	public Event createEvent(Event evt);
	public List<Event> getAllEvents();
	public void updateEvent(int evt_id);
}
