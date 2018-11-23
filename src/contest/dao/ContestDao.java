package contest.dao;

import java.util.List;

import contest.dto.ContestDto;
import reform.dto.CommentDto;
import reform.util.Paging;

public interface ContestDao {
	// 인테리어 자랑방 Dao
	
	// 게시물 불러오기
	public List<ContestDto> selectAll();
	
	// 게시물 쓰기
	public void insert(ContestDto contestdto);
	
	// 게시물 삭제
	public void delete(ContestDto contestdto);
	
	// 게시물 수정
	public void update(ContestDto contestdto);
	
	// 댓글 불러오기
	public List<CommentDto> selectComment(ContestDto contestdto);
	
	// 댓글 작성하기
	public void inserComment(CommentDto commentdto);
	
	// 댓글 삭제하기
	public void deleteComment(CommentDto commentdto);
	
	// 전체 게시글수 조회
	public int countAll();
		
	// 페이징 리스트
	public List<ContestDto> paging(Paging paing);  

}
