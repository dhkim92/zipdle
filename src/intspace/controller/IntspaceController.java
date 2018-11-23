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




@WebServlet("/intspace/intspace.do")
public class IntspaceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IntspaceService intsvc = new IntspaceServiceImpl();
	private Intspace intspace = new Intspace();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//등급 판별
				String userid =(String) request.getSession().getAttribute("userid");
				if(userid!=null) {
				int grade = intsvc.gradecheck(userid);
				
				request.setAttribute("grade", grade);
				}
				// 현재 페이지 
				String param = request.getParameter("curPage");
				
				List<Intspace> top3 = new ArrayList<Intspace>();
				List<Intspace> intspaceList = new ArrayList<Intspace>();
				
				
				int curPage = 0;
				if( !"".equals(param) && param != null ) {
					curPage = Integer.parseInt(
					request.getParameter("curPage") );
				}

				// 총 게시글 수
				int totalCount = intsvc.getTotal();

				// Paging Class 계산하기
				Paging paging = new Paging(totalCount, curPage, 6,5);

				// 게시글 조회 결과
					top3 = intsvc.top3();
					intspaceList = intsvc.getPagingList(paging);

				// JSP에 전달할 MODEL 처리
				request.setAttribute("top3", top3);
				request.setAttribute("intspaceList", intspaceList);
				request.setAttribute("paging", paging);
				
				
				// 포워딩
	

				request.getRequestDispatcher("/intspace/intspace_main.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String search = null;
		
		if(!"".equals(request.getParameter("search")) && request.getParameter("search")!=null) {				
			search = request.getParameter("search");
		}
		
		if(search != null) {
		
		request.setAttribute("search", search);
		request.getRequestDispatcher("/intspace/search.do").forward(request, response);
		
		}else {
		
			doGet(request, response);
		
		}

	}

}
