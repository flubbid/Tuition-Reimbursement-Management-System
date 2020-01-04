package model;

public class Dept {
int dept_id, deptHead;
String deptName;
@Override
public String toString() {
	return "Dept [dept_id=" + dept_id + ", deptHead=" + deptHead + ", deptName=" + deptName + "]";
}
public Dept(int dept_id, int deptHead, String deptName) {
	super();
	this.dept_id = dept_id;
	this.deptHead = deptHead;
	this.deptName = deptName;
}
public int getDept_id() {
	return dept_id;
}
public void setDept_id(int dept_id) {
	this.dept_id = dept_id;
}
public int getDeptHead() {
	return deptHead;
}
public void setDeptHead(int deptHead) {
	this.deptHead = deptHead;
}
public String getDeptName() {
	return deptName;
}
public void setDeptName(String deptName) {
	this.deptName = deptName;
}

}
