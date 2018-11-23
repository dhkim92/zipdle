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

@WebServlet("/interior/listView.do")
public class IntListViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	IntService boardService = new IntServiceImpl();
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("view.do doget 메소드 진입");
		IntList intList = new IntList();
		
		System.out.println(request.getParameter("listNo"));
		
		intList.setListNo((Integer.parseInt(request.getParameter("listNo"))));
		
		System.out.println(intList.toString());
		
		IntList intlist = boardService.hit(intList);
		
		
		request.setAttribute("intList", intlist);
		
		
		System.out.println("view.do doget 메소드 빠져나가고 listView.jsp 로 보냄");
		request.getRequestDispatcher("listView.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("view.do post 진입 ");
		request.setCharacterEncoding("UTF-8");
		
		// 응답객체 문서형식 설정(+인코딩)
		response.setContentType("text/html;charset=utf-8");
		
		System.out.println("리스트 띄우기");
		System.out.println("view.do post 빠져나가면서 view.do?listNo로 보냄");
		
		response.sendRedirect("/interior/view.do?ListNo="+request.getParameter("listNo"));
		
	}

}
