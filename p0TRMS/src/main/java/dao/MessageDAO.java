package dao;

import java.util.List;

import model.Messages;

public interface MessageDAO {
	public Messages getMessages(int reim_id);
	public boolean createMessages(int reim_id, int emp_id, String benco_message, String employee_message);
	public List<Messages> getAllSupervisorMessages(int emp_id);
	public boolean updateMessages(int reim_id, String reimStatus);
	public List<Messages> getEveryMessages();

	
}
