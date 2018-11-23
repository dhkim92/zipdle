package mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import login.dto.UserDto;
import util.DBConn;

public class MyPageDaoImpl implements MyPageDao {

	// DB 연결 객체
	private Connection conn = DBConn.getConnection();
	
	// JDBC 객체
	private PreparedStatement ps;	// 데이터 조회 ? 로 조회
//	private Statement st;			// 데이터 조회 DB에 존재하는 컬럼 이름 으로 조회
	private ResultSet rs;			// 쿼리
	
	
	
	
	// 비밀번호 수정 DB 쿼리 전송 메소드
	@Override
	public void cgPw(UserDto user) {
		
		String sql = "UPDATE zipuser SET userpw=? WHERE userid=? ";
				
		try {
			ps = conn.prepareStatement(sql);
			
			// view에서 입력값 가져오기 - controller에서 전달받음
			ps.setString(1, user.getUserPw());
			ps.setString(2, user.getUserId());
			
			//쿼리 전송
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("비밀번호 수정 실패!");
		
		} finally {
			
			try {
				if(ps!=null) {ps.close();}
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				System.out.println("비밀번호 수정 DB객체 close 실패");
			}	
		}
	} // cgPw() end

	
	
	// 회원정보 수정 DB 쿼리 전송 메소드
	@Override
	public void udInfo(UserDto user) {

		String sql = "UPDATE zipuser SET useremail=? , userphone=? , useraddress=? WHERE userid=? ";
		
		try {
			ps = conn.prepareStatement(sql);
		
			// view에서 입력값 가져오기 - controller에서 전달받음
			ps.setString(1, user.getUserEmail());
			ps.setString(2, user.getUserPhone());
			ps.setString(3, user.getUserAddress());
			ps.setString(4, user.getUserId());
			
			//쿼리 전송
			ps.executeUpdate();
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("회원정보 수정 실패!");
		} finally {
			
			try {
				if(ps!=null) {ps.close();}
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				System.out.println("회원정보 수정 DB객체 close 실패");
			}	
		}
		
		
	}


	// 회원 탈퇴 DB 쿼리 전송 메소드
	@Override
	public boolean delInfo(UserDto user) {
	
		//쿼리
		String sql = "DELETE FROM zipuser WHERE userid=? and userpw=? and username=? and useremail=? and userphone=?";
		
		try {
			ps = conn.prepareStatement(sql);
		
			// view에서 입력값 가져오기 - controller에서 전달받음
			ps.setString(1, user.getUserId());
			ps.setString(2, user.getUserPw());
			ps.setString(3, user.getUserName());
			ps.setString(4, user.getUserEmail());
			ps.setString(5, user.getUserPhone());
			
			//쿼리 전송
			ps.executeQuery();
		
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("회원 탈퇴 실패");
			
			// 회원탈퇴 실패
			return false;
		}finally {
			
			try {
				if(ps!=null) {ps.close();}
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				System.out.println("회원정보 수정 DB객체 close 실패");
			}	
		}
		
		
		// 회원탈퇴 성공
		return true;
		
	}



	@Override
	public int cntCart(UserDto user) {
		
		//쿼리
		String sql = "SELECT COUNT(*) FROM basket WHERE userid=?";
		
		int cnt=0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getUserId());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				cnt = rs.getInt(1);
			}
			
		
		
		} catch (SQLException e) {
			e.getMessage();
			System.out.println("장바구니 리스트 카운트 조회 실패!");
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cnt;
	}
	
	
	
	

}
