package intspace.dao;

import java.util.List;

import intspace.dto.Intspace;
import util.Paging;

public interface IntspaceDao {

	// intspace 리스트 전체 조회
	//안씀
	
	public List SelectAll();
	// top 3 Union

	//paging ============================
	
	// 총 게시글 수 조회
	public int selectCntAll();

	// 페이징 리스트 조회
	public List selectPagingList(Paging paging);

	// 페이징 인덱스 조회
	public int selectindexCntAll(Intspace intspace);

	// 페이징 인덱스 리스트 조회
	public List selectPagingindexList(Paging paging);
	
	//==================================

	// 게시글 세부 조회
	public Intspace selectTableByintspaceno(Intspace intspace);

	// 저장
	public boolean save(Intspace intspace);
	//top 3 출력
	public List top3();
	
	//view Count 증가
	public boolean viewCount(int view , int intspaceno);
	//등급 체커
	public int gradecheck(String userid);
	//지우기
	public boolean delete(int intspaceno);
	
	//업데이트 저장
	public boolean updatesave(Intspace intspace);
	
	public Intspace top();
}
