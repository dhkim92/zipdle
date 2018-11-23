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
import mypage.service.MyPageService;
import mypage.service.MyPageServiceImpl;


@WebServlet("/mypage/info/infopw.do")
public class InfoPwController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		UserDto user = new UserDto();
		MemberService memberService = new MemberServiceImpl();
		MyPageService mypageService = new MyPageServiceImpl();
		
		
		
		String pw = request.getParameter("password");
		String repw = request.getParameter("repassword");
		
		//test
//		System.out.println(pw);
//		System.out.println(repw);
		
		// 세션에서 id값 가져오기 -> String 변수에 넣기
		String id = (String)request.getSession().getAttribute("userid");
		
		// 매개변수로 넣게 위해 UserDto 타입으로 변환
		user.setUserId(id);
		user.setUserPw(pw);// 비밀번호 입력값
		
		//test 완료
//		System.out.println(user);
		
		// 비밀번호 입력값 일치여부 판별
		if(memberService.joinPw(pw, repw)) {
			
			// 서비스 전달
			mypageService.changePw(user);
			
			// 비밀번호 수정 처리 결과 성공 -true
			request.setAttribute("infopwResult", true);
		} else {
			
			// 비밀번호 수정 처리 결과 실패 -false
			request.setAttribute("infopwResult", false);
		}
		
		
		// 클라이언트 접근시 view 요청
		request.getRequestDispatcher("/mypage/result/infopwResult.jsp").forward(request, response);
	}

}
