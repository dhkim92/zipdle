package interior.dao;

import java.util.List;

import interior.dto.IntEdit;
import interior.dto.IntList;
import util.Paging;

public interface IntListDao {
	
		//총 견적 조회
		public List<IntList> selectAll();
		
		//작성자로 견적 조회
		public IntList selectAll(String writer);
		
		//글번호로 견적 조회
		public IntList selectAll(int listNo);
		
		//견적 삽입
		public boolean insertInt(IntList intList);
		
		//견적 정보 수정
		public IntList updateInt(IntList intList);
		
		//견적번호로 견적 삭제
		public boolean deleteInt(int listNo);
		
		// 총 게시글 수 가져오기 (count 값)
		public int selectCntAll();
		
		//페이징한 견적 현황 가져오기
		public List<IntList> selectPagingList(Paging paging);
		
		public List<IntList> selectuserPagingList(Paging paging, IntList il);
		
		// 조회수 올리기
		public void updateHit(IntList intList);
		
		// 내 견적 가져오기
		public int countList(IntList intList);
		
		public int selectUserCntAll(IntList il);
		
}
