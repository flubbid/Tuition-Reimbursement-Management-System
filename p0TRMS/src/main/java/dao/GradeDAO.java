package dao;

import java.util.List;

import model.Grade;

public interface GradeDAO {
	public Grade getGrade(int grade_id);
	public Grade createGrade(Grade grade);
	public List<Grade> getAllGrades();
	public Grade updateGrade(int grade_id);
}
