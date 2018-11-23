package mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import interior.dto.IntEdit;
import interior.service.IntService;
import interior.service.IntServiceImpl;
import login.dto.UserDto;
import login.service.MemberService;
import login.service.MemberServiceImpl;


@WebServlet("/mypage/editor.do")
public class EditorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		// 세션에서 id값 가져오기 -> String 변수에 넣기
		request.getSession().getAttribute("userid");
		
		// 클라이언트 접근시 view 요청
		request.getRequestDispatcher("/mypage/editor.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청객체 인코딩
		request.setCharacterEncoding("UTF-8");
		// 응답객체 문서 형식 설정 (인코딩)
		response.setContentType("text/html;charset=utf-8");
				
		/*
		 * // 세션에서 id값 가져오기 -> String 변수에 넣기
		String name = (String)request.getSession().getAttribute("username");
		// 세션값을 리퀘스트에 담기				
		request.getSession().setAttribute("userName", name);
*/
		
		
		MemberService ms = new MemberServiceImpl();
		
		UserDto user = new UserDto();
		
		user.setUserId((String)request.getSession().getAttribute("userid"));
		
		UserDto userG = ms.userList(user);
		System.out.println("여기");
		System.out.println(userG);
		
		
		// editor Dto
		IntEdit edt = new IntEdit();
		// editor Service
		IntService is = new IntServiceImpl();
		
		// IntService 내에 파일경로 가져오는 메소드 호출
		edt = is.getEditinfo(request, response);
		
		// 테스트
		//System.out.println(edt);
		
		// 입력값 가져와서 Dao 호출
		// 성공 실패 판별 -> 결과 호출
		if(is.editInsert(edt, userG)){
			// 회원가입 처리 결과 성공 -true
			request.setAttribute("editorResult", true);
			
			request.getRequestDispatcher("/mypage/result/editorResult.jsp")
			.forward(request, response);
		} else {
			
			// 회원가입 처리 결과 실패 - false
			request.setAttribute("editorResult", false);
						
			request.getRequestDispatcher("/mypage/result/editorResult.jsp")
			.forward(request, response);
			
		}
		
	}

}
