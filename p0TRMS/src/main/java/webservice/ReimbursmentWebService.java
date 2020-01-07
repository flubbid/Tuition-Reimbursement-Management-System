package webservice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import model.Messages;
import model.Reimbursement;
import service.EmployeeService;
import service.EventService;
import service.GradeService;
import service.MessagesService;
import service.ReimbursementService;

public class ReimbursmentWebService {


	public static void sendMessages(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int emp_id = (int) session.getAttribute("emp_id");
		String position = (String) session.getAttribute("position");
		
		String message = request.getParameter("message");
		int reim_idForm = Integer.parseInt(request.getParameter("reim_id"));
		int emp_idForm = Integer.parseInt(request.getParameter("emp_id"));
		
		if(position.contentEquals("PENDING_EMPLOYEE")) {
			MessagesService.updateMessages(reim_idForm, message);
		} else {
			MessagesService.createMessages(reim_idForm, emp_idForm, message, " ");
		}
		
		
	}
	
	public static void showMessages (HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int emp_id = (int) session.getAttribute("emp_id");
		String position = (String) session.getAttribute("position");
		
		if(position.contentEquals("PENDING_EMPLOYEE")) {
		List<Messages> reList =	MessagesService.getAllSupervisorMessages(emp_id);
		
		Gson gson = new Gson();
		
		try {
			
			String pendingReim = gson.toJson(reList);
			System.out.println(pendingReim);
			PrintWriter out = response.getWriter();
			response.getWriter().append(pendingReim);		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		} else if(position.contentEquals("PENDING_BENCO")) {
			List<Messages> reList =	MessagesService.getEveryMessages();
			

			Gson gson = new Gson();
			
			try {
				
				String pendingReim = gson.toJson(reList);
				System.out.println(pendingReim);
				PrintWriter out = response.getWriter();
				response.getWriter().append(pendingReim);		
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	
	public static void reimList(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int emp_id = (int) session.getAttribute("emp_id");
		String position = (String) session.getAttribute("position");
		System.out.println("emp_id:" + emp_id);
		
//		String emp1 = request.getParameter("emp");
//		System.out.println("This is a test of the grabbed object" + emp1);
		
		//List<Employee> peasants = EmployeeService.getAllPeasants(emp_id);
		if(position.contentEquals("PENDING_EMPLOYEE")) {
		List<Reimbursement> reList	= ReimbursementService.getAllSupervisorReimbursement(emp_id);
		Gson gson = new Gson();
		
		try {
			
			String pendingReim = gson.toJson(reList);
			System.out.println(pendingReim);
			PrintWriter out = response.getWriter();
			response.getWriter().append(pendingReim);		
		} catch (IOException e) {
			e.printStackTrace();
		}
		} else {
		List<Reimbursement> reList = ReimbursementService.getAllSupervisorReimbursement(position);	
		Gson gson = new Gson();
		
		try {
			
			String pendingReim = gson.toJson(reList);
			System.out.println(pendingReim);
			PrintWriter out = response.getWriter();
			response.getWriter().append(pendingReim);		
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		
		

	}

	public static void approvePending(HttpServletRequest request, HttpServletResponse response) {
		int reim_id = Integer.parseInt(request.getParameter("reim_id"));
		
		HttpSession session = request.getSession();
		String position = (String) session.getAttribute("position");
		
		if(position.contentEquals("PENDING_EMPLOYEE")) {
			System.out.println("Employees can't Approve things!");
		} else if(position.contentEquals("PENDING_SUPERVISOR")) {
			ReimbursementService.updateReimbursement(reim_id, "PENDING_DEPTHEAD");
			System.out.println("UPDATED TO DEPTHEAD");
		} else if(position.contentEquals("PENDING_DEPTHEAD")) {
			ReimbursementService.updateReimbursement(reim_id, "PENDING_BENCO");
			System.out.println("UPDATED TO BENCO");
		} else if(position.contentEquals("PENDING_BENCO")) {
			ReimbursementService.updateReimbursement(reim_id, "PENDING_APPROVED");
			System.out.println("APPROVED");
		}
		
		
	}
	
	public static void denyPending(HttpServletRequest request, HttpServletResponse response) {
		int reim_id = Integer.parseInt(request.getParameter("reim_id"));
		int emp_id = Integer.parseInt(request.getParameter("emp_id"));
		
		HttpSession session = request.getSession();
		String position = (String) session.getAttribute("position");
		
		if(position.contentEquals("PENDING_EMPLOYEE")) {
			System.out.println("Employees can't deny things!");
		} else if(position.contentEquals("PENDING_SUPERVISOR")) {
			ReimbursementService.updateReimbursement(reim_id, "DENIED_BY_SUPERVISOR");
			System.out.println("DENIED_BY_SUPERVISOR");
		} else if(position.contentEquals("DENIED_BY_DEPTHEAD")) {
			ReimbursementService.updateReimbursement(reim_id, "DENIED_BY_DEPTHEAD");
			System.out.println("DENIED_BY_DEPTHEAD");
		} else if(position.contentEquals("PENDING_BENCO")) {
			ReimbursementService.updateReimbursement(reim_id, "DENIED_BY_BENCO");
			System.out.println("DENIED_BY_BENCO");
		}
		
		
	}
	public static void adjustAvailableBalance(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int emp_id = (int) session.getAttribute("emp_id");
		int adjustedCost = Integer.parseInt(request.getParameter("adjustedCost"));
		System.out.println("Adjusted CosT: " + adjustedCost);
		
		int currentCash = EmployeeService.getEmployee(emp_id).getAvailableReimbursement(); 
		System.out.println("Current Cash: " + currentCash);
		String name = EmployeeService.getEmployee(emp_id).getFirstName();
		
		int availMoney = currentCash - adjustedCost;
		System.out.println("avail money:" + availMoney);
		EmployeeService.updateEmployeeBalance(emp_id, availMoney);
		
		System.out.println("The money on hand for emp_id: " + name + " is: " + availMoney);
	}
	
	public static void reimFormInput(HttpServletRequest request, HttpServletResponse response) {
		String gradingFormat = request.getParameter("gradingFormat");
		String gradeRecieved = request.getParameter("gradeRecieved");
		System.out.println("this is string" + gradeRecieved);
		String evtType = request.getParameter("evtType");
		String eventName = request.getParameter("eventName");
		int eventCost = Integer.parseInt(request.getParameter("eventCost"));

		String eventAddress = request.getParameter("eventAddress");
		String eventAddress2 = request.getParameter("eventAddress2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		int zipcode = Integer.parseInt(request.getParameter("zipcode"));
		System.out.println(zipcode);
		String beginDate = request.getParameter("beginDate");
		String endDate = request.getParameter("endDate");
		String time = request.getParameter("time");
		String eventDescription = request.getParameter("eventDescription");
		String justification = request.getParameter("justification");
		String reimStatus = request.getParameter("reimStatus");
		int reimAmtApproved = Integer.parseInt(request.getParameter("reimAmtApproved"));
		String dateSub = request.getParameter("dateSub");
		String approvalDate = request.getParameter("approvalDate");
		
		HttpSession session = request.getSession();
		int emp_id = (int) session.getAttribute("emp_id");
		
		GradeService.createGrade(gradingFormat, gradeRecieved);
		EventService.createEvent(evtType, eventName, eventDescription, eventCost, beginDate, endDate, time, eventAddress, eventAddress2, city, state, zipcode);
		int grade_id = GradeService.getGradeName(gradeRecieved).getGrade_id();
		System.out.println(grade_id);
		int evt_id = EventService.getEventDescription(eventDescription).getEvt_id();
		System.out.println(evt_id);
		ReimbursementService.createReimbursement(emp_id, grade_id, eventCost, reimStatus, reimAmtApproved, dateSub, approvalDate, justification, evt_id);
		
	
		
		try {	
			response.getWriter().append("Reim form was added");		
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}
	
}
