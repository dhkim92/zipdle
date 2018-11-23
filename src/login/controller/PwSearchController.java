package login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.dto.UserDto;
import login.service.MemberService;
import login.service.MemberServiceImpl;


@WebServlet("/login/pwsearch.do")
public class PwSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/login/pwSearch.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDto user = new UserDto();
		MemberService memberService = new MemberServiceImpl();
		
		request.setCharacterEncoding("UTF-8");
		
		user.setUserId(request.getParameter("id"));
		user.setUserName(request.getParameter("name"));
		user.setUserEmail(request.getParameter("email"));
		user.setUserPhone(request.getParameter("phone"));
		user.setUserPw(request.getParameter("pw"));
		
		String pw = request.getParameter("pw");
		String repw = request.getParameter("repw");
		
		//test
		//System.out.println(memberService.checkPw(user));
	
	// 수정할 입력한 비밀번호가 일치할때
	if(memberService.joinPw(pw, repw)) {
		// 처리결과 판별 : 반환값 true 일때
		if(memberService.checkPw(user)) {
			
			// 비밀번호 수정 실행
			memberService.pwSet(user);
			
			// 비밀번호 수정 처리 결과 성공 -true
			request.setAttribute("pwsearch", true);
						
			
			// 처리결과 view 페이지 띄우기
			request.getRequestDispatcher("/login/result/pwsearchResult.jsp")
			.forward(request, response);
			
		} else {	// false일때
			
			// 비밀번호 수정 처리 결과 실패 -false
			request.setAttribute("pwsearch", false);
			
			// 처리결과 view 페이지 띄우기
			request.getRequestDispatcher("/login/result/pwsearchResult.jsp")
					.forward(request, response);
		}
		
	}else {
		
		request.setAttribute("pwsearch", false);
	
		request.getRequestDispatcher("/login/result/pwsearchResult.jsp")
					.forward(request, response);
		
	}
	
	}
	

}
