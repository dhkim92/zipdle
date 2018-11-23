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
import util.Paging;

@WebServlet("/intspace/search.do")
public class IntspaceSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IntspaceService intsvc = new IntspaceServiceImpl();
	private Intspace intspace = new Intspace();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid =(String) request.getSession().getAttribute("userid");
		
		if(userid!=null) {
		int grade = intsvc.gradecheck(userid);
		
		request.setAttribute("grade", grade);
		}
		
		String param = request.getParameter("curPage");
		
		List<Intspace> intspaceList = new ArrayList<Intspace>();
		
		int curPage = 0;
		if( !"".equals(param) && param != null ) {
			curPage = Integer.parseInt(
			request.getParameter("curPage") );
		}
		
		String search = request.getParameter("search");
		
		intspace.setHashtag(search);
		
		// 총 게시글 수
		int totalCount = intsvc.getidxcount(intspace);

		Paging paging = new Paging(totalCount, curPage,6,5);
		paging.setSearch(search);
		// Paging Class 계산하기
		
		request.setAttribute("searchChecker", totalCount);
		
		intspaceList= intsvc.getPagingidxList(paging);

		// JSP에 전달할 MODEL 처리
		request.setAttribute("intspaceList", intspaceList);
		request.setAttribute("paging", paging);
		request.setAttribute("search", search);

		request.getRequestDispatcher("/intspace/intspace_main.jsp").forward(request, response);
	// 포워딩

		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
