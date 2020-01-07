package p0TRMS;

import java.sql.Connection;

import org.junit.Test;

import junit.framework.TestCase;
import model.Event;
import model.Reimbursement;
import service.EventService;
import service.MessagesService;
import service.ReimbursementService;
import utils.JDBC;

public class EventDAOTest extends TestCase {
	
	@Test
	public void testEventDao() throws Exception{
		Connection conn = JDBC.getConnection();
//		conn.setAutoCommit(false);

//			Event e = EventService.getEvent(11);
//			System.out.println(e);
//			
		MessagesService.getEveryMessages().forEach(System.out::println);
		MessagesService.getAllSupervisorMessages(2).forEach(System.out::println);;
//		EventService.createEvent("Seminars", "Nica", "Is  work", 200, "11/12/2015", "11/12/2015", "10:23", "500 Kohelr Dr", "18401", "Morgantown", "Chicago", 62669);

//		ReimbursementService.createReimbursement(3, 6, 300, "PENDING SUPERVISOR APPROVAL", 100, "10/25/1990", "PENDING APPROVAL", "THIS WAS GOOD", 7);
		

					
//		}finally {
//			conn.rollback();
//			conn.close();
//		}
//		
//		
//	}
	
	}
}


