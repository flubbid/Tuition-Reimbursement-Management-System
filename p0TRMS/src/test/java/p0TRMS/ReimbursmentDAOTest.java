package p0TRMS;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.List;

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
//		conn.setAutoCommit(false);
		
// try {
	 
		ReimbursementService.createReimbursement(3, 10, 300, "PENDING SUPERVISOR APPROVAL", 100, "10/25/1990", "10/25/1995", "THIS WAS GOOD", 21);
		
//		Reimbursement e = ReimbursementService.getReimbursement(4);
//		
//		List<Reimbursement> reimList = ReimbursementService.getAllReimbursement(3);
//		reimList.forEach(System.out::println);
//			System.out.println(e);
//			
//			assertNotNull(e);
//					
//	}finally {
//			conn.rollback();
//			conn.close();
//		}
		
		
	}

}
