package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import service.EmployeeService;

@WebServlet("")
public class ViewHomeServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
			List<Employee> employeeList;
			try {
				employeeList = EmployeeService.getAllEmployees();
				request.setAttribute("employeeList", employeeList);
				
				ServletContext context = getServletContext();
				RequestDispatcher dispatch = context.getRequestDispatcher("");
				dispatch.forward(request, response);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			

		
	}
	
}
