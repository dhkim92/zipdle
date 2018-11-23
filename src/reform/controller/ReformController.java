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

@WebServlet("/community/reformlist.do")  
public class ReformController extends HttpServlet { 
	private static final long serialVersionUID = 1L;

	private ReformService reformservice = new ReformServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 게시글 조회 결과 
		List<ReformDto> reformlist = reformservice.getList();
		 
		// JSP에 전달
		// setAttribut: Stores an attribute in this request. 
		// request가 유지되는 동안 해당 속성을 계속해서 사용 가능하도록 넘겨준다 
		request.setAttribute("reformlist", reformlist);  
		 
		// 포워딩 
		request.getRequestDispatcher("/community/ref_table.jsp").forward(request, response);
		
	}

}
