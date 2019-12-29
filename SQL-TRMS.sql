-- ============== RESET =============================



--==================CREATE TABLES========================================

CREATE TABLE USERS
(
u_id NUMBER(10) PRIMARY KEY,
FirstName VARCHAR2(20),
LastName VARCHAR2(20),
Email VARCHAR2(50) UNIQUE NOT NULL,
password VARCHAR2(30) NOT NULL,
dept_id NUMBER(10) FK,
DirectSupervisor NUMBER(10),
AvailableReimbursement NUMBER(10)
);

CREATE TABLE DEPT
(
dept_id NUMBER(10) PRIMARY KEY,
deptName VARCHAR(20),
deptHead VARCHAR(20) FK
);

CREATE TABLE Reimbursements
(
r_id NUMBER(10) PRIMARY KEY,
u_id NUMBER(10) FK,
reimTotAmount NUMBER(10),
reimStatus NUMBER(10),
reimAmtApproved NUMBER(10),
dateSub Number(10), --look into date format
approvalDate Number(10),
justification VARCHAR(3000),
eventType NUMBER(10) FK,
);

CREATE TABLE APPROVALS
(

);

CREATE TABLE EVENTS
(
evnt_id NUMBER(10) PRIMARY KEY,
grade NUMBER(10), --FK
name VARCHAR(200),
beginDate NUMBER(10), --look into date format
endDate NUMBER(10), --look into date format
evtType NUMBER(10), --FK
time VARCHAR(8), --comeback to this
city VARCHAR(30),
state VARCHAR(30),
cost NUMBER(10),

);

CREATE TABLE Grades
(
grade_id NUMBER(10) PRIMARY KEY,
gFormat VARCHAR(200),
passing VARCHAR(10)
);
























































