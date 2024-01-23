package och12;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//singleton + DBCP  -> Memory 절감 + DOS공격 
public class MemberDao {
	private static MemberDao instance;
	private MemberDao() {
	}
	public  static MemberDao getInstance() {
		if(instance == null) {
			instance = new MemberDao();
		}
		
		return instance;
	}
	
	private Connection getConnection()  {
		Connection conn = null;
		
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return conn;
		
	}

	// PreparedStatement
	public int check(String id, String passwd) throws SQLException {
	
		int result  = 0;  				
		Connection conn = null;
		String sql  = "select passwd from member2 where id=?"; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		try { 
			conn  = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			// id OK
			if (rs.next()) {
				String dbPasswd = rs.getString(1);
				if (dbPasswd.equals(passwd)) result = 1;
				else result = 0;
			} else   result = -1;
		} catch(Exception e) { 
			System.out.println(e.getMessage());
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return result;
	}

	public int insert(Member2 member) throws SQLException {
		int result = 0;  				
        Connection conn = null;
		String sql = "insert into member2 values(?,?,?,?,?,sysdate)"; 
		PreparedStatement pstmt = null; 
		try { 
			conn  = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getAddress());
			pstmt.setString(5, member.getTel());
			result = pstmt.executeUpdate();
		} catch(Exception e) { System.out.println(e.getMessage());
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return result;
	}

}
