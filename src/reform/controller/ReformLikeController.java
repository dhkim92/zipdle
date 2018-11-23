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

@WebServlet("/community/reform/like.do")
public class ReformLikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ReformService reformservice = new ReformServiceImpl();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 리폼 정보방 - 나의 좋아요 게시글 모아보기(MY LIKES기능) 컨트롤러 
		
		// userid 정보 저장
		String userid = (String) request.getParameter("userid".trim()); 
		
		// userid의 좋아요 테이블 정보
		ReformDto reformdto = new ReformDto();
		reformdto.setId(userid);
		
		// 테이블 정보 리스트 
		List<ReformDto> likelist = reformservice.getLike(reformdto);
		request.setAttribute("likelist", likelist);  
		
		// 리스트 보내기  
		request.getRequestDispatcher("/community/reform/proto/ref_like.jsp")  
		.forward(request, response); 
		
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
