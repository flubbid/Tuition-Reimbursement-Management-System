COMMIT;
-- ============== RESET - DROPPING CONSTRAINT/TABLES=============================
ALTER TABLE employee DROP CONSTRAINT fk_employee_emp_id;
ALTER TABLE employee DROP CONSTRAINT fk_employee_dept_id;
ALTER TABLE dept DROP CONSTRAINT fk_dept_empid;
ALTER TABLE reimbursement DROP CONSTRAINT fk_reimbursement_emp_id;
ALTER TABLE reimbursement DROP CONSTRAINT fk_reimbursement_evt_id;
ALTER TABLE reimbursement DROP CONSTRAINT fk_reimbursement_grade_id;
ALTER TABLE grade DROP CONSTRAINT fk_grade_reim_id;  
DROP TABLE EVENT;
DROP TABLE REIMBURSEMENT;
DROP TABLE GRADE;
DROP TABLE EMPLOYEE;
DROP TABLE DEPT;

--==================CREATE TABLES========================================
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
deptName VARCHAR2(20),
deptHead NUMBER(20)
--CONSTRAINT fk_dept_employee FOREIGN KEY (deptHead)
--REFERENCES employee(emp_id) ON DELETE CASCADE
);

CREATE TABLE Reimbursement
(
reim_id NUMBER(10) PRIMARY KEY,
emp_id NUMBER(10) , 
grade_id NUMBER(10), --FK
reimTotAmount NUMBER(10),
reimStatus VARCHAR(30),
reimAmtApproved NUMBER(10),
dateSub DATE, 
approvalDate DATE,
justification VARCHAR2(3000),
evt_id NUMBER(10) --fk
--CONSTRAINT fk_reimbursements_employee FOREIGN KEY (emp_id)
--REFERENCES employee(emp_id) ON DELETE CASCADE,
--CONSTRAINT fk_reimbursements_eveny FOREIGN KEY (evt_id)
--REFERENCES events(evt_id) ON DELETE CASCADE,
--CONSTRAINT fk_reimbursement_grade FOREIGN KEY (grade_id)
--REFERENCES grades(grade_id) ON DELETE CASCADE
);

CREATE TABLE EVENT
(
evt_id NUMBER(10) PRIMARY KEY,
name VARCHAR(200),
beginDate DATE, 
endDate DATE, 
evtType VARCHAR(30), 
time VARCHAR(8), --comeback to this
city VARCHAR(30),
state VARCHAR(30),
cost NUMBER(10)
);

CREATE TABLE Grade
(
grade_id NUMBER(10) PRIMARY KEY,
reim_id NUMBER(10), --FK
gFormat VARCHAR(200),
passing VARCHAR(10)
--CONSTRAINT fk_grade_reimbursement FOREIGN KEY (reim_id)
--REFERENCES reimbursement(reim_id) ON DELETE CASCADE
);


--=============================FOREIGN KEY===========================

--EMPLOYEE TABLE
ALTER TABLE employee ADD CONSTRAINT fk_employee_emp_id FOREIGN KEY (emp_id) REFERENCES employee(emp_id) ON DELETE CASCADE;
ALTER TABLE employee ADD CONSTRAINT fk_employee_dept_id FOREIGN KEY (dept_id) REFERENCES dept(dept_id) ON DELETE CASCADE;
--DEPT TABLE
ALTER TABLE dept ADD CONSTRAINT fk_dept_empid FOREIGN KEY (deptHead) REFERENCES employee(emp_id) ON DELETE CASCADE;
--REIMBURSEMENT TABLE
ALTER TABLE reimbursement ADD CONSTRAINT fk_reimbursement_emp_id FOREIGN KEY (emp_id) REFERENCES employee(emp_id) ON DELETE CASCADE; 
ALTER TABLE reimbursement ADD CONSTRAINT fk_reimbursement_evt_id FOREIGN KEY (evt_id) REFERENCES event(evt_id) ON DELETE CASCADE;
ALTER TABLE reimbursement ADD CONSTRAINT fk_reimbursement_grade_id FOREIGN KEY (grade_id) REFERENCES grade(grade_id) ON DELETE CASCADE; 
--GRADE TABLE
ALTER TABLE grade ADD CONSTRAINT fk_grade_reim_id FOREIGN KEY (reim_id) REFERENCES reimbursement(reim_id) ON DELETE CASCADE;  



--=============================ID Sequence========================
DROP SEQUENCE id_generator3;
DROP SEQUENCE id_generator4;
DROP SEQUENCE id_generator5;

CREATE SEQUENCE id_generator3
        MINVALUE 1
        START WITH 1
        INCREMENT BY 1;
CREATE SEQUENCE id_generator4
        MINVALUE 1
        START WITH 1
        INCREMENT BY 1;
CREATE SEQUENCE id_generator5
        MINVALUE 1
        START WITH 1
        INCREMENT BY 1;

-- =====================================CREATE/CALL PROCEDURS ==========================================
         
CREATE OR REPLACE PROCEDURE add_Employee(firstname VARCHAR2, lastname VARCHAR2, email VARCHAR2, password VARCHAR2,
dept_id NUMBER, supervisor NUMBER, AVAILABLEREIMBURSEMENT NUMBER)
IS
BEGIN
INSERT INTO employee VALUES (id_generator3.nextval, firstname, lastname, email, password,
dept_id, supervisor, availablereimbursement);
END;


--Insert Values
SELECT * FROM EMPLOYEE;
SELECT * FROM DEPT;
SELECT * FROM EVENT;
SELECT * FROM REIMBURSEMENT;
SELECT * FROM GRADE;


-- =========================== ADDS EMPLOYEE DUMMY TABLE DATA ==================================-
INSERT INTO EMPLOYEE VALUES(1, 'Admin', 'Adminnington', 'admin@gmail.com', 'password', 2, 2, 1000);
CALL add_Employee('Brendan', 'Wilson', 'brendanwilson@gmail.com', 'password', 2, 2, 1000);
CALL add_Employee('Jimbo', 'Fisher', 'jimbofisher@gmail.com', 'password', 1, 1, 1000);
CALL add_Employee('Nick', 'Saban', 'nicksaban@gmail.com', 'password', 1, 1, 1000);
CALL add_Employee('Less', 'Miles', 'lessmiles@gmail.com', 'password', 1, 3, 1000);

-- =========================== ADDS DEPT DUMMY TABLE DATA ==================================-
INSERT INTO dept VALUES(1, 'English', 4);
INSERT INTO dept VALUES(2, 'Science', 3);
INSERT INTO dept VALUES(3, 'Turf Management', 2);
INSERT INTO dept VALUES(4, 'WoodWorking', 5);

COMMIT;















































