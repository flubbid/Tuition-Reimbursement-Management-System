package model;

public class Reimbursement {
int reim_id, emp_id, grade_id,  evt_id;
int reimTotAmount, reimAmtApproved;
String reimStatus, dateSub, approvalDate, justification;
public Reimbursement(int emp_id, int grade_id, int reimTotAmount, String reimStatus, int reimAmtApproved,
		String dateSub, String approvalDate, String justification, int evt_id) {
	super();
	this.emp_id = emp_id;
	this.grade_id = grade_id;
	this.reimTotAmount = reimTotAmount;
	this.reimStatus = reimStatus;
	this.reimAmtApproved = reimAmtApproved;
	this.dateSub = dateSub;
	this.approvalDate = approvalDate;
	this.justification = justification;
	this.evt_id = evt_id;
}
public Reimbursement(int reim_id, int emp_id, int grade_id, int evt_id, int reimTotAmount, int reimAmtApproved,
		String reimStatus, String dateSub, String approvalDate, String justification) {
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
@Override
public String toString() {
	return "Reimbursement [reim_id=" + reim_id + ", emp_id=" + emp_id + ", grade_id=" + grade_id + ", evt_id=" + evt_id
			+ ", reimTotAmount=" + reimTotAmount + ", reimStatus=" + reimStatus + ", reimAmtApproved=" + reimAmtApproved
			+ ", dateSub=" + dateSub + ", approvalDate=" + approvalDate + ", justification=" + justification + "]";
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
public int getGrade_id() {
	return grade_id;
}
public void setGrade_id(int grade_id) {
	this.grade_id = grade_id;
}
public int getEvt_id() {
	return evt_id;
}
public void setEvt_id(int evt_id) {
	this.evt_id = evt_id;
}
public int getReimTotAmount() {
	return reimTotAmount;
}
public void setReimTotAmount(int reimTotAmount) {
	this.reimTotAmount = reimTotAmount;
}
public int getReimAmtApproved() {
	return reimAmtApproved;
}
public void setReimAmtApproved(int reimAmtApproved) {
	this.reimAmtApproved = reimAmtApproved;
}
public String getReimStatus() {
	return reimStatus;
}
public void setReimStatus(String reimStatus) {
	this.reimStatus = reimStatus;
}
public String getDateSub() {
	return dateSub;
}
public void setDateSub(String dateSub) {
	this.dateSub = dateSub;
}
public String getApprovalDate() {
	return approvalDate;
}
public void setApprovalDate(String approvalDate) {
	this.approvalDate = approvalDate;
}
public String getJustification() {
	return justification;
}
public void setJustification(String justification) {
	this.justification = justification;
}








}