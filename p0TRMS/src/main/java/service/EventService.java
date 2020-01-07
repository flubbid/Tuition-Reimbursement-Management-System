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
	public static Event getEventDescription(String eventDescription) {
		return evtd.getEventDescription(eventDescription);
		
	};
	public static boolean createEvent(String evtType, String name, String description, int cost, String beginDate, String endDate, String time, String address, String address2, String city, String state, int zipcode) {
		return evtd.createEvent(evtType, name, description, cost, beginDate, endDate, time, address, address2, city, state, zipcode);
	};
	public static List<Event> getAllEvents(){
		return evtd.getAllEvents();
	};
	public static void updateEvent(int evt_id) {
		return;
	};
	
}
