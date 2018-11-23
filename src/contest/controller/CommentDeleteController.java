package contest.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contest.service.ContestService;
import contest.service.ContestServiceImpl;
import reform.dto.CommentDto;

@WebServlet("/community/contest/comment/delete.do")
public class CommentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	private ContestService conservice = new ContestServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인테리어 자랑 댓글 삭제
		CommentDto commentdto = new CommentDto();
		
		String commentIdx = (String)request.getParameter("commentIdx");
		
		commentdto.setCommentIdx(Integer.parseInt(commentIdx));
		conservice.deleteComment(commentdto);
		 
		Boolean success = true; 
		response.getWriter().append("{\"success\":"+success+"}");
	}
 
}
