COMMIT;
-- ============== RESET =============================
DROP TABLE EMPLOYEE;

--==================CREATE TABLES========================================
SELECT * FROM EMPLOYEE;
CREATE TABLE EMPLOYEE
(
emp_id NUMBER(10) PRIMARY KEY,--1
FirstName VARCHAR2(20),
LastName VARCHAR2(20),
Email VARCHAR2(50) UNIQUE NOT NULL,
password VARCHAR2(30) NOT NULL,
dept_id NUMBER(10), --FK 2
supervisor NUMBER(10),
AvailableReimbursement NUMBER(10)
--CONSTRAINT fk_employee_supervisor FOREIGN KEY(supervisor)
--REFERENCES employee(emp_id) ON DELETE CASCADE,
--CONSTRAINT fk_employee_dept FOREIGN KEY (dept_id)
--REFERENCES DEPT(dept_id) ON DELETE CASCADE
);

CREATE TABLE DEPT
(
dept_id NUMBER(10) PRIMARY KEY,
deptName VARCHAR(20),
deptHead VARCHAR(20)
--CONSTRAINT fk_dept_employee FOREIGN KEY (deptHead)
--REFERENCES employee(emp_id) ON DELETE CASCADE
);

CREATE TABLE Reimbursements
(
r_id NUMBER(10) PRIMARY KEY,
emp_id NUMBER(10) , 
reimTotAmount NUMBER(10),
reimStatus NUMBER(10),
reimAmtApproved NUMBER(10),
dateSub DATE, 
approvalDate Number(10),
justification VARCHAR(3000),
eventType NUMBER(10), --fk
--CONSTRAINT fk_reimbursements_employee REFERENCES emp_id
--REFERENCES employee(emp_id) ON DELETE CASCADE
);

--CREATE TABLE APPROVALS
--(
--
--);

CREATE TABLE EVENTS
(
evnt_id NUMBER(10) PRIMARY KEY,
grade NUMBER(10), --FK
name VARCHAR(200),
beginDate DATE, --look into date format
endDate DATE, --look into date format
evtType NUMBER(10), --FK
time VARCHAR(8), --comeback to this
city VARCHAR(30),
state VARCHAR(30),
cost NUMBER(10)

);

CREATE TABLE Grades
(
grade_id NUMBER(10) PRIMARY KEY,
gFormat VARCHAR(200),
passing VARCHAR(10)
);


--=============================FOREIGN KEY CONSTRAINTS========================


--Insert Values
SELECT * FROM EMPLOYEE;

INSERT INTO EMPLOYEE VALUES(1, 'Brendan', 'Wilson', 'brendanwilson@gmail.com', 'password', 2, 2, 1000);
INSERT INTO EMPLOYEE VALUES(2, 'Jimbo', 'Fisher', 'jimbofisher@gmail.com', 'password', 1, 1, 1000);
INSERT INTO EMPLOYEE VALUES(3, 'Nick', 'Saban', 'nicksaban@gmail.com', 'password', 1, 1, 1000);
INSERT INTO EMPLOYEE VALUES(4, 'Less', 'Miles', 'lessmiles@gmail.com', 'password', 1, 3, 1000);
COMMIT;




















































