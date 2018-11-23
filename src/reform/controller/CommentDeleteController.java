package reform.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reform.dto.CommentDto;
import reform.service.ReformService;
import reform.service.ReformServiceImpl;

@WebServlet("/community/reform/comment/delete.do")
public class CommentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ReformService reformservice = new ReformServiceImpl();
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 리폼 정보방 댓글 삭제
		
		CommentDto commentdto = new CommentDto();
		
		String commentIdx = (String)request.getParameter("commentIdx");
		
		commentdto.setCommentIdx(Integer.parseInt(commentIdx)); 
		reformservice.deleteComment(commentdto); // 댓글 삭제
		
		Boolean success = true;
		response.getWriter().append("{\"success\":"+success+"}"); 
	} 

}
