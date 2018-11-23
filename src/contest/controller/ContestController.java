package contest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contest.dto.ContestDto;
import contest.service.ContestService;
import contest.service.ContestServiceImpl;
import reform.dto.CommentDto;
 
@WebServlet("/community/contestlist.do") 
public class ContestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ContestService conservice = new ContestServiceImpl();
	ContestDto condto = new ContestDto(); 
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
		// 모든 게시물 정보 가져오기 
		List<ContestDto> conlist = conservice.getAll();  
		request.setAttribute("conlist", conlist);  
		
		System.out.println("conlist: " + conlist);
		
		// 댓글 정보 가져오기  
		List<CommentDto> commentlist = conservice.getComment(condto); 
		request.setAttribute("commentlist", commentlist);  
		
		request.getRequestDispatcher("/community/contest/con_table.jsp") 
		.forward(request, response);       
	}

}