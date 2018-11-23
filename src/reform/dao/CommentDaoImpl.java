package reform.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import reform.dto.CommentDto;
import reform.dto.ReformDto;
import util.DBConn;
 
public class CommentDaoImpl implements CommentDao{
	
	private Connection conn = DBConn.getConnection();
	
	private Statement st;
	private PreparedStatement ps;
	private ResultSet rs;
	
	// 댓글 불러오기 
	@Override
	public List<CommentDto> selectComment(ReformDto reformdto) {
		List<CommentDto> commentlist = new ArrayList<>();
		
		String sql = "select * from (" + 
				"    select rownum rnum, R.* from (" + 
				"        select commentIdx, boardidx, commentId, commentContent, commentwdate " + 
				"        from comcomment where boardidx=? and boardName='ref'" + 
				"        order by commentwDate desc) R " + 
				"        )order by rnum" ;
		
		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, reformdto.getIdx());

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
	public void insertComment(CommentDto commentdto) { 
		String sql = "INSERT INTO comcomment (commentIdx, boardidx, CommentId, CommentContent, commentwdate, boardName )" + 
				" VALUES (comcomment_seq.nextval, ?, ?, ?, sysdate, 'ref' )";
		
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

	/*public static void main(String[] args) {
		CommentDao dao = new CommentDaoImpl(); 
		ReformDto reformdto = new ReformDto();
		System.out.println(dao.selectComment(reformdto));   
	}*/
}
