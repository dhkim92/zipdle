package interior.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import interior.dto.IntEdit;
import interior.dto.IntList;
import util.DBConn;
import util.Paging;

public class IntListDaoImpl implements IntListDao {
	
	private Connection conn = DBConn.getConnection();
	
	private Statement st;
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public List<IntList> selectAll() {
		
		ArrayList<IntList> list = new ArrayList<>();
		
		String sql ="select * from IntList";
		
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				IntList dto = new IntList();
				
				dto.setListNo(rs.getInt("listNo"));
				dto.setWriter(rs.getString("writer"));
				dto.setIntSpace(rs.getString("intSpace"));
				dto.setIntName(rs.getString("intName"));
				dto.setImgPath(rs.getString("imgPath"));
				dto.setIntPrice(rs.getInt("intPrice"));
				dto.setContent(rs.getString("content"));
				dto.setHit(rs.getInt("hit"));
				dto.setWrittenDate(rs.getDate("writtenDate"));
				
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.getMessage();
			System.out.println("IntList selectAll fail...");
			return null;
			
		} finally {
			try {
				if(rs!=null) rs.close();
				if(st!=null) st.close();
				
			} catch (SQLException e) {
				e.getMessage();
				System.out.println("IntList selectAll close fail...");
				return null;
			}
		}
		
		return list;
	}

	@Override
	public IntList selectAll(String writer) {
		
		IntList dto = new IntList();
		
		String sql ="select * from IntList where writer=?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, writer);
			
			while(rs.next()) {
				
				dto.setListNo(rs.getInt("listNo"));
				dto.setWriter(writer);
				dto.setIntSpace(rs.getString("intSpace"));
				dto.setIntName(rs.getString("intName"));
				dto.setImgPath(rs.getString("imgPath"));
				dto.setIntPrice(rs.getInt("intPrice"));
				dto.setContent(rs.getString("content"));
				dto.setHit(rs.getInt("hit"));
				dto.setWrittenDate(rs.getDate("writtenDate"));
				
				
			}
			
		} catch (SQLException e) {
			e.getMessage();
			System.out.println("IntList selectAll(writer) fail...");
			return null;
			
		} finally {
			try {
				if(rs!=null) rs.close();
				if(st!=null) st.close();
				
			} catch (SQLException e) {
				e.getMessage();
				System.out.println("IntList selectAll(writer) close fail...");
				return null;
			}
		}
		
		return dto;
	}
	
	@Override
	public IntList selectAll(int listNo) {
		
		IntList dto = new IntList();
		
		String sql ="select * from IntList where listNo=?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, listNo);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				dto.setListNo(rs.getInt("listNo"));
				dto.setWriter(rs.getString("writer"));
				dto.setIntSpace(rs.getString("intSpace"));
				dto.setIntName(rs.getString("intName"));
				dto.setImgPath(rs.getString("imgPath"));
				dto.setIntPrice(rs.getInt("intPrice"));
				dto.setContent(rs.getString("content"));
				dto.setHit(rs.getInt("hit"));
				dto.setWrittenDate(rs.getDate("writtenDate"));
				
				
			}
			
		} catch (SQLException e) {
			e.getMessage();
			System.out.println("IntList selectAll(listNo) fail...");
			return null;
			
		} finally {
			try {
				if(rs!=null) rs.close();
				if(st!=null) st.close();
				
			} catch (SQLException e) {
				e.getMessage();
				System.out.println("IntList selectAll(listNo) close fail...");
				return null;
			}
		}
		
		return dto;
	}

	@Override
	public boolean insertInt(IntList intList) {
		
		String sql = "insert into IntList values(intList_seq.nextval,?,?,?,?,?,?,0,sysdate)";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, intList.getWriter());
			ps.setString(2, intList.getIntSpace());
			ps.setString(3, intList.getIntName());
			ps.setString(4, intList.getImgPath());
			ps.setInt(5, intList.getIntPrice());
			ps.setString(6, intList.getContent());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.getMessage();
			System.out.println("IntList insertList fail...");
			
			return false;
		
		} finally {
				try {
					if(ps!=null) ps.close();
					
				} catch (SQLException e) {
					e.getMessage();
					System.out.println("IntList insertList close fail...");
					
					return false;
				}
		}
		return true;
	}

	@Override
	public IntList updateInt(IntList intList) {
		
		IntList dto = new IntList();
		
		String sql = "UPDATE IntList SET intName=?, intSpace=?, intPrice=?, imgPath=?, content=? where listNo=?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, intList.getIntName());
			ps.setString(2, intList.getIntSpace());
			ps.setInt(3, intList.getIntPrice());
			ps.setInt(4, intList.getListNo());
			ps.setString(5, intList.getImgPath());
			ps.setString(6, intList.getContent());
			
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				dto.setListNo(rs.getInt("listNo"));
				dto.setWriter(rs.getString("writer"));
				dto.setIntSpace(rs.getString("intSpace"));
				dto.setIntName(rs.getString("intName"));
				dto.setImgPath(rs.getString("imgPath"));
				dto.setIntPrice(rs.getInt("intPrice"));
				dto.setContent(rs.getString("content"));
				dto.setHit(rs.getInt("hit"));
				dto.setWrittenDate(rs.getDate("writtenDate"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("updateList fail...");
			return null;
		} finally {
			try {
				if(ps!=null)ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return dto;
	}

	@Override
	public boolean deleteInt(int listNo) {
		
		String sql = "delete from IntList where listNo=?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, listNo);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("deleteList fail...");
			return false;
			
		} finally {
			
			try {
				if(ps!=null)ps.close();
			} catch (SQLException e) {
				System.out.println("deleteList close fail...");
			}
		}
		
	return true;
	}

	@Override
	public int selectCntAll() {
			String sql = "SELECT count(*) FROM IntList";
		
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
	
	@Override
	public int selectUserCntAll(IntList il) {
			String sql = "SELECT count(*) FROM IntList where writer='"+il.getWriter()+"'";
		
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

	@Override
	public List<IntList> selectPagingList(Paging paging) {
		String sql = "select * from ("
				+" select rownum rnum, B.* from ("
				+" select * from intList"
					    + " order by listNo desc"
					+ ") B"

					+ " order by rnum"
					+")"
					+ " where rnum between ? and ?";
		
		List<IntList> intList = new ArrayList<>();
		
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				IntList dto = new IntList();
				dto.setListNo(rs.getInt("listNo"));
				dto.setWriter(rs.getString("writer"));
				dto.setIntSpace(rs.getString("intSpace"));
				dto.setIntName(rs.getString("intName"));
				dto.setImgPath(rs.getString("imgPath"));
				dto.setContent(rs.getString("content"));
				dto.setHit(rs.getInt("hit"));
				dto.setWrittenDate(rs.getDate("writtenDate"));
				
				
				intList.add(dto);
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
		return intList;
	}
	
	@Override
	public List<IntList> selectuserPagingList(Paging paging, IntList il) {
		String sql = "select * from ("
				+" select rownum rnum, B.* from ("
				+" select * from intList where writer='"+il.getWriter()
					    + "' order by listNo desc"
					+ ") B"

					+ " order by rnum"
					+")"
					+ " where rnum between ? and ?";
		
		List<IntList> intList = new ArrayList<>();
		
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				IntList dto = new IntList();
				dto.setListNo(rs.getInt("listNo"));
				dto.setWriter(rs.getString("writer"));
				dto.setIntSpace(rs.getString("intSpace"));
				dto.setIntName(rs.getString("intName"));
				dto.setImgPath(rs.getString("imgPath"));
				dto.setContent(rs.getString("content"));
				dto.setHit(rs.getInt("hit"));
				dto.setWrittenDate(rs.getDate("writtenDate"));
				
				
				intList.add(dto);
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
		return intList;
	}

	
	
	@Override
	public void updateHit(IntList intList) {
		
		String sql = "UPDATE IntList SET hit= hit+1 where listNo=?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, intList.getListNo());
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("updateHit fail...");
		} finally {
			try {
				if(ps!=null)ps.close();
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				
			}
			
		}
	}

	@Override
	public int countList(IntList intList) {
		
		String sql ="select count(*) from IntList where writer=?";
		
		int cnt=0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, intList.getWriter());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				cnt = rs.getInt(1);
			}
			
			
		} catch (SQLException e) {
			e.getMessage();
			System.out.println("intList count fail...");
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
