package reform.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reform.dto.ReformDto;
import reform.service.ReformService;
import reform.service.ReformServiceImpl;

@WebServlet("/community/reform/write.do") 
public class ReformWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private ReformService reformservice = new ReformServiceImpl();
	private ReformDto reformdto = new ReformDto();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 리폼 정보방 글 작성 컨트롤러
		
		request.getSession().getAttribute("userid");
		// getSession(): Returns the current session associated with this request, 
		//			or if the request does not have a session, creates one.
		 
		request.getRequestDispatcher("/community/reform/proto/ref_write.jsp")
		.forward(request, response);
	} 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 전송파라미터 한글 인코딩 설정 : UTF-8
		request.setCharacterEncoding("UTF-8");
										
		// 응답 객체 MIME타입 설정 : HTML, 한글인코딩 UTF-8
		response.setContentType("text/html;charset=UTF-8"); 
		
		reformdto = reformservice.getInfo(request, response);   
		
		reformdto.setId((String)request.getSession().getAttribute("userid")); 
		
		reformservice.write(reformdto); 
				
		// 작성완료 후 글 목록 보여주기 
		response.sendRedirect("/community/reform.do");
	}
	
}
