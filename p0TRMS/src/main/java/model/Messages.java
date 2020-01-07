package model;

public class Messages {
	int reim_id, emp_id;
	String benco_message, employee_message;
	public Messages(int reim_id, int emp_id, String benco_message, String employee_message) {
		super();
		this.reim_id = reim_id;
		this.emp_id = emp_id;
		this.benco_message = benco_message;
		this.employee_message = employee_message;
	}
	@Override
	public String toString() {
		return "Messages [reim_id=" + reim_id + ", emp_id=" + emp_id + ", benco_message=" + benco_message
				+ ", employee_message=" + employee_message + "]";
	}
	public int getReim_id() {
		return reim_id;
	}
	public void setReim_id(int reim_id) {
		this.reim_id = reim_id;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getBenco_message() {
		return benco_message;
	}
	public void setBenco_message(String benco_message) {
		this.benco_message = benco_message;
	}
	public String getEmployee_message() {
		return employee_message;
	}
	public void setEmployee_message(String employee_message) {
		this.employee_message = employee_message;
	}
	
	
	
}
