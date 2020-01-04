package p0TRMS;

import java.sql.Connection;

import org.junit.Test;

import junit.framework.TestCase;
import model.Event;
import service.EventService;
import utils.JDBC;

public class EventDAOTest extends TestCase {
	
	@Test
	public void testEventDao() throws Exception{
		Connection conn = JDBC.getConnection();
		conn.setAutoCommit(false);
		

			Event e = EventService.getEvent(11);
			System.out.println(e);
					
//		}finally {
//			conn.rollback();
//			conn.close();
//		}
//		
		
	}
	

}


