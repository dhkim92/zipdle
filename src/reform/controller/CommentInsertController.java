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

@WebServlet("/community/reform/comment/insert.do")
public class CommentInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private ReformService reformservice = new ReformServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 리폼 정보방 댓글 작성
		
		request.setCharacterEncoding("UTF-8"); 
		 
		CommentDto commentdto = new CommentDto();
		
		String Idx = (String) request.getParameter("idx");
		String userid = (String) request.getParameter("userid");  
		String content = (String) request.getParameter("content");
		
		commentdto.setBoardIdx(Integer.parseInt(Idx)); 
		commentdto.setCommentId(userid); 
		commentdto.setCommentContent(content); 

		reformservice.writeComment(commentdto); // 댓글 작성 
		
		response.sendRedirect("/community/reform/view.do?idx="+commentdto.getBoardIdx());
		
	}

}
