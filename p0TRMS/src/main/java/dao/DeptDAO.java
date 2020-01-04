package dao;

import java.util.List;

import model.Dept;

public interface DeptDAO {
	public Dept getDept(int dept_id);
	public Dept createDept(Dept dept);
	public List<Dept> getAllDepts();
	public Dept updateDept(int dept_id);
}
