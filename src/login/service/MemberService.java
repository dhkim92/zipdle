package login.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.dto.UserDto;
import util.Paging;

public interface MemberService {
	
	
	/**
	 * user데이터 전부 가져오기
	 * @return List
	 */
	public List userList();
	
	//유저 리스트 카운트 가져오기
	public int userListCnt();
	
	public List userPagingList(Paging paging);
	
	/**
	 * 아이디로 user데이터 가져오기
	 * @param user
	 * @return UserDto
	 */
	public UserDto userList(UserDto user);
	
	// 회원가입
	public boolean join(UserDto user);
	
	// 로그인
	public boolean login(UserDto user);
	
	// ID 찾기
	public String idGet(UserDto user);
	
	// PW 수정
	public void pwSet(UserDto user);
	
	// ID 찾기 판별 : 이름, 이메일, 연락처 일치 확인
	public boolean checkId(UserDto user);
	
	// PW 찾기 판별 : ID, 이름, 이메일, 연락처 일치 확인
	public boolean checkPw(UserDto user);
	
	// 회원가입 - ID중복 검사
	public boolean checkJoin(UserDto user);
	
	// 회원가입 - PW 일치 판별
	public boolean joinPw(String pw, String repw );
	
	// 유저 프로필 이미지 멀티파트 경로 가져오기
	public UserDto getProfilePath(HttpServletRequest request, HttpServletResponse response);
	
	// 프로필 이미지 등록
	public void setImgPath(UserDto user);
	
	// 프로필 이미지 경로 가져오기
	public String getImgPath(UserDto user);
	
	// 회원 등급 업 수정
	public boolean upGrade(String ids);
	
	// 회원 등급 다운 수정
	public boolean downGrade(String ids);

}
