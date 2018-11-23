package contest.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contest.dto.ContestDto;
import reform.dto.CommentDto;
import reform.util.Paging;

public interface ContestService {

	// 파일 업로드
	public ContestDto getInfo(HttpServletRequest request, HttpServletResponse response );
	
	// 게시물 불러오기 
	public List<ContestDto> getAll();
	
	// 게시물 작성
	public void write(ContestDto contestdto);
	
	// 게시물 삭제
	public void delete(ContestDto contestdto); 
	
	// 게시물 수정
	public void update(ContestDto contestdto);
	
	// 댓글 가져오기
	public List<CommentDto> getComment(ContestDto contestdto);
	
	// 댓글 작성하기
	public void writeComment(CommentDto commentdto);
	
	// 댓글 삭제하기
	public void deleteComment(CommentDto commentdto);
	
	// 전체 게시글수 조회
	public int getTotal();
		
	// 페이징 리스트
	public List<ContestDto> getPaging (Paging paging); 
		
}
