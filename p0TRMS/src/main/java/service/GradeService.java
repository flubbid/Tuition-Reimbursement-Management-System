package service;

import java.sql.SQLException;
import java.util.List;

import dao.GradeDAO;
import dao.GradeDAOImpl;
import model.Grade;


public class GradeService {
	public static GradeDAO gd = new GradeDAOImpl();
	
	public static Grade getGrade(int reim_id) {
		return gd.getGrade(reim_id);
	};
	public static void createGrade(Grade reim) {
		gd.createGrade(reim);
	};
	public static List<Grade> getAllGrade(){
		return gd.getAllGrades();
	};
	public static Grade updateGrade(int reim_id) {
		return gd.updateGrade(reim_id);
	};
	
	
	
}
