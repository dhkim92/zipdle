package interior.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interior.dto.IntList;
import interior.service.IntService;
import interior.service.IntServiceImpl;

@WebServlet("/interior/listUpdate.do")
public class IntListUpdateContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		// 응답객체 문서형식 설정(+인코딩)
		response.setContentType("text/html;charset=utf-8");
		
		IntService is = new IntServiceImpl();
		
		IntList il = new IntList();
		
		
		
		
		il.setListNo(Integer.parseInt(request.getParameter("listNo")));
		
		IntList view = is.getListByListNo(Integer.parseInt(request.getParameter("listNo")));
		
		System.out.println(view.toString());
		
	
			request.setAttribute("view", view);
			
			request.getRequestDispatcher("/interior/listUpdate.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 전송파라미터 한글 인코딩 설정 : UTF-8
				request.setCharacterEncoding("UTF-8");
								
				// 응답 객체 MIME타입 설정 : HTML, 한글인코딩 UTF-8
				response.setContentType("text/html;charset=UTF-8");
				
				IntService is = new IntServiceImpl();
				
				IntList il = new IntList();
				
				il = is.getListinfo(request, response);

				IntList update = is.intUpdate(il);
				
				update.setWriter((String)request.getSession().getAttribute("userid"));
				
				System.out.println("업데이트 부분!!");
				System.out.println(update);
				System.out.println("업데이트 부분!!");
//				
				response.sendRedirect("/interior/list.do");
			
	}

}
