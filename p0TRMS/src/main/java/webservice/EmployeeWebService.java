package webservice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Employee;
import service.EmployeeService;
import utils.JDBC;

public class EmployeeWebService {

		
		public static void getEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException {
			int id = Integer.parseInt(request.getParameter("emp_id"));
			System.out.println("this is for jake" + id);
			
			Employee emp = EmployeeService.getEmployee(id);
		
			System.out.println(emp);
			ObjectMapper om = new ObjectMapper();
			
			
			try {
				String employeeJSON = om.writeValueAsString(emp);
				System.out.println("Working 1");
				response.getWriter().append(employeeJSON);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	
}
