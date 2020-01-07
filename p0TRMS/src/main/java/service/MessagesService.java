package service;

import java.util.List;

import dao.MessageDAO;
import dao.MessageDAOImpl;

import model.Messages;

public class MessagesService {
	public static MessageDAO r = new MessageDAOImpl();
	
	public static Messages getMessages(int reim_id) {
		return r.getMessages(reim_id);
	};
	public static boolean createMessages(int reim_id, int emp_id, String benco_message, String employee_message) {
		return r.createMessages(reim_id, emp_id, benco_message, employee_message);
	};
	public static List<Messages> getAllSupervisorMessages(int emp_id){
		return r.getAllSupervisorMessages(emp_id);
	};
	public static List<Messages> getEveryMessages(){
		return r.getEveryMessages();
	};
	
	public static boolean updateMessages(int reim_id, String benco_message) {
		return r.updateMessages(reim_id, benco_message);
	};
	
}
