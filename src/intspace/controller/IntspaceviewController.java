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

@WebServlet("/intspace/view.do")
public class IntspaceviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IntspaceService intspaceservice = new IntspaceServiceImpl();
	private Intspace intspace = new Intspace();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid =(String) request.getSession().getAttribute("userid");
		
		String param = request.getParameter("intspaceno");
		
//		System.out.println(param);
		
		int intspaceno = 0;
		if(!"".equals(param)&&param != null) {
			intspaceno = Integer.parseInt(param);
		}
		
		intspace.setIntspaceno(intspaceno);
		
		//view 조회 결과
		Intspace viewList = intspaceservice.view(intspace);
		String writer = viewList.getUserid();
		
		//==================
		//view count update
		int viewCounter = viewList.getCounter()+ 1 ;
		intspaceservice.viewControll(viewCounter, intspaceno);
		//==================
		request.setAttribute("userid", userid);
		request.setAttribute("writer", writer);
		request.setAttribute("viewList", viewList);

		request.getRequestDispatcher("/intspace/intspace/proto/view.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
