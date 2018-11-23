package interior.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interior.dto.IntEdit;
import interior.dto.IntList;
import login.dto.UserDto;
import util.Paging;
import util.PagingEdit;

public interface IntService {

		
		/**
		 * 총 에디터 조회
		 * @return List
		 */
		public List<IntEdit> getEdit();
		
		/**
		 * 페이징해서 총 에디터 조회
		 * @param paging
		 * @return List
		 */
		public List getPagingEditorList(Paging paging);
		
		/**
		 * 에디터번호로 에디터 조회
		 * @param EditNo
		 * @return IntEdit
		 */
		public IntEdit editListByEditNo(int EditNo);
		
		/**
		 * 에디터 등급으로 정보 가져오기
		 * @param int
		 * @return List
		 */
		public List<IntEdit> getEditByGrade(int grade);
		
		
		
		
		
		/**
		 * 에디터 정보 수정
		 * @param IntEdit
		 * @return boolean
		 */
		public boolean editUpdate(IntEdit IntEdit);
		
		/**
		 * 사업자등록번호로 삭제
		 * @param int EditNo
		 * @return boolean
		 */
		public boolean editDeleteByEditNo(int resiNo);
		
		
		/**
		 * 총 견적현황 조회
		 * @return List
		 */
		public List<IntList> getList();
				
		/**
		 * 작성자로 견적 조회
		 * @param String writer
		 * @return IntList
		 */
		public IntList intListByWriter(String writer);
		
		/**
		 * 글번호로 견적 조회
		 * @param int ListNo
		 * @return IntList
		 */
		public IntList getListByListNo(int ListNo);
				
		/**
		 * 견적 삽입
		 * @param intList
		 * @return boolean
		 */
		public boolean intInsert(IntList intList);
			
		/**
		 * 견적 정보 수정
		 * @param intList
		 * @return boolean
		 */
		public IntList intUpdate(IntList intList);
				
		/**
		 * 견적번호로 견적 삭제
		 * @param listNo
		 * @return boolean
		 */
		public boolean intDeleteByListNo(int listNo);
		
		/**
		 * 견적리스트 게시물 수 불러오기 (count 값)
		 * @return int
		 */
		public int getTotal();
		
		public int geteditTotal();
			
		/**
		 * 페이징한 리스트 가져오기
		 * @param paging
		 * @return List
		 */
		public List getPagingList(Paging paging);
		
		public List getUserPagingList(Paging paging, IntList il);
		
		public List getPagingEditList(PagingEdit paging);
		
		public List getPagingCompanyList(Paging paging);
		
		/**
		 * 조회수 올리는 메소드
		 * @param intList
		 * @return IntList
		 */
		public IntList hit(IntList intList);
		
		
		/**
		 * 내 견적 수 가져오기
		 * @param IntEdit
		 * @return
		 */
		public int listCount(IntList intList);
		
		/**
		 * 에디터 정보 가져오기
		 * @param request
		 * @param response
		 * @return IntEdit
		 */
		public IntEdit getEditinfo(HttpServletRequest request, HttpServletResponse response);
		
		/**
		 * 견적현황 가져오기
		 * @param request
		 * @param response
		 * @return IntList
		 */
		public IntList getListinfo(HttpServletRequest request, HttpServletResponse response);
		
		/**
		 * 체크 값으로 에디터 지우기
		 * @param checked
		 * @return boolean
		 */
		public boolean editDeleteByChecked(String checked);
		
		/**
		 * 체크 값으로 등급 올리기
		 * @param checked
		 * @return boolean
		 */
		public boolean editUpdateToGrade(String checked);

		
		boolean editInsert(IntEdit IntEdit, UserDto userG);
		
		
		
}
