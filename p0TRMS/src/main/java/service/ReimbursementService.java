package service;

import java.util.List;

import dao.ReimbursementDAO;
import dao.ReimbursementDAOImpl;
import model.Reimbursement;

public class ReimbursementService {
	
	public static ReimbursementDAO r = new ReimbursementDAOImpl();
	
	public static Reimbursement getReimbursement(int reim_id) {
		return r.getReimbursement(reim_id);
	};
	public static boolean createReimbursement(int emp_id, int grade_id, int reimTotAmount, String reimStatus, int reimAmtApproved,
			String dateSub, String approvalDate, String justification, int evt_id) {
		return r.createReimbursement(emp_id, grade_id, reimTotAmount, reimStatus, reimAmtApproved,
				dateSub, approvalDate, justification, evt_id);
	};
	public static List<Reimbursement> getAllReimbursement(int emp_id){
		return r.getAllReimbursement(emp_id);
	};
	public static Reimbursement updateReimbursement(int reim_id) {
		return r.updateReimbursement(reim_id);
	};
	
}
