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

@WebServlet("/community/contest/comment/insert.do")
public class CommentInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ContestService conservice = new ContestServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		
		CommentDto commentdto = new CommentDto();
		
		String idx = (String)request.getParameter("idx");
		String userid = (String)request.getParameter("userid");
		String content = (String)request.getParameter("commentContent"); 
		
		commentdto.setBoardIdx(Integer.parseInt(idx)); 
		commentdto.setCommentId(userid);  
		commentdto.setCommentContent(content);  
		
		// 인테리어 자랑방 댓글 작성
		conservice.writeComment(commentdto);  
		
		response.sendRedirect("/community/contest.do"); 
	}

	
	
	
	
}
