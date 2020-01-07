package service;

import java.sql.SQLException;
import java.util.List;

import dao.GradeDAO;
import dao.GradeDAOImpl;
import model.Grade;


public class GradeService {
	public static GradeDAO gd = new GradeDAOImpl();
	
	public static Grade getGrade(int grade_id) {
		return gd.getGrade(grade_id);
	};
	public static Grade getGradeName(String gradeRecieved) {
		return gd.getGradeName(gradeRecieved);
	};
	public static boolean createGrade(String gFormat, String passing) {
		return gd.createGrade(gFormat, passing);
	};
	public static List<Grade> getAllGrade(){
		return gd.getAllGrades();
	};
	public static Grade updateGrade(int grade_id) {
		return gd.updateGrade(grade_id);
	};
	
	
	
}
