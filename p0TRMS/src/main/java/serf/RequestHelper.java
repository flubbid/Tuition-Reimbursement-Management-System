package serf;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ReimbursementService;
import webservice.EmployeeWebService;
import webservice.ReimbursmentWebService;

public class RequestHelper extends HttpServlet {


public static void process(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		//This method will delegate other methods
		//on a different layer of our application
		//to process the request.
		
		String uri = request.getRequestURI();
		
		System.out.println(uri);
		
		switch(uri) {
			

		
//		case "/p0TRMS/homePage.do": {
//			EmployeeWebService.reimList(request, response);
//			break;
//		}
		case "/p0TRMS/reimList.do": {
			ReimbursmentWebService.reimList(request, response);
			break;
		}
		case "/p0TRMS/welcome.do": {
			EmployeeWebService.welcome(request, response);
			break;
		}
		case "/p0TRMS/logout.do": {
			EmployeeWebService.destroySession(request, response);
			break;
		}

		case "/p0TRMS/login.do": {
			EmployeeWebService.login(request, response);
			break;
		}
		case "/p0TRMS/funds.do": {
			EmployeeWebService.getFunds(request, response);
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
