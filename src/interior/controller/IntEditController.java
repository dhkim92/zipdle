package interior.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interior.dto.IntEdit;
import interior.service.IntService;
import interior.service.IntServiceImpl;
import util.PagingEdit;


@WebServlet("/interior/edit.do")
public class IntEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IntService ss = new IntServiceImpl();
		List<IntEdit> edt = new ArrayList<>();
		
		//현재 페이지
				String param = request.getParameter("curPage");
				
				int curPage = 0;
				if( param != null && !"".equals(param)) {
					curPage = Integer.parseInt(request.getParameter("curPage"));
				}
				
						int totalCount = ss.geteditTotal();
						System.out.println(totalCount);
						
				// Paging Class 계산하기
					PagingEdit paging = new PagingEdit(totalCount, curPage);
					
						
				// 게시글 조회 결과
				edt = ss.getPagingEditList(paging);
				System.out.println(edt);
		
		request.setAttribute("paging", paging);
		
		request.setAttribute("edit", edt);
		
		request.getRequestDispatcher("Editor-Introduce.jsp").forward(request, response);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	
		IntService ss = new IntServiceImpl();
		List<IntEdit> edt = new ArrayList<>();
		
//		IntEdit ie = ss.getEditinfo(request, response);
//		
//		ss.editInsert(ie);
		
		edt = ss.getEdit();
		System.out.println("=========");
		System.out.println(edt);
		System.out.println("=========");

		
		request.setAttribute("edit", edt);
		
		request.getRequestDispatcher("Editor-Introduce.jsp").forward(request, response);
	}

}
