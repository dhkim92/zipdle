package intspace.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import intspace.dto.Intspace;
import util.Paging;


public interface IntspaceService {
	
	public List<Intspace> getList();
	
		// 총 item 수
		public int getTotal();
		
		// 페이징 리스트 조회
		public List getPagingList(Paging paging);
		
		// index item 수
		public int getidxcount(Intspace intspace);
		
		//index 페이징 리스트 조회
		public List getPagingidxList(Paging paging);
		
		// item 상세 조회
		public Intspace view(Intspace intspace);
		
		// 저장
		public boolean save(Intspace intspace);
		
		//top 3 출력
		public List top3();
		// view counter 증가
		public boolean viewControll(int view, int intspaceno);
		//등급 체크
		public int gradecheck(String userid);
		
		//지우기
		public boolean delete(int intspaceno);
		
		//업데이트
		public boolean updatesave(Intspace intspace);
		
		public Intspace getintspacedata(HttpServletRequest request, HttpServletResponse response);
		
		public Intspace top1();
		
}
