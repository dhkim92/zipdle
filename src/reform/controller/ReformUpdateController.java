package reform.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reform.dto.ReformDto;
import reform.service.ReformService;
import reform.service.ReformServiceImpl;

@WebServlet("/community/reform/update.do")
public class ReformUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ReformService reformservice = new ReformServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 리폼 정보방 게시글 수정 컨트롤러 
		
		// /community/reform/update.do에 요청이 들어오면
		// 해당 요청의 idx 파라미터를 받아온다 
		String param = request.getParameter("idx"); 
		
		// idx를 int형으로 변환한다 
		int idx = 0;
		if(!"".equals(param) && param!=null) {
			idx = Integer.parseInt(param);
		}
		
		// Dto에 해당 idx를 저장한다
		ReformDto reform = new ReformDto();
		reform.setIdx(idx); 
		 
		reform = reformservice.view(reform);  
	
		request.setAttribute("reform", reform);

		request.getRequestDispatcher("/community/reform/proto/ref_update.jsp")  
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		
		response.setContentType("text/html;charset=UTF-8"); 
		
		ReformDto reform = reformservice.getInfo(request, response); 
		  
		reformservice.update(reform);    
		
		int idx = reform.getIdx();
		
		response.sendRedirect("/community/reform/view.do?idx="+idx);  
	}
 
}








