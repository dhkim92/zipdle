package contest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import contest.dto.ContestDto;
import reform.dto.CommentDto;
import reform.util.Paging;
import util.DBConn;

public class ContestDaoImpl implements ContestDao{
	
	private Connection conn = DBConn.getConnection();
	
	private Statement st;
	private PreparedStatement ps;
	private ResultSet rs;

	// 인테리어 자랑방
	
	// 게시물 불러오기
	@Override
	public List<ContestDto> selectAll() {
		List<ContestDto> conlist = new ArrayList<>();
		String sql = "select * from COMContest order by idx desc";
		
		try { 
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				ContestDto condto = new ContestDto();
				
				condto.setIdx(rs.getInt("idx"));
				condto.setId(rs.getString("id"));
				condto.setContent(rs.getString("content"));
				condto.setHashTag(rs.getString("hashTag"));
				condto.setwDate(rs.getDate("wDate"));
				condto.setFilePath(rs.getString("filePath"));
				
				conlist.add(condto);
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
		
		return conlist;
	}

	// 게시물 쓰기
	@Override
	public void insert(ContestDto contestdto) {
		String sql = "insert into COMContest("
				+ " idx, id, content, hashTag, wDate, filePath)"
				+ " values(cont_seq.nextval, ?, ?, ?, sysdate, ?)"; 
	
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, contestdto.getId());
			ps.setString(2, contestdto.getContent());
			ps.setString(3, contestdto.getHashTag());
			ps.setString(4, contestdto.getFilePath());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	
	}

	// 게시물 삭제
	@Override 
	public void delete(ContestDto contestdto) {
		String sql = "delete from COMContest"
				+ " where idx=?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, contestdto.getIdx());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	// 게시물 수정 
	@Override
	public void update(ContestDto contestdto) {
		String sql = "update COMContest set "
				+ " content=?, hashTag=?"
				+ " where idx=?" ;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, contestdto.getContent());
			ps.setString(2, contestdto.getHashTag());
			ps.setInt(3, contestdto.getIdx());
			
			ps.executeUpdate();
			
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

	// 댓글 불러오기
	@Override
	public List<CommentDto> selectComment(ContestDto contestdto) {
		List<CommentDto> commentlist = new ArrayList<>();
		String sql = "select * from (" + 
				"    select rownum rnum, R.* from (" + 
				"        select commentIdx, boardidx, commentId, commentContent, commentwdate " + 
				"        from comcomment where boardName='cont'" + 
				"        order by commentwDate desc) R " +  
				"        )order by rnum" ;  
		
		try {
			ps = conn.prepareStatement(sql); 
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				CommentDto commentdto = new CommentDto();
				
				commentdto.setCommentIdx(rs.getInt("commentIdx")); 
				commentdto.setBoardIdx(rs.getInt("boardIdx"));
				commentdto.setCommentId(rs.getString("commentId"));
				commentdto.setCommentContent(rs.getString("CommentContent"));
				commentdto.setCommentwDate(rs.getDate("CommentwDate"));
				 
				commentlist.add(commentdto);
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
		
		return commentlist;
	}

	// 댓글 작성하기
	@Override
	public void inserComment(CommentDto commentdto) {
		String sql = "INSERT INTO comcomment (commentIdx, boardidx, CommentId, CommentContent, commentwdate, boardName )" + 
				" VALUES (COMComment_seq.nextval, ?, ?, ?, sysdate, 'cont' )";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, commentdto.getBoardIdx()); 
			ps.setString(2, commentdto.getCommentId());
			ps.setString(3, commentdto.getCommentContent());
			
			ps.executeUpdate();
			
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

	// 댓글 삭제하기 
	@Override
	public void deleteComment(CommentDto commentdto) {
		String sql = "delete from comcomment"
				+ " where commentIdx=?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, commentdto.getCommentIdx());
			
			ps.executeUpdate();
			
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

	// 전체 게시글수 조회
	@Override
	public int countAll() {
		String sql = "select count(*) from COMcontest";
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

	// 페이징 리스트 
	@Override
	public List<ContestDto> paging(Paging paging) {
		
		String sql = "select * from (select rownum rnum, r.* from " + 
				"	(select * from COMContest order by idx desc)r" + 
				"	order by rnum)" + 
				"	where rnum between ? and ?"; 
		
		List<ContestDto> conpagelist = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ContestDto condto = new ContestDto();
				
				condto.setIdx(rs.getInt("idx"));
				condto.setId(rs.getString("id"));
				condto.setContent(rs.getString("content"));
				condto.setHashTag(rs.getString("hashTag"));
				condto.setwDate(rs.getDate("wDate"));
				condto.setFilePath(rs.getString("filePath"));
				
				conpagelist.add(condto);
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
		
		return conpagelist; 
	}
	
	
	
	
	
	
	
	
	

}










