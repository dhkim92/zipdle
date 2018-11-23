package admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interior.dto.IntEdit;
import interior.service.IntService;
import interior.service.IntServiceImpl;

@WebServlet("/admin/deleteEditor.do")
public class AdminEditorDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String checked = request.getParameter("names");
		
		System.out.println(checked);
		
//		System.out.println("delete.do_checked"+checked);
		IntService is = new IntServiceImpl();
		
		is.editDeleteByChecked(checked);
			response.sendRedirect("/admin/editor.do");
		
	
	}

}
