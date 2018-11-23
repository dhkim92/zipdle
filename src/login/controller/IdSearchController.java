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


@WebServlet("/login/idsearch.do")
public class IdSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("/login/idSearch.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDto user = new UserDto();
		MemberService memberService = new MemberServiceImpl();
		
		request.setCharacterEncoding("utf-8");
		
		user.setUserName(request.getParameter("name"));
		user.setUserEmail(request.getParameter("email"));
		user.setUserPhone(request.getParameter("phone"));
		
		String id = memberService.idGet(user);
		
		/*//테스트
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("phone"));
		*/
		
		if(memberService.checkId(user)) {
			request.setAttribute("userid", id); // id값 반환
			
			//response.sendRedirect("/login/result/idOk.jsp");
			
			// 아이디찾기 처리 결과 성공 -true
			request.setAttribute("idsearch", true);
			
			request.getRequestDispatcher("/login/result/idsearchResult.jsp")
			.forward(request, response);
			
		} else {
			
			// 아이디찾기 처리 결과 실패 - false
			request.setAttribute("idsearch", false);
			
			request.getRequestDispatcher("/login/result/idsearchResult.jsp")
			.forward(request, response);
		}
		
		
	
		
	}

}
