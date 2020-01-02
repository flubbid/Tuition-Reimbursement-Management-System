package model;

public class Employee {

	private int emp_id, dept_id, supervisor;
	
	public Employee(int emp_id, String firstName, String lastName, String email, String password, int dept_id,
			int supervisor, double availableReimbursement) {
		super();
		this.emp_id = emp_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dept_id = dept_id;
		this.supervisor = supervisor;
		this.availableReimbursement = availableReimbursement;
	}
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", dept_id=" + dept_id + ", supervisor=" + supervisor
				+ ", availableReimbursement=" + availableReimbursement + "]";
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public int getsupervisor() {
		return supervisor;
	}
	public void setsupervisor(int supervisor) {
		this.supervisor = supervisor;
	}
	public double getAvailableReimbursement() {
		return availableReimbursement;
	}
	public void setAvailableReimbursement(double availableReimbursement) {
		this.availableReimbursement = availableReimbursement;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Employee() {
		super();
	}
	private double availableReimbursement;
	private String firstName, lastName, email, password;
	
}
