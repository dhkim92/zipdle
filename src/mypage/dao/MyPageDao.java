package mypage.dao;

import login.dto.UserDto;

public interface MyPageDao {

	// 비밀번호 수정 DB 쿼리 전송 메소드
	public void cgPw(UserDto user); 

	// 회원정보 수정 DB 쿼리 전송 메소드
	public void udInfo(UserDto user);
	
	// 회원 탈퇴 DB 쿼리 전송 메소드
	public boolean delInfo(UserDto user);
		
	// 장바구니 리스트 카운트 쿼리 전송 메소드
	public int cntCart(UserDto user);
	
}
