package reform.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reform.dto.CommentDto;
import reform.dto.ReformDto;
import reform.util.Paging;

public interface ReformService {
	
	// 파일 업로드
	public ReformDto getInfo(HttpServletRequest request, HttpServletResponse response);
	
	// 게시판 불러오기 !
	public List<ReformDto> getList(); 
	
	// 전체 게시글 수 조회 
	public int getTotal(); 
	
	// 페이징 리스트 조회  
	public List<ReformDto> getPaging(Paging paging); 
	 
	// 글 작성 !
	public void write(ReformDto reformdto);
	
	// 글 수정 !
	public void update(ReformDto reformdto);
	
	// 글 삭제 !
	public void delete(ReformDto reformdto);
	
	// 게시글 보기 !
	public ReformDto view(ReformDto reformdto);
	
	// 댓글 불러오기
	public List<CommentDto> viewComment(ReformDto reformdto);
	
	// 댓글 작성하기
	public void writeComment(CommentDto commentdto);
	
	// 댓글 삭제하기
	public void deleteComment(CommentDto commentdto);
	
	// 추천상태 확인
	public boolean recommendCheck(ReformDto reformdto);
	
	// 추천 로직
	public boolean recommend(ReformDto reformdto);
	
	// 추천수 구하기
	public int getRecommend(ReformDto reformdto);
	
	// 좋아요 누른 게시물 정보
	public List<ReformDto> getLike(ReformDto Reformdto);
	
	// 추천수 높은 게시글 가져오기
	public ReformDto top();
	
}
