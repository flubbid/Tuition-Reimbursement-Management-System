package model;

public class Grade {
int grade_id;
String gFormat, passing;
@Override
public String toString() {
	return "Grade [grade_id=" + grade_id + ", gFormat=" + gFormat + ", passing=" + passing + "]";
}
public Grade(int grade_id, String gFormat, String passing) {
	super();
	this.grade_id = grade_id;
	this.gFormat = gFormat;
	this.passing = passing;
}
public int getGrade_id() {
	return grade_id;
}
public void setGrade_id(int grade_id) {
	this.grade_id = grade_id;
}
public String getgFormat() {
	return gFormat;
}
public void setgFormat(String gFormat) {
	this.gFormat = gFormat;
}
public String getPassing() {
	return passing;
}
public void setPassing(String passing) {
	this.passing = passing;
}
	
	
}
