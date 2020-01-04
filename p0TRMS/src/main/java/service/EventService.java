package service;

import java.util.List;

import dao.EventDAO;
import dao.EventDAOImpl;
import model.Event;

public class EventService {

	public static EventDAO evtd = new EventDAOImpl();
		
	public static Event getEvent(int evt_id) {
		return evtd.getEvent(evt_id);
		
	};
	public static Event createEvent(Event evt) {
		return evtd.createEvent(evt);
	};
	public static List<Event> getAllEvents(){
		return evtd.getAllEvents();
	};
	public static void updateEvent(int evt_id) {
		return;
	};
	
}
