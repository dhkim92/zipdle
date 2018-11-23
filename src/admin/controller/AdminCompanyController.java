package admin.controller;

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
import util.Paging;

@WebServlet("/admin/company.do")
public class AdminCompanyController extends HttpServlet {
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
//						System.out.println(totalCount);
						
				// Paging Class 계산하기
					Paging paging = new Paging(totalCount, curPage);
					
				// 게시글 조회 결과
		edt = ss.getPagingCompanyList(paging);
		
		request.setAttribute("paging", paging);
		request.setAttribute("edit", edt);
		
		request.getRequestDispatcher("editorList.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
