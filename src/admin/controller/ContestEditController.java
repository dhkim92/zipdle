package admin.controller;

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
import reform.util.Paging;

@WebServlet("/admin/editContest.do")   
public class ContestEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ContestService contsvc = new ContestServiceImpl();
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 현재 페이지 
		String param = request.getParameter("curPage");
		 
		int curPage = 0;  
		if(!"".equals(param) && param != null) {
			curPage = Integer.parseInt(request.getParameter("curPage")); 
		}
		// 총 게시물수
		int totalCount = contsvc.getTotal(); 
		
		Paging paging = new Paging(totalCount, curPage , 6);

		List<ContestDto> conlist = contsvc.getPaging(paging); 
		
		request.setAttribute("conlist", conlist);
		request.setAttribute("paging", paging); 
		
		request.getRequestDispatcher("/admin/editorContest.jsp")
		.forward(request, response); 
	} 

}
