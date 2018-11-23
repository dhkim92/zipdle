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

@WebServlet("/mypage/delete.do")
public class DeleteInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/mypage/delete.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 요청객체 한글 인코딩 UTF-8 설정
		request.setCharacterEncoding("utf-8");			
		// 응답객체 문서형식 설정 (+인코딩)
		response.setContentType("text/html;charset=utf-8");
		
		// 필요한 객체 생성
		UserDto user = new UserDto();
		MemberService memberService = new MemberServiceImpl();
		MyPageService mypageService = new MyPageServiceImpl();
		
		// 세션에서 id값 가져오기 -> String 변수에 넣기
		String id = (String)request.getSession().getAttribute("userid");
		String name = (String)request.getSession().getAttribute("username");

		
		// userList 매개변수로 넣게 위해 UserDto 타입으로 변환
		user.setUserId(id);	
		
		// Dao->DB를 통해 유저 정보 가져오기
		UserDto userdata = new UserDto();
		userdata = memberService.userList(user);
		
		
		// view에서 입력값 가져오기 
		user.setUserPw(request.getParameter("password"));
		user.setUserName(request.getParameter("name"));
		user.setUserPhone(request.getParameter("phone"));
		user.setUserEmail(request.getParameter("email"));
		
		

		//test - DB에 존재하는 유저 정보 // 완료
//		System.out.println("userdata : "+userdata);
		
		//test - view에서 입력한 유저 정보
//		System.out.println("user : "+user);
	
				
		// DB와 view에서 입력값 일치여부 판별
		if (mypageService.infoMatching(userdata, user)) {
			
			// 서비스로 전달
			if(mypageService.deleteInfo(user)) {				
				request.setAttribute("login", false);
				request.setAttribute("deleteResult", true);	
				request.getSession().invalidate(); //세션 삭제
			}
			
		}else {			
			request.setAttribute("deleteResult", false);
		}
		
		// 결과 화면 보여주기
		request.getRequestDispatcher("/mypage/result/deleteResult.jsp").forward(request, response);
		
		
	}

}
