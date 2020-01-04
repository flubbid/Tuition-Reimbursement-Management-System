package model;

public class Reimbursement {
int reim_id, emp_id, grade_id,  evt_id;
double reimTotAmount, reimAmtApproved;
String reimStatus, dateSub, approvalDate, justification;
@Override
public String toString() {
	return "Reimbursement [reim_id=" + reim_id + ", emp_id=" + emp_id + ", grade_id=" + grade_id + ", evt_id=" + evt_id
			+ ", reimTotAmount=" + reimTotAmount + ", reimAmtApproved=" + reimAmtApproved + ", reimStatus=" + reimStatus
			+ ", dateSub=" + dateSub + ", approvalDate=" + approvalDate + ", justification=" + justification + "]";
}
public Reimbursement(int reim_id, int emp_id, int grade_id, int evt_id, double reimTotAmount, 
		double reimAmtApproved, String reimStatus, String dateSub, 
		String approvalDate, String justification) {
	super();
	this.reim_id = reim_id;
	this.emp_id = emp_id;
	this.grade_id = grade_id;
	this.evt_id = evt_id;
	this.reimTotAmount = reimTotAmount;
	this.reimAmtApproved = reimAmtApproved;
	this.reimStatus = reimStatus;
	this.dateSub = dateSub;
	this.approvalDate = approvalDate;
	this.justification = justification;
}



}
