package dao;


import java.util.List;

import model.Reimbursement;



public interface ReimbursementDAO {
	public Reimbursement getReimbursement(int reim_id);
	public void createReimbursement(Reimbursement reim);
	public List<Reimbursement> getAllReimbursement();
	public Reimbursement updateReimbursement(int reim_id);
	
}
