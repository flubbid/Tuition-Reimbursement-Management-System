package p0TRMS;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import model.Event;
import model.Reimbursement;
import service.EventService;
import service.ReimbursementService;
import utils.JDBC;

class ReimbursmentDAOTest {

	@Test
	public void testReimbursementDao() throws Exception{
		Connection conn = JDBC.getConnection();
		conn.setAutoCommit(false);
		
 try {
	 
		Reimbursement e = ReimbursementService.getReimbursement(4);
			System.out.println(e);
			
			assertNotNull(e);
					
	}finally {
			conn.rollback();
			conn.close();
		}
		
		
	}

}
