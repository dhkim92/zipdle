package reform.dao;

import java.util.List;

import reform.dto.CommentDto;
import reform.dto.ReformDto;

public interface CommentDao {
	// 리폼 정보방 댓글 Dao
	
	// 댓글 불러오기
	public List<CommentDto> selectComment(ReformDto reformdto); 

	// 댓글 작성하기
	public void insertComment(CommentDto commentdto);
	
	// 댓글 삭제하기
	public void deleteComment(CommentDto commentdto);
}
