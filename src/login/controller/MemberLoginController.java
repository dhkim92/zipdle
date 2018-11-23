package login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.dto.UserDto;
import login.service.MemberService;
import login.service.MemberServiceImpl;


@WebServlet("/login/login.do")
public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 클라이언트 접근시 view 요청
		request.getRequestDispatcher("/login/login.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserDto user = new UserDto();
		MemberService memberService = new MemberServiceImpl();
		
		// 요청객체 한글 인코딩 UTF-8 설정
		request.setCharacterEncoding("utf-8");
		
		// 응답객체 문서형식 설정 (+인코딩)
		response.setContentType("text/html;charset=utf-8");
		
		// 세션 생성
		HttpSession session = request.getSession();
		
		user.setUserId(request.getParameter("id"));	// view에서 입력한 id값
		user.setUserPw(request.getParameter("pw"));	// view에서 입력한 pw값
		
		
//		System.out.println(request.getParameter("id")); test
		
		
		
		// db에 존재하는 id값 확인 - 로그인 성공, 실패 판별
		if(memberService.login(user)){
			
			UserDto data = memberService.userList(user);
			
//			test
			//System.out.println(data);
			
			session.setAttribute("login", true); // 로그인 상태 세션
			session.setAttribute("userid", user.getUserId()); // 로그인 id 세션
			session.setAttribute("username", data.getUserName()); // 로그인 이름 세션
			
			
			request.setAttribute("userinfo", data); // 회원정보 request에 담기
			
//			response.sendRedirect("/login/result/loginOk.jsp");	// 로그인 성공 view 띄우기
			
			//관리자 페이지 이동
			if(user.getUserId().equals("admin")) {
				
				// 테스트 완료
				// System.out.println(user.getUserId());
				
				
			// request 전달
				request.getRequestDispatcher("/admin/adminMain.jsp").forward(request, response);
				
			
			
				
				//관리자 아니면 서비스 페이지로 이동
			} else {
				// request 전달
				request.getRequestDispatcher("/login/result/loginResult.jsp").forward(request, response);	
				
			}
			
			 
			
			
		} else {
			session.setAttribute("login", false); // 로그인 상태 세션
			
			request.getRequestDispatcher("/login/result/loginResult.jsp")
				.forward(request, response); // request 전달
		
		}
		
	}

}
