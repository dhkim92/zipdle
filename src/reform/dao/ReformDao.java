package reform.dao;

import java.util.List;

import reform.dto.ReformDto;
import reform.util.Paging;
 
public interface ReformDao {
	// 리폼정보방 Dao
	
	// 게시판 불러오기 
	public List<ReformDto> selectAll(); 
	
	// 전체 게시글 수 조회 
	public int countAll();  

	// 글 작성
	public void insert(ReformDto reformdto); 
	
	// 글 삭제
	public void delete(ReformDto reformdto); 
	
	// 글 수정 
	public void update(ReformDto reformdto);
	
	// 글 조회 
	public ReformDto selectByIdx(ReformDto reformdto); 
	
	// 페이징 리스트 
	public List<ReformDto> Paging(Paging paging);
	
	// 추천수 높은 게시물 가져오기
	public ReformDto top1();
	
	
} 
