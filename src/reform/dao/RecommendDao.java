package reform.dao;

import java.util.List;

import reform.dto.ReformDto;

public interface RecommendDao {
	// 리폼 정보방 추천하기 Dao
	
	// 특정 게시물에 대한 특정 유저의 추천여부 반환 1->추천, 0->비추천
	public int CountRecommend(ReformDto reformdto);
	
	// 추천하기
	public void insertRecommend(ReformDto reformdto);
	
	// 추천취소
	public void deleteRecommend(ReformDto reformdto);
	
	// 해당 게시물의 총 추천수 구하기
	public int TotalRecommend(ReformDto reformdto);
	
	// 아이디로 추천 게시물 boardIdx 리스트 구하기
	public List<ReformDto> selectbyId(ReformDto reformdto);
}
