package webservice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import model.Employee;
import service.EmployeeService;

public class EmployeeWebService {

		
//		public static void getEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException {
//			int id = Integer.parseInt(request.getParameter("emp_id"));
//			System.out.println("this is for jake" + id);
//			
//			Employee emp = EmployeeService.getEmployee(id);
//			
//			
//			System.out.println(emp);
////			ObjectMapper om = new ObjectMapper();
//			
//			
//			try {
//				String employeeJSON = om.writeValueAsString(emp);
//				System.out.println("Working 1");
//				response.getWriter().append(employeeJSON);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
// 
//			
//		}
		
		public static void login(HttpServletRequest request, HttpServletResponse response) throws SQLException {
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			System.out.println("The email: " + email + "Password: " + password);
			
			Employee emp = EmployeeService.getEmployeeLogin(email, password);
			System.out.println("Emp: " + emp);
			int emp_id = emp.getEmp_id();
			String firstName = emp.getFirstName();
//			int emp_id = emp.getEmp_id();
//			String firstName = emp.getFirstName();
//			String lastName = emp.getLastName();
//			System.out.println("emp_id" + emp_id);
			
			
			Gson gson = new Gson();
			
				try {
					String employeeJSON = gson.toJson(emp);
					response.getWriter().append(employeeJSON);
				} catch (IOException e) {
					e.printStackTrace();
				}
				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				session.setAttribute("password", password);
				session.setAttribute("emp", emp);
				session.setAttribute("emp_id", emp_id);
				session.setAttribute("firstName", firstName);
//				session.setAttribute("lastName", emp);
//	
			
		}
		
	public static void welcome(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("firstName");
		System.out.println(name);
		PrintWriter out;
		try {
			out = response.getWriter();
			out.write(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void destroySession(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		if(!session.isNew()) {
			session.invalidate();
			session = request.getSession();
		}
		
		try {
			response.sendRedirect(request.getContextPath() + "/login.html");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void getFunds(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int emp_id = (int) session.getAttribute("emp_id");
		System.out.println("get funds emp_id" + emp_id);
		double aFunds = EmployeeService.getEmployee(emp_id).getAvailableReimbursement();
		System.out.println(aFunds);
		PrintWriter out; 
		
		Gson gson = new Gson();
		try {
			String afundJSON = gson.toJson(aFunds);
			response.getWriter().append(afundJSON);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

	
}
