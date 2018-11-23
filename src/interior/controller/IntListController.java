package interior.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interior.dto.IntList;
import interior.service.IntService;
import interior.service.IntServiceImpl;
import util.Paging;

@WebServlet("/interior/list.do")
public class IntListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
		IntService intService = new IntServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//현재 페이지
		String param = request.getParameter("curPage");
		
		int curPage = 0;
		if( param != null && !"".equals(param)) {
			curPage = Integer.parseInt(request.getParameter("curPage"));
		}
		
				int totalCount = intService.getTotal();
				
		// Paging Class 계산하기
			Paging paging = new Paging(totalCount, curPage);
			
				
		// 게시글 조회 결과
		List<IntList> intList = intService.getPagingList(paging);
				
		// JSP 에 전달할 MODEL 처리
		
		System.out.println(intList.toString());
		
		request.setAttribute("intList", intList);
		request.setAttribute("paging", paging);
		
		// 포워딩
		request.getRequestDispatcher("InteriorList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 전송파라미터 한글 인코딩 설정 : UTF-8
				request.setCharacterEncoding("UTF-8");
										
				// 응답 객체 MIME타입 설정 : HTML, 한글인코딩 UTF-8
				response.setContentType("text/html;charset=UTF-8");
				
				IntService is = new IntServiceImpl();
				IntList il = new IntList();
				List<IntList> list = new ArrayList<>();
				
				il = is.getListinfo(request, response);
				
				il.setWriter((String)request.getSession().getAttribute("username"));
				
				
				
				is.intInsert(il);
				
				System.out.println(il);
				System.out.println("======");
				
				list = is.getList();
				
				System.out.println(list);
				
				request.setAttribute("intList", list);
				
				doGet(request, response);
				
	}

}
