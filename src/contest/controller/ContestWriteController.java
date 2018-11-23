package contest.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contest.dto.ContestDto;
import contest.service.ContestService;
import contest.service.ContestServiceImpl;

@WebServlet("/community/contest/write.do")
public class ContestWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ContestService conservice = new ContestServiceImpl();
	private ContestDto condto = new ContestDto();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 인테리어 자랑방 글쓰기 화면
		request.getRequestDispatcher("/community/contest/proto/con_write.jsp")
		.forward(request, response); 
	} 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = (String)request.getSession().getAttribute("userid");
		 
		// 전송파라미터 한글 인코딩 설정 : UTF-8
		request.setCharacterEncoding("UTF-8");
								
		// 응답 객체 MIME타입 설정 : HTML, 한글인코딩 UTF-8
		response.setContentType("text/html;charset=UTF-8"); 
		
		// 인테리어 자랑방 글 쓰기
		condto = conservice.getInfo(request, response);  
		 
		condto.setId(userid);
		 
		// 글쓰기
		conservice.write(condto); 
		 
		response.sendRedirect("/community/contest.do");   
		
	}

}
