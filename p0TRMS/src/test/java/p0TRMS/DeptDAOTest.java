package p0TRMS;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import model.Dept;
import service.DeptService;
import utils.JDBC;

class DeptDAOTest {

	@Test
	public void testDeptDao() throws Exception{
		Connection conn = JDBC.getConnection();
		conn.setAutoCommit(false);
		
 try {
	 
		Dept dept = DeptService.getDept(1);
			System.out.println(dept);
			
			assertNotNull(dept);
					
	}finally {
			conn.rollback();
			conn.close();
		}
		
		
	}
}
