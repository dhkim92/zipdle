package intspace.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import intspace.dto.Intspace;
import intspace.service.IntspaceService;
import intspace.service.IntspaceServiceImpl;

@WebServlet("/intspace/update.do")
public class IntspaceUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IntspaceService intsvc = new IntspaceServiceImpl();
	private Intspace intspace = new Intspace();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String param = request.getParameter("intspaceno");

		int intspaceno = 0;
		if (!"".equals(param) && param != null) {
			intspaceno = Integer.parseInt(param);
		}

		intspace.setIntspaceno(intspaceno);

		Intspace updateinfo = intsvc.view(intspace);

		request.setAttribute("updateinfo", updateinfo);

		request.getRequestDispatcher("/intspace/intspace/proto/updateview.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 전송파라미터 한글 인코딩 설정 : UTF-8
		request.setCharacterEncoding("UTF-8");
		
		// 응답 객체 MIME타입 설정 : HTML, 한글인코딩 UTF-8
		response.setContentType("text/html;charset=UTF-8");
		
		intspace = intsvc.getintspacedata(request, response);
		
		intsvc.updatesave(intspace);
		
		System.out.println("update"+intspace);
						
		request.getRequestDispatcher("/intspace/intspace.do").forward(request, response);
	}
}
