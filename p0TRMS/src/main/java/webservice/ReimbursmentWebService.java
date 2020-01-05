package webservice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import model.Reimbursement;
import service.ReimbursementService;

public class ReimbursmentWebService {

	public static void reimList(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int emp_id = (int) session.getAttribute("emp_id");
		System.out.println("emp_id:" + emp_id);
		
//		String emp1 = request.getParameter("emp");
//		System.out.println("This is a test of the grabbed object" + emp1);
		
		//List<Employee> peasants = EmployeeService.getAllPeasants(emp_id);
		List<Reimbursement> reList = ReimbursementService.getAllReimbursement(emp_id);
		System.out.println(reList);
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
