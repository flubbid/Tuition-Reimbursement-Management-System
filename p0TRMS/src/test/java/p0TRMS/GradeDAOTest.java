package p0TRMS;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import model.Grade;
import service.GradeService;
import utils.JDBC;

class GradeDAOTest {

	@Test
	public void testGradeDao() throws Exception{
		Connection conn = JDBC.getConnection();
//		conn.setAutoCommit(false);
		
	GradeService.createGrade("percent grade", "89");
		
// try {
//	 
////		Grade g = GradeService.getGrade(1);
////			System.out.println(g);
////			
////			assertNotNull(g);
////					
//	}finally {
//			conn.rollback();
//			conn.close();
//		}
//		
		
	}

}
