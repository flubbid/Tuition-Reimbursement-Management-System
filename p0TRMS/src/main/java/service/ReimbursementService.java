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
	public static void createReimbursement(Reimbursement reim) {
		r.createReimbursement(reim);
	};
	public static List<Reimbursement> getAllReimbursement(){
		return r.getAllReimbursement();
	};
	public static Reimbursement updateReimbursement(int reim_id) {
		return r.updateReimbursement(reim_id);
	};
	
}
