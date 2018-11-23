package interior.dao;

import java.util.List;

import interior.dto.IntEdit;
import login.dto.UserDto;
import util.Paging;
import util.PagingEdit;

public interface IntEditDao {

	public List<IntEdit> selectPagingEditList(PagingEdit paging);
	
	/**
	 * 총 에디터 조회하는 메소드
	 * @return List
	 */
	public List<IntEdit> selectAll();
	
	/**
	 * 에디터 페이징 처리해서 조회하는 메소드
	 * @param paging
	 * @return List
	 */
	public List<IntEdit> selectPagingEditorList(Paging paging);
	
	/**
	 * 에디터 넘버로 지우기
	 * @param editNo
	 * @return boolean
	 */
	public boolean deleteEditByEditNo(int editNo);
	
	/**
	 * 에디터번호로 에디터 조회
	 * @param EditNo
	 * @return IntEdit
	 */
	public IntEdit selectAll(int EditNo);
	
	/**
	 * 등급으로 에디터 정보 가져오기
	 * @param IntEdit
	 * @return List
	 */
	public List<IntEdit> selectByGrade(int Grade);
	
	
	/**
	 * 에디터 등록
	 * @param IntEdit
	 * @return boolean
	 */
	public boolean insertEdit(IntEdit IntEdit, UserDto userG);
	
	
	/**
	 * 에디터 정보 수정
	 * @param IntEdit
	 * @return boolean
	 */
	public boolean updateEdit(IntEdit IntEdit);
	
	/**
	 * 사업자등록번호로 에디터 삭제
	 * @param EditNo
	 * @return boolean
	 */
	public boolean deleteEdit(int resiNo);

	public int selectCntAll();
	

	
	public boolean deleteByChecked(String checked);
	
	public boolean updateToChecked(String checked);
	
	public List<IntEdit> selectPagingCompanyList(Paging paging);
	
}
