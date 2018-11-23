package interior.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interior.service.IntService;
import interior.service.IntServiceImpl;

@WebServlet("/interior/listDelete.do")
public class IntListDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("listDelete.do get 으로 들어옴");
			System.out.println(request.getParameter("listNo"));
		
		IntService is = new IntServiceImpl();
		
		boolean deleteok = is.intDeleteByListNo(Integer.parseInt(request.getParameter("listNo")));
		
		System.out.println(deleteok);
		
		System.out.println("listDelete 완료하고 list.do 로 리다이렉트");
		
		response.sendRedirect("/interior/list.do");
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
