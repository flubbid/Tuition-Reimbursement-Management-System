COMMIT;
-- ============== RESET - DROPPING CONSTRAINT/TABLES=============================
ALTER TABLE employee DROP CONSTRAINT fk_employee_emp_id;
ALTER TABLE employee DROP CONSTRAINT fk_employee_dept_id;
--ALTER TABLE dept DROP CONSTRAINT fk_dept_empid;
ALTER TABLE reimbursement DROP CONSTRAINT fk_reimbursement_emp_id;
ALTER TABLE reimbursement DROP CONSTRAINT fk_reimbursement_evt_id;
ALTER TABLE reimbursement DROP CONSTRAINT fk_reimbursement_grade_id;
--ALTER TABLE grade DROP CONSTRAINT fk_grade_reim_id;  
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
);

CREATE TABLE DEPT
(
dept_id NUMBER(10) PRIMARY KEY,
deptName VARCHAR2(20),
deptHead NUMBER(20)
);

CREATE TABLE Reimbursement
(
reim_id NUMBER(10) PRIMARY KEY,
emp_id NUMBER(10) , 
grade_id NUMBER(10), --FK
reimTotAmount NUMBER(10),
reimStatus VARCHAR(30),
reimAmtApproved NUMBER(10),
dateSub VARCHAR2(50), 
approvalDate VARCHAR2(50),
justification VARCHAR2(3000),
evt_id NUMBER(10) --fk
);

CREATE TABLE EVENT
(
evt_id NUMBER(10) PRIMARY KEY,
evtType VARCHAR2(100), 
name VARCHAR2(200),
description VARCHAR2(500),
cost NUMBER(10),
beginDate VARCHAR2(50), 
endDate VARCHAR2(50),  
time VARCHAR2(50), --comeback to this
address VARCHAR2(50),
address2 VARCHAR2(50),
city VARCHAR2(30),
state VARCHAR2(30),
zipcode NUMBER(30)
);

CREATE TABLE Grade
(
grade_id NUMBER(10) PRIMARY KEY,
gFormat VARCHAR(200),
passing VARCHAR(10)
);


--=============================FOREIGN KEY===========================

--EMPLOYEE TABLE
ALTER TABLE employee ADD CONSTRAINT fk_employee_emp_id FOREIGN KEY (supervisor) REFERENCES employee(emp_id) ON DELETE CASCADE;
ALTER TABLE employee ADD CONSTRAINT fk_employee_dept_id FOREIGN KEY (dept_id) REFERENCES dept(dept_id) ON DELETE CASCADE;
--DEPT TABLE
--ALTER TABLE dept ADD CONSTRAINT fk_dept_empid FOREIGN KEY (deptHead) REFERENCES employee(emp_id) ON DELETE CASCADE;
--REIMBURSEMENT TABLE
ALTER TABLE reimbursement ADD CONSTRAINT fk_reimbursement_emp_id FOREIGN KEY (emp_id) REFERENCES employee(emp_id) ON DELETE CASCADE; 
ALTER TABLE reimbursement ADD CONSTRAINT fk_reimbursement_evt_id FOREIGN KEY (evt_id) REFERENCES event(evt_id) ON DELETE CASCADE;
ALTER TABLE reimbursement ADD CONSTRAINT fk_reimbursement_grade_id FOREIGN KEY (grade_id) REFERENCES grade(grade_id) ON DELETE CASCADE; 
--GRADE TABLE
--ALTER TABLE grade ADD CONSTRAINT fk_grade_reim_id FOREIGN KEY (reim_id) REFERENCES reimbursement(reim_id) ON DELETE CASCADE;  



--=============================ID Sequence========================
DROP SEQUENCE id_generator3;
DROP SEQUENCE id_generator4;
DROP SEQUENCE id_generator5;
DROP SEQUENCE id_generator6;

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

CREATE SEQUENCE id_generator6
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

CREATE OR REPLACE PROCEDURE add_Event(evtType VARCHAR2, name VARCHAR2, description VARCHAR2, cost NUMBER,
beginDate VARCHAR2, endDate VARCHAR2, time VARCHAR2, address VARCHAR2, address2 VARCHAR2, city VARCHAR2,
state VARCHAR2, zipcode number)
IS
BEGIN
INSERT INTO event VALUES (id_generator4.nextval, evtType, name, description, cost,
beginDate, endDate, time, address, address2, city,
state, zipcode);
END;

CREATE OR REPLACE PROCEDURE add_Reimbursement(
emp_id NUMBER, 
grade_id NUMBER, --FK
reimTotAmount NUMBER,
reimStatus VARCHAR,
reimAmtApproved NUMBER,
dateSub VARCHAR2, 
approvalDate VARCHAR2,
justification VARCHAR2,
evt_id NUMBER) --fk)
IS
BEGIN
INSERT INTO reimbursement VALUES (id_generator5.nextval, emp_id, grade_id, reimTotAmount, reimStatus,
reimAmtApproved, dateSub, approvalDate, justification, evt_id);
END;


CREATE OR REPLACE PROCEDURE add_Grades(
gFormat VARCHAR,
passing VARCHAR)
IS
BEGIN
INSERT INTO grade VALUES (id_generator6.nextval, gFormat, passing);
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

--=========================== EVENT DUMMY DATE ==============================================-
SELECT * FROM EVENT;

CALL ADD_EVENT('Seminars', 'Angular for Dummies', 'Description on Angular', 500, '01/01/2020', '01/06/2020', '05:30',
'500 Koehler Drv', '1100', 'Morgantown', 'WV', '75211');
CALL ADD_EVENT('University Courses', 'How to Internet', 'How to use Internet Explorer', 500, '01/01/2020', '01/06/2020', '05:30',
'500 Koehler Drv', '1100', 'Morgantown', 'WV', '75211');
CALL ADD_EVENT('Certification Preparation Classes', 'Angular for Dummies', 'Description on Angular', 500, '01/01/2020', '01/06/2020', '05:30',
'500 Koehler Drv', '1100', 'Morgantown', 'WV', '75211');
CALL ADD_EVENT('Technical Training', 'Angular for Dummies', 'Description on Angular', 500, '01/01/2020', '01/06/2020', '05:30',
'500 Koehler Drv', '1100', 'Morgantown', 'WV', '75211');
CALL ADD_EVENT('Other', 'Angular for Dummies', 'Description on Angular', 500, '01/01/2020', '01/06/2020', '05:30',
'500 Koehler Drv', '1100', 'Morgantown', 'WV', '75211');

--============================ Grade Format =================================================
CALL ADD_GRADES('percent grade', '70');
CALL ADD_GRADES('letter grade', 'B');
CALL ADD_GRADES('letter grade', 'A');
CALL ADD_GRADES('letter grade', 'D');

--=========================== REIMBURSEMENT AMOUNT ==========================================
--id_generator5.nextval, emp_id, grade_id, reimTotAmount, reimStatus,
--reimAmtApproved, dateSub, approvalDate, justification, evt_id);

CALL add_Reimbursement(2, 1, 600, 'PENDING SUPERVISOR APPROVAL', 500, '01/01/2020', 'PENDING APPROVAL', 'CLASS WAS FUN', 11);
CALL add_Reimbursement(3, 2, 200, 'PENDING SUPERVISOR APPROVAL', 100, '12/11/2019', 'PENDING APPROVAL', 'CLASS WAS FUN', 12);
CALL add_Reimbursement(3, 3, 500, 'PENDING DEPTHEAD APPROVAL', 500, '09/22/2019', 'PENDING APPROVAL', 'CLASS WAS FUN', 13);
CALL add_Reimbursement(3, 5, 900, 'PENDING BENCO APPROVAL', 600, '11/20/2019', 'PENDING APPROVAL', 'CLASS WAS FUN', 14);


COMMIT;















































