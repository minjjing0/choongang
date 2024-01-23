package och11;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//DB CRUD 관련된 DML 처리 Logic 
public class MemberDao {
	// 1.선언(Member 변수)
	Connection conn = null;

	// DBCP 
	private Connection getUserConn() throws SQLException  {
		   
	  try {
		   Context ctx = new InitialContext();
		   DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/OracleDB");
           // 2.선언 된것을 가지고 연결 
		   conn = ds.getConnection();
	  } catch (NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e.getMessage());
	  }
	   
	  return conn;
	}

	// insert Method 생성
    // getUserConn   사용
	// parameter --> MemberDto
	// return ->int 
	// PreparedStatement 
	// PreparedStatement 
	   public int insert(MemberDto member) throws SQLException {
			int result = 0; 
			// Connection conn = null;		 
			PreparedStatement pstmt = null;
			String sql = "insert into member1 values(?,?,?,sysdate)";
			try { 
				// 3.진짜 conn을 얻기 위해 한번은 반드시 실행 
				conn = getUserConn();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, member.getId());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				result = pstmt.executeUpdate();
			}catch(Exception e) { 
				System.out.println(e.getMessage()); 
			}finally{ 
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			}
			return result;		
	   }	
	
	
}
