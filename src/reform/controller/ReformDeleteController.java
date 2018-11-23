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

@WebServlet("/community/reform/delete.do")
public class ReformDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ReformService reformservice = new ReformServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 리폼 정보방 게시글 삭제
		
		String param = request.getParameter("idx");
 
		int idx = 0;
		if(!"".equals(param) && param != null ) {
			idx = Integer.parseInt(param);
		}

		ReformDto reform = new ReformDto(); 
		reform.setIdx(idx); 

		reformservice.delete(reform); // 게시글 삭제

		// 리 다이렉트
		response.sendRedirect("/community/reform.do");
	} 
}
