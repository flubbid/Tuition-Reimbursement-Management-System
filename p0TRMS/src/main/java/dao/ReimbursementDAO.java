package dao;


import java.util.List;

import model.Reimbursement;



public interface ReimbursementDAO {
	public Reimbursement getReimbursement(int reim_id);
	public boolean createReimbursement(int emp_id, int grade_id, int reimTotAmount, String reimStatus, int reimAmtApproved,
			String dateSub, String approvalDate, String justification, int evt_id);
	public List<Reimbursement> getAllReimbursement(int emp_id);
	public Reimbursement updateReimbursement(int reim_id);
	
}
