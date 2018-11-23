package intspace.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import intspace.dto.Intspace;
import intspace.service.IntspaceService;
import intspace.service.IntspaceServiceImpl;

@WebServlet("/intspace/delete.do")
public class IntspaceDeleteController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private IntspaceService intsvc = new IntspaceServiceImpl();
	private Intspace intspace = new Intspace();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int intspaceno = Integer.parseInt(request.getParameter("intspaceno"));
		
		intsvc.delete(intspaceno);
		
		request.getRequestDispatcher("/intspace/intspace.do").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
