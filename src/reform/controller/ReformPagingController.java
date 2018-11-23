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
import reform.util.Paging;
  
@WebServlet("/community/reform.do")    
public class ReformPagingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ReformService reformservice = new ReformServiceImpl();
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 리폼 정보방 페이징 
		
		// 현재 페이지 
		String param = request.getParameter("curPage");
		 
		int curPage = 0;  
		if(!"".equals(param) && param != null) {
			curPage = Integer.parseInt(request.getParameter("curPage")); 
		}
		// 총 게시물수
		int totalCount = reformservice.getTotal(); 
		
		Paging paging = new Paging(totalCount, curPage);

		List<ReformDto> reformlist = reformservice.getPaging(paging); 
		
		request.setAttribute("reformlist", reformlist); // 페이지 모든 게시글 정보 불러오기
		request.setAttribute("paging", paging); 
		
		request.getRequestDispatcher("/community/ref_table.jsp")
		.forward(request, response); 
	} 

}
