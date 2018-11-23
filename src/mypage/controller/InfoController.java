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


@WebServlet("/mypage/info.do")
public class InfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청객체 한글 인코딩 UTF-8 설정
		request.setCharacterEncoding("utf-8");			
		// 응답객체 문서형식 설정 (+인코딩)
		response.setContentType("text/html;charset=utf-8");

		//------ 회원정보 view
		UserDto user = new UserDto();
		MemberService memberService = new MemberServiceImpl();
		
		
		// 세션에서 id값 가져오기 -> String 변수에 넣기
		String id = (String)request.getSession().getAttribute("userid");
		
		// userList 매개변수로 넣게 위해 UserDto 타입으로 변환
		user.setUserId(id);
		
		// Dao->DB를 통해 유저 정보 가져오기
		UserDto userdata = memberService.userList(user);
		
		// 회원정보 request에 담기
		request.setAttribute("userinfo", userdata); 
		
		
		// 클라이언트 접근시 view 요청
		request.getRequestDispatcher("/mypage/info.jsp").forward(request, response);

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				// 요청객체 한글 인코딩 UTF-8 설정
				request.setCharacterEncoding("utf-8");			
				// 응답객체 문서형식 설정 (+인코딩)
				response.setContentType("text/html;charset=utf-8");

				//------ 회원정보 view 객체
				UserDto user = new UserDto();
				MemberService memberService = new MemberServiceImpl();
				MyPageService mypageService = new MyPageServiceImpl();
				
				// view에서 입력값 가져오기
				user.setUserEmail(request.getParameter("email"));
				user.setUserAddress(request.getParameter("address"));
				user.setUserPhone(request.getParameter("phone"));
				
				
				// 세션에서 id값 가져오기 -> String 변수에 넣기
				String id = (String)request.getSession().getAttribute("userid");
				// userList 매개변수로 넣게 위해 UserDto 타입으로 변환
				user.setUserId(id);
				
				// test 완료
//				System.out.println(user);
				
				// 서비스로 전달
				// id값이 null이 아닐때만...
				if(id != null) {
					
					mypageService.updateInfo(user);
					request.setAttribute("infoResult", true);
				
				}else {
					request.setAttribute("infoResult", false);
				}
				
				// Dao->DB를 통해 유저 정보 가져오기
				UserDto userdata = memberService.userList(user);
				
				// 회원정보 request에 담기
				request.setAttribute("userinfo", userdata); 

				// 클라이언트 접근시 view 요청
				request.getRequestDispatcher("/mypage/result/infoResult.jsp").forward(request, response);
		
	}

}
