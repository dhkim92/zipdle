package reform.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import reform.dto.ReformDto;
import util.DBConn;

public class RecommendDaoImpl implements RecommendDao {
	
	private Connection conn = DBConn.getConnection();
	
	private PreparedStatement ps;
	private ResultSet rs;

	// 특정 게시물에 대한 특정 유저의 추천여부 반환 1->추천, 0->비추천
	@Override
	public int CountRecommend(ReformDto reformdto) {
		String sql = "select count(*) from refrecommend"
				+ " where userid=?"
				+ " and boardIdx=?";
		 
		int cnt = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, reformdto.getId());
			ps.setInt(2, reformdto.getIdx());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				cnt = rs.getInt(1);
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
		return cnt;
	}

	// 추천하기
	// 특정 게시물에 대한 특정 유저의 추천여부 DB에 기록
	@Override
	public void insertRecommend(ReformDto reformdto) {
		String sql = "INSERT INTO refrecommend (userid, boardIdx)"
				+ " VALUES( ?, ? )";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, reformdto.getId());
			ps.setInt(2, reformdto.getIdx()); 
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	// 추천 취소
	// 특정 게시물에 대한 특정 유저의 추천여부 DB에서 삭제
	@Override
	public void deleteRecommend(ReformDto reformdto) {
		String sql = "DELETE from refrecommend"
				+ " WHERE userid=?" 
				+ "	AND boardIdx=?"; 
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, reformdto.getId());
			ps.setInt(2, reformdto.getIdx());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		 
	}
 
	// 해당 게시물의 전체 추천개수
	@Override
	public int TotalRecommend(ReformDto reformdto) {
		String sql = "SELECT COUNT(*) FROM refrecommend"
				+ " WHERE boardIdx=?";
		
		int cnt = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, reformdto.getIdx());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				cnt = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		
		return cnt;
	}

	
	// 아이디로 추천 게시물 boardIdx 불러오기
	@Override
	public List<ReformDto> selectbyId(ReformDto reformdto) {
		List<ReformDto> list = new ArrayList<>();
		
		String sql = "select * from comreform " + 
				"    where idx in " + 
				"       ( select boardidx from refrecommend " + 
				"            where userid=?)"  ;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, reformdto.getId());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ReformDto reformDto = new ReformDto();
				
				reformDto.setIdx(rs.getInt("idx"));
				reformDto.setId(rs.getString("id"));
				reformDto.setTitle(rs.getString("title"));
				reformDto.setContent(rs.getString("content"));
				reformDto.setwDate(rs.getDate("wDate"));
				
				list.add(reformDto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { 
				if(ps!=null) ps.close();
				if(rs!=null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	

}








