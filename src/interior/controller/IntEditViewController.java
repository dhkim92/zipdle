package interior.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interior.dto.IntEdit;
import interior.service.IntService;
import interior.service.IntServiceImpl;

@WebServlet("/interior/editView.do")
public class IntEditViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("editView.do doget 메소드 진입");
		IntService is = new IntServiceImpl();
		IntEdit intedit = new IntEdit();
		
//		
//		intList.setListNo((Integer.parseInt(request.getParameter("listNo"))));
//		intedit.setEditNo((Integer.parseInt(request.getParameter("editNo"))));
//		
//		System.out.println(intList.toString());
//		
//		IntList intlist = boardService.hit(intList);
		
		intedit = is.editListByEditNo((Integer.parseInt(request.getParameter("editNo"))));
		
		request.setAttribute("editList", intedit);
		
		
		System.out.println("editView.do doget 메소드 빠져나가고 listView.jsp 로 보냄");
		request.getRequestDispatcher("editView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("editView.do post 진입 ");
		request.setCharacterEncoding("UTF-8");
		
		// 응답객체 문서형식 설정(+인코딩)
		response.setContentType("text/html;charset=utf-8");
		
		System.out.println("리스트 띄우기");
		System.out.println("editView.do post 빠져나가면서 editView.do?editNo로 보냄");
		
		response.sendRedirect("/interior/editView.do?editNo="+request.getParameter("editNo"));
	}

}
