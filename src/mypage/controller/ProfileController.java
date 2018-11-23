package mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.dto.UserDto;
import login.service.MemberService;
import login.service.MemberServiceImpl;


@WebServlet("/mypage/profile.do")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//객체 생성
		UserDto uip = new UserDto();
		MemberService ms = new MemberServiceImpl();
	
		//세션 ID값 가져오기
		uip.setUserId((String)request.getSession().getAttribute("userid"));
		//프로필 이미지 기본경로 설정
		uip.setProfileImg("/mypage/img/profile/default.jpg");
		
		//이미지 경로 DB에 등록
		ms.setImgPath(uip);
		
		// mypage.do 로 전달
		response.sendRedirect("/mypage/mypage.do");
	
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

}
