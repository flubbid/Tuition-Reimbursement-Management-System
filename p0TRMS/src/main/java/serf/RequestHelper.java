package serf;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservice.EmployeeWebService;

public class RequestHelper extends HttpServlet {


public static void process(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		//This method will delegate other methods
		//on a different layer of our application
		//to process the request.
		
		String uri = request.getRequestURI();
		
		System.out.println(uri);
		
		switch(uri) {
			

		
		case "/p0TRMS/homePage.do": {
			EmployeeWebService.reimList(request, response);
			break;
		}

		case "/p0TRMS/login.do": {
			EmployeeWebService.login(request, response);
			break;
		}
		default: {
			try {
				response.sendError(404);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		}
		
	}
	
	 
}
