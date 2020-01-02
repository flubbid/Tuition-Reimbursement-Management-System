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
AvailableReimbursement NUMBER(10),
CONSTRAINT fk_employee_supervisor FOREIGN KEY(supervisor)
REFERENCES employee(emp_id) ON DELETE CASCADE,
CONSTRAINT fk_employee_dept FOREIGN KEY (dept_id)
REFERENCES DEPT(dept_id) ON DELETE CASCADE
);

CREATE TABLE DEPT
(
dept_id NUMBER(10) PRIMARY KEY,
deptName VARCHAR(20),
deptHead VARCHAR(20),
CONSTRAINT fk_dept_employee FOREIGN KEY (deptHead)
REFERENCES employee(emp_id) ON DELETE CASCADE
);

CREATE TABLE Reimbursements
(
r_id NUMBER(10) PRIMARY KEY,
emp_id NUMBER(10) , 
grade_id NUMBER(10), --FK
reimTotAmount NUMBER(10),
reimStatus VARCHAR(30),
reimAmtApproved NUMBER(10),
dateSub DATE, 
approvalDate DATE,
justification VARCHAR2(3000),
evt_id NUMBER(10), --fk
CONSTRAINT fk_reimbursements_employee FOREIGN KEY (emp_id)
REFERENCES employee(emp_id) ON DELETE CASCADE,
CONSTRAINT fk_reimbursements_eveny FOREIGN KEY (evt_id)
REFERENCES events(evt_id) ON DELETE CASCADE,
CONSTRAINT fk_reimbursement_grade FOREIGN KEY (grade_id)
REFERENCES grades(grade_id) ON DELETE CASCADE
);



CREATE TABLE EVENTS
(
evnt_id NUMBER(10) PRIMARY KEY,
reim_id NUMBER(10),
name VARCHAR(200),
beginDate DATE, 
endDate DATE, 
evtType NUMBER(10), 
time VARCHAR(8), --comeback to this
city VARCHAR(30),
state VARCHAR(30),
cost NUMBER(10)
);

CREATE TABLE Grades
(
grade_id NUMBER(10) PRIMARY KEY,
reim_id NUMBER(10), --FK
gFormat VARCHAR(200),
passing VARCHAR(10),
CONSTRAINT fk_grade_reimbursement FOREIGN KEY (reim_id)
REFERENCES reimbursement(reim_id) ON DELETE CASCADE
);


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
INSERT INTO employees VALUES (id_generator3.nextval, firstname, lastname, email, password,
dept_id, supervisor, availablereiumbursement);
END;

CREATE OR REPLACE PROCEDURE add_Reimbursement(emp_id NUMBER, grade_id NUMBER, reimTotAmount NUMBER, reimStatus VARCHAR2,
reimAmtapproved NUMBER, dateSub date, justification VARCHAR2, status VARCHAR2, evt_id NUMBER)
IS
BEGIN
INSERT INTO employees VALUES (id_generator3.nextval, firstname, lastname, email, password,
dept_id, supervisor, availablereiumbursement);
END;

--Insert Values
SELECT * FROM EMPLOYEE;

INSERT INTO EMPLOYEE VALUES(1, 'Brendan', 'Wilson', 'brendanwilson@gmail.com', 'password', 2, 2, 1000);
INSERT INTO EMPLOYEE VALUES(2, 'Jimbo', 'Fisher', 'jimbofisher@gmail.com', 'password', 1, 1, 1000);
INSERT INTO EMPLOYEE VALUES(3, 'Nick', 'Saban', 'nicksaban@gmail.com', 'password', 1, 1, 1000);
INSERT INTO EMPLOYEE VALUES(4, 'Less', 'Miles', 'lessmiles@gmail.com', 'password', 1, 3, 1000);
COMMIT;




















































