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

@WebServlet("/community/contest/delete.do")
public class ContestDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ContestService contestservice = new ContestServiceImpl();
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String param = request.getParameter("idx");
 
		int idx = 0 ;
		if(!"".equals(param) && param != null ) {
			idx = Integer.parseInt(param);
		} 
		
		ContestDto contest = new ContestDto();
		contest.setIdx(idx);
		
		// 인테리어 자랑방 게시물 삭제
		contestservice.delete(contest);
		
		response.sendRedirect("/community/contest.do"); 
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
