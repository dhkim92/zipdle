package login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import interior.dto.IntEdit;
import login.dto.UserDto;
import util.DBConn;
import util.Paging;

public class MemberDaoImpl implements MemberDao {

	// DB 연결 객체
	private Connection conn = DBConn.getConnection();
	
	// JDBC 객체
	private PreparedStatement ps;	// 데이터 조회 ? 로 조회가능
	private Statement st;			// 데이터 조회	
	private ResultSet rs;			// 쿼리
	
	
	
	// 회원가입
	@Override
	public boolean insert(UserDto user) {
		
		// DB 쿼리
		String sql= "INSERT INTO zipuser ( userno, userid, userpw, username, userbirth, useremail, userphone, useraddress, usergrade, profileimg)"+
					"VALUES ( zipUser_seq.nextval, ?, ?, ?, to_date(?, 'RRMMDD'), ?, ?, ?, 1, default)";
			
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getUserId());
			ps.setString(2, user.getUserPw());
			ps.setString(3, user.getUserName());
			
			SimpleDateFormat format = new SimpleDateFormat("yymmdd");
			String dateString = format.format(user.getUserBirth());
										
			ps.setString(4, dateString);
			
			ps.setString(5, user.getUserEmail());
			ps.setString(6, user.getUserPhone());
			ps.setString(7, user.getUserAddress());
			
			ps.executeUpdate();
		
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("회원가입 실패!");
			
			// 회원가입 실패
			return false;
		} finally {
			
			try {
				if(ps!=null) { ps.close(); }
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		// 회원가입 성공
		return true;
	}// insert() end
	
	// 로그인
	@Override
	public int doLogin(UserDto user) {
		
		String sql = "SELECT * FROM zipuser WHERE userid=? AND userpw=?";
	
		int i=0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,  user.getUserId());
			ps.setString(2,  user.getUserPw());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				i = rs.getInt(1);
			}
			
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("로그인 실패!");
			return 0;
		
		}finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}		
		}
		return i;
	}

	
	
	// ID 찾기
	@Override
	public String idSearch(UserDto user) {
		
		//UserDto dto = new UserDto();
		String id = null;
		
		String sql = "SELECT * FROM zipuser WHERE username=? AND useremail=? AND userphone=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserEmail());
			ps.setString(3, user.getUserPhone());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				id = rs.getString("userid"); // DB에서 ID를 가져온다.
				
				
				//테스트 완료
				//System.out.println(id);
				
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("ID 찾기 실패!");
		}finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}		
		}
		
		return id;
	}
	
	
	// PW 수정
	@Override
	public void pwSearch(UserDto user) {
		
		String sql = "UPDATE zipuser SET userpw=? WHERE userid=? "
					+ "AND username=? AND useremail=? AND userphone=?";
		
		try {
			ps = conn.prepareStatement(sql);
		
			//view에서 입력값 가져오기
			ps.setString(1, user.getUserPw());			
			ps.setString(2, user.getUserId());
			ps.setString(3, user.getUserName());
			ps.setString(4, user.getUserEmail());
			ps.setString(5, user.getUserPhone());
	
/* 테스트	
			System.out.println("dao test");
			System.out.println(user.getUserPw());
			System.out.println(user.getUserId());
			System.out.println(user.getUserName());
			System.out.println(user.getUserEmail());
			System.out.println(user.getUserPhone());
*/		

			//쿼리 전송
			ps.executeUpdate();
			//ps.executeQuery();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("비밀번호 수정 실패!");
		} finally {
			
				try {
					if(ps!=null) {ps.close();}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
	}

	// ID찾기 판별
	@Override
	public boolean idCheck(UserDto user) {
		
		String sql = "select * from zipuser where username=? and useremail=? and userphone=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserEmail());
			ps.setString(3, user.getUserPhone());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {

				// DB에 데이터가 존재할때
				if(rs.getInt(1)>0) {
					return true;
				}			
			}	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}		
		}
		
		
		return false;
	}

	// 비밀번호 찾기 판별
	@Override
	public boolean pwCheck(UserDto user) {
		
		String sql = "SELECT * FROM zipUser WHERE userid=? AND username=? AND useremail=? AND userphone=?";
	
		try {
			ps = conn.prepareStatement(sql);
		
			ps.setString(1, user.getUserId());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getUserEmail());
			ps.setString(4, user.getUserPhone());
			
			// 쿼리전송 - 리턴값 String
			rs = ps.executeQuery();
			
			// 쿼리전송 - 리턴값 int
//			rs = ps.executeUpdate();
		
			// DB에서 입력한  데이터 찾기
			while(rs.next()) {

				// DB에 데이터가 존재할때
				if(rs.getInt(1)>0) {
					return true;
				}			
			}	
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}		
		}
		
		
		return false;
	}

	
	// ID 중복 확인
	@Override
	public boolean overlap(UserDto user) {
		
		String sql = "SELECT * FROM zipUser WHERE userid=?";
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserId());
			
			rs = ps.executeQuery();
	
			// test 완료
//			System.out.println(user.getUserId());
			
			// DB에서 입력한  데이터 찾기
			while(rs.next()) {

			// DB에 데이터가 존재할때
				if(rs.getInt(1)>0) {
					
					// false 리턴 -> ID중복됨 -> 회원가입 불가
					return false;
				}			
			}	
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}		
		}
		
		// 중복되지 않으면 회원가입 진행
		// 최종 view 판별은 controller 에서...
		return true;
	}

	//전체 회원 정보 리스트 가져오기
	@Override
	public List selectAll() {
		
		List<UserDto> list = new ArrayList<>();
		
		String sql = "select * from zipuser";
		
		try {
			st = conn.createStatement();
			
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				UserDto dto = new UserDto();
				
				dto.setUserId(rs.getString("userId"));
				dto.setUserPw(rs.getString("userPw"));
				dto.setUserName(rs.getString("userName"));
				dto.setUserBirth(rs.getDate("userBirth"));
				dto.setUserEmail(rs.getString("userEmail"));
				dto.setUserPhone(rs.getString("userPhone"));
				dto.setUserAddress(rs.getString("userAddress"));
				dto.setUserGrade(rs.getInt("userGrade"));
				dto.setProfileImg(rs.getString("profileImg"));
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(rs!=null)rs.close();
				if(st!=null)st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	// ID로 회원 정보 가져오기
	@Override
	public UserDto selectUser(UserDto user) {
		
		UserDto ud = new UserDto();
		
		String sql = "SELECT * FROM zipuser WHERE userid=?";
		
		try {
			ps = conn.prepareStatement(sql);
	
			ps.setString(1, user.getUserId());
			
/*			// 콘솔 테스트
			System.out.println(user.getUserId());*/
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
			
			ud.setUserNo(rs.getInt("userNo"));
			ud.setUserId(rs.getString("userId"));
			ud.setUserPw(rs.getString("userPw"));
			ud.setUserName(rs.getString("userName"));
			ud.setUserBirth(rs.getDate("userBirth"));
			ud.setUserEmail(rs.getString("userEmail"));
			ud.setUserPhone(rs.getString("userPhone"));
			ud.setUserAddress(rs.getString("userAddress"));
			ud.setUserGrade(rs.getInt("userGrade"));
			ud.setProfileImg(rs.getString("profileImg"));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		
		}finally {
			
			try {
				if(rs!=null)rs.close();
				if(st!=null)st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

		
		return ud;
		
	}

	// 회원등급 수정 (관리자 기능)
	@Override
	public boolean setGrade(String ids, int grade) {
		
		String sql = "UPDATE zipUser SET userGrade=? WHERE userid IN ("+ids+")";
		
		try {
			
			System.out.println(ids);
			
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, grade);
			
			ps.executeUpdate();
	
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("회원정보 수정 실패!");
			
			return false;
		}finally {
			
			try {
				if(ps!=null)ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	// 유저 프로필 이미지 경로 등록
	@Override
	public void setImg(UserDto user) {
		String sql = "UPDATE zipUser SET profileImg=? WHERE userId=?";
		
		try {
			ps = conn.prepareStatement(sql);
		
			ps.setString(1, user.getProfileImg());
			ps.setString(2, user.getUserId());
			
			ps.executeUpdate();
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			
			try {
				if(ps!=null)ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}

	// id로 등록된 유저 이미지 경로 가져오기
	@Override
	public String getImg(UserDto user) {
		
		String path = null;
		UserDto ud = new UserDto();
		
		String sql = "SELECT * FROM zipuser WHERE userid=?";
		
		try {
			ps = conn.prepareStatement(sql);
		
			ps.setString(1, user.getUserId());
			rs = ps.executeQuery();
		
			if(rs.next()) {
				
				path = rs.getString("profileImg");
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			
			try {
				if(ps!=null)ps.close();
				if(rs!=null)rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return path;
	}

	//유저 리스트 카운트 쿼리 전송
	@Override
	public int selectAllCnt() {
		
		String sql = "SELECT count(*) FROM zipUser where usergrade in(1,2)";
		
		int cnt = 0;
		
		try {
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
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

	// 페이징 카운트 대로 잘라서 유저 리스트 가져오기
	@Override
	public List<UserDto> selectPagingUser(Paging paging) {
		String sql = "select * from ("
				+" select rownum rnum, B.* from ("
				+" select * from zipUser"
					    + " where usergrade in (1,2) order by userNo"
					+ ") B"
					+ " order by rnum"
					+")"
					+ " where rnum between ? and ?";

		//System.out.println(sql);
		
		List<UserDto> list = new ArrayList<>();
		UserDto ut = null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ut = new UserDto();
				
				ut.setUserNo(rs.getInt("RNUM"));
				ut.setUserId(rs.getString("userId"));
				ut.setUserName(rs.getString("userName"));
				ut.setUserAddress(rs.getString("userAddress"));
				ut.setUserEmail(rs.getString("userEmail"));
				ut.setUserGrade(rs.getInt("userGrade"));
				
				list.add(ut);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(1);
			return null;
		} finally {
			try {
				if(rs!=null) rs.close();
				if(st!=null) st.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				System.out.println(2);
			}
		}
		return list;
		
	
	}



	
}
