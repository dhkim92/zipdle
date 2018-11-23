package login.dao;

import java.util.List;

import login.dto.UserDto;
import util.Paging;

public interface MemberDao {
	
	// 전체 유저정보 리스트 가져오기
	public List selectAll();
	
	// 페이징 카운트 대로 잘라서 유저 리스트 가져오기
	public List selectPagingUser(Paging paging);
	
	// 유저 리스트 카운트
	public int selectAllCnt();
	
	// ID로 유저정보 가져오기
	public UserDto selectUser(UserDto user);

	// 회원가입
	public boolean insert(UserDto user);
	
	// 로그인
	public int doLogin(UserDto user);
	
	// ID찾기
	public String idSearch(UserDto user);
	
	// 비밀번호 수정
	public void pwSearch(UserDto user);
	
	// ID 찾기 판별
	public boolean idCheck(UserDto user);
	
	// 비밀번호 수정 판별
	public boolean pwCheck(UserDto user);
	
	// ID 중복 검사
	public boolean overlap(UserDto user);
	
	// 회원등급 수정 (관리자 기능)
	public boolean setGrade(String ids,int grade);
	
	// 유저 프로필 이미지 경로 등록
	public void setImg(UserDto user);
	
	//프로필 이미지 경로 가져오기
	public String getImg(UserDto user);
	
	
	
}
