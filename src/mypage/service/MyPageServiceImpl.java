package mypage.service;

import interior.dao.IntListDao;
import interior.dao.IntListDaoImpl;
import interior.dto.IntList;
import login.dto.UserDto;
import mypage.dao.MyPageDao;
import mypage.dao.MyPageDaoImpl;

public class MyPageServiceImpl implements MyPageService {

	private MyPageDao mypagedao = new MyPageDaoImpl();
	private IntListDao ild = new IntListDaoImpl();
	
	// 마이페이지에서 pw 수정
	@Override
	public void changePw(UserDto user) {		
		mypagedao.cgPw(user);
	}

	// 마이페이지에서 회원정보 수정
	@Override
	public void updateInfo(UserDto user) {
		mypagedao.udInfo(user);
	}

	// 마이페이지에서 회원정보 삭제
	@Override
	public boolean deleteInfo(UserDto user) {
		
		return mypagedao.delInfo(user);
	}

	// DB회원정보와 view에서 입력한 정보 일치여부 판별
	@Override
	public boolean infoMatching(UserDto userdata, UserDto user) {
		
		// 이름 매칭
		String dbname = userdata.getUserName();
		String name = user.getUserName();
		// 비밀번호 매칭
		String dbpw = user.getUserPw();
		String pw = user.getUserPw();
		// 이메일 매칭
		String dbemail = userdata.getUserEmail();
		String email = user.getUserEmail();
		// 연락처 매칭
		String dbphone = userdata.getUserPhone();
		String phone = user.getUserPhone();
	
		if (dbname.equals(name) && dbemail.equals(email) && dbphone.equals(phone) && dbpw.equals(pw)) {
			
			return true;
		}else {
		
			return false;
		}
	}
	
	
	// 회원별 견적 리스트 카운트 조회
	@Override
	public int cntIntlist(IntList il) {
		
		return ild.countList(il);
	}
	
	
	// 회원별 장바구니 리스트 카운트 조회
	@Override
	public int cntCartlist(UserDto user) {
		
		return mypagedao.cntCart(user);
	}

	
}
