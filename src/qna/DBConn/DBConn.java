package qna.DBConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	private static Connection conn = null; // null. 커넥션 아직 안 이루어짐 
	
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger"; 
	
	public static Connection getConnection() { // DB연결 메소드
		
		// DB연결이 이루어지지 않았을때만 동작 
		// 여러번의 호출을 방지 
		if(conn == null) {
			try {
				Class.forName(DRIVER); // 드라이버로드
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); // DB연결객체 생성
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return conn; // conn은 시작~종료동안 하나의 객체를 가지고 있음 
	}
		
	}
	

