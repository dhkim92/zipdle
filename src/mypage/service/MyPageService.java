package mypage.service;

import interior.dto.IntList;
import login.dto.UserDto;

public interface MyPageService {

	// 마이페이지에서 pw 수정
	public void changePw(UserDto user);
	
	// 마이페이지에서 회원정보 수정
	public void updateInfo(UserDto user);
	
	// 마이페이지에서 회원정보 삭제
	public boolean deleteInfo(UserDto user);
	
	// DB회원정보와 view에서 입력한 정보 일치여부 판별
	public boolean infoMatching(UserDto userdata, UserDto user);
	
	// 회원별 견적 리스트 카운트 조회
	public int cntIntlist(IntList il);
	
	// 회원별 장바구니 리스트 카운트 조회
	public int cntCartlist(UserDto user);
	
}
