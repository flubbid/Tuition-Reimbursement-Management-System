package service;

import java.util.List;

import dao.DeptDAO;
import dao.DeptDAOImpl;
import model.Dept;

public class DeptService {

public static DeptDAO dp = new DeptDAOImpl();
	
	public static Dept getDept(int dept_id) {
		return dp.getDept(dept_id);
	};
	public static void createDept(Dept dept) {
		dp.createDept(dept);
	};
	public static List<Dept> getAllDept(){
		return dp.getAllDepts();
	};
	public static Dept updateDept(int dept_id) {
		return dp.updateDept(dept_id);
	};
	
	
}
