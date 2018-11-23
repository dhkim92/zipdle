package login.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.dto.UserDto;
import login.service.MemberService;
import login.service.MemberServiceImpl;


@WebServlet("/login/join.do")
public class MemberJoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	// view 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/login/join.jsp").forward(request, response);
	}

	
	// 회원가입 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		UserDto user = new UserDto();
		MemberService memberService = new MemberServiceImpl();
	
		request.setCharacterEncoding("UTF-8");
		
		// 응답객체 문서 형식 설정 (인코딩)
		response.setContentType("text/html;charset=utf-8");
		
		
		
		
		// 클라이언트의 입력값 가져오기
		user.setUserId(request.getParameter("id"));
		user.setUserPw(request.getParameter("pw"));	
		user.setUserName(request.getParameter("name"));
		
		//Date 타입 파싱
		SimpleDateFormat format = new SimpleDateFormat("yymmdd");
		Date birthDate = null;
		try {
			birthDate = format.parse(request.getParameter("birth"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		user.setUserBirth(birthDate);
		user.setUserEmail(request.getParameter("email"));
		user.setUserPhone(request.getParameter("phone"));
		user.setUserAddress(request.getParameter("address"));
		
		String pw = request.getParameter("pw");
		String repw = request.getParameter("repw");
		
		// 테스트
//		System.out.println(pw);
//		System.out.println(repw);
//		System.out.println( memberService.joinPw(pw, repw) );
//		System.out.println(memberService.join(user));
		
		// 비밀번호 입력 일치 확인
		if(memberService.joinPw(pw, repw)) {
			
			// 아이디 중복 확인
			if(memberService.checkJoin(user)) {
				
				// 회원가입 요청
				//memberService.join(user);
				
				if(memberService.join(user)) {
					
					// 회원가입 처리 결과 성공 -true
					request.setAttribute("joinresult", true);
					
					// 처리결과 리퀘스트 전달
					request.getRequestDispatcher("/login/result/joinResult.jsp")
					.forward(request, response);
					
				} else {
					
					request.setAttribute("joinresult", false);
					request.getRequestDispatcher("/login/result/joinResult.jsp")
					.forward(request, response);
					
					return;
				}
				
			} else {
				request.setAttribute("id", request.getParameter("id"));
				request.setAttribute("checkjoin", false);
				request.getRequestDispatcher("/login/result/joinResult.jsp")
				.forward(request, response);
				
				return;
			}
		
		} else {
			request.setAttribute("joinpw", false);
			request.getRequestDispatcher("/login/result/joinResult.jsp")
			.forward(request, response);
			
			return;
		}
		
		
	}

}
