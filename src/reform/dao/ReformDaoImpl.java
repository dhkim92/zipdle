package reform.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import intspace.dto.Intspace;
import reform.dto.ReformDto;
import util.DBConn;

public class ReformDaoImpl implements ReformDao {

	private Connection conn = DBConn.getConnection();
	
	private Statement st; 
	private PreparedStatement ps;
	private ResultSet rs;  
	 
	// 게시판 불러오기
	@Override
	public List<ReformDto> selectAll() { 
		List<ReformDto> reflist = new ArrayList<>();
		String sql = "select * from COMReform order by idx desc";  
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				ReformDto reform = new ReformDto();
				
				reform.setIdx(rs.getInt("idx"));
				reform.setId(rs.getString("id"));
				reform.setTitle(rs.getString("title"));
				reform.setContent(rs.getString("content")); 
				reform.setRecommend(rs.getInt("recommend"));
				reform.setFilePath(rs.getString("filePath"));
				reform.setwDate(rs.getDate("wDate")); 
				
				reflist.add(reform);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				if(rs!=null) rs.close();
				if(st!=null) st.close();
				
			} catch (SQLException e) { 
				e.printStackTrace();
			}
		}
		 
		return reflist; 
		
	}

	// 전체 게시글 수 조회 
	@Override
	public int countAll() { 
		String sql = "select count(*) from COMReform"; 
		int cnt = 0; 
		
		try {
			st = conn.createStatement(); 
			rs = st.executeQuery(sql);
			
			rs.next();
			cnt = rs.getInt(1); 
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally { 
				try {
					if(rs!=null) rs.close();
					if(st!=null) st.close();
					
				} catch (SQLException e) { 
					e.printStackTrace();
				}
		}  
		
		return cnt; 
		
	}
	
	// 글 작성
	@Override
	public void insert(ReformDto reformdto) { 
		String sql = "insert into COMReform(idx, id, title, content, recommend, filePath, wDate)"
				+ " values (reform_seq.nextval, ?, ?, ?, ?, ?, sysdate)";
	
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, reformdto.getId()); 
			ps.setString(2, reformdto.getTitle());
			ps.setString(3, reformdto.getContent()); 
			ps.setInt(4, reformdto.getRecommend());
			ps.setString(5, reformdto.getFilePath());
			
			ps.executeUpdate(); // 업데이트
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally { 
			
				try {
					if(ps!=null) ps.close();
					
				} catch (SQLException e) { 
					e.printStackTrace();
				}
		}
		
	}
	
	// 글 수정
	@Override
	public void update(ReformDto reformdto) {
		String sql = "update COMReform set title=?, content=?, filepath=? where idx=?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, reformdto.getTitle());
			ps.setString(2, reformdto.getContent());
			ps.setString(3, reformdto.getFilePath()); 
			ps.setInt(4, reformdto.getIdx());
			
			ps.executeUpdate(); // 업데이트
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally { 
				try {
					
					if(ps!=null) ps.close();
					
				} catch (SQLException e) {
	 
					e.printStackTrace(); 
				}
		} 
	
	}
 
	// 글 삭제 
	@Override
	public void delete(ReformDto reformdto) {
		String sql = "delete from COMReform"
				+ " where idx=?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, reformdto.getIdx()); 
			
			ps.executeUpdate();
			
		} catch (SQLException e) { 
			e.printStackTrace();
		} 
	}

	// 게시글 idx로 글  조회
	@Override
	public ReformDto selectByIdx(ReformDto reformdto) {
		String sql = "select * from COMReform"
				+ " where idx=?";   
		
		try {  
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, reformdto.getIdx()); 
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				reformdto.setIdx(rs.getInt("idx"));
				reformdto.setId(rs.getString("id"));
				reformdto.setTitle(rs.getString("title"));
				reformdto.setContent(rs.getString("content"));
				reformdto.setRecommend(rs.getInt("recommend"));
				reformdto.setwDate(rs.getDate("wDate")); 
				reformdto.setFilePath(rs.getString("filePath")); 
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close(); 
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			} 
		}
		return reformdto;
	}

	// 페이징
	@Override
	public List<ReformDto> Paging(reform.util.Paging paging) { 
		
		String sql = "select * from (select rownum rnum, r.* from " + 
				"    (select * from COMReform order by idx desc)r " + 
				"     order by rnum) " + 
				"     where rnum between ? and ?";
		
		List<ReformDto> reformlist = new ArrayList<>();
		  
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ReformDto dto = new ReformDto();
				
				dto.setIdx(rs.getInt("idx"));
				dto.setId(rs.getString("id"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content")); 
				dto.setRecommend(rs.getInt("recommend"));
				dto.setFilePath(rs.getString("filePath")); 
				dto.setwDate(rs.getDate("wDate"));   
				 
				reformlist.add(dto); 
			}
			
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
		 
		return reformlist;
	}
	
	// 추천수 높은 게시물 가져오기
	@Override
	public ReformDto top1() {
		ReformDto reform = new ReformDto();

		String sql = "SELECT * FROM (   SELECT rownum rnum, T.* FROM ( SELECT * FROM comreform ORDER BY recommend DESC )T ORDER BY rnum ) WHERE rnum BETWEEN 1 AND 1";

		try {
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			rs.next();

			reform.setIdx(rs.getInt("idx"));
			reform.setId(rs.getString("id"));
			reform.setTitle(rs.getString("title"));
			reform.setContent(rs.getString("content")); 
			reform.setRecommend(rs.getInt("recommend"));
			reform.setFilePath(rs.getString("filePath"));
			reform.setwDate(rs.getDate("wDate")); 
			

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("@@top1 fail@@");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.getMessage();
				System.out.println("@@top1 close fail@@");
			}
		}
		return reform;
	}
	
}








