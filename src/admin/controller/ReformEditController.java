package admin.controller;

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

@WebServlet("/admin/editReform.do")   
public class ReformEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ReformService reformservice = new ReformServiceImpl();
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 현재 페이지 
		String param = request.getParameter("curPage");
		 
		int curPage = 0;  
		if(!"".equals(param) && param != null) {
			curPage = Integer.parseInt(request.getParameter("curPage")); 
		}
		// 총 게시물수
		int totalCount = reformservice.getTotal(); 
		
		Paging paging = new Paging(totalCount, curPage , 6);

		List<ReformDto> reformlist = reformservice.getPaging(paging); 
		
		request.setAttribute("reformlist", reformlist);
		request.setAttribute("paging", paging); 
		
		request.getRequestDispatcher("/admin/editorReform.jsp")
		.forward(request, response); 
	} 

}
