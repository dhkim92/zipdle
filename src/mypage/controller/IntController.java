package mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interior.dao.IntListDao;
import interior.dao.IntListDaoImpl;
import interior.dto.IntList;
import interior.service.IntService;
import interior.service.IntServiceImpl;
import util.Paging;


@WebServlet("/mypage/itlist.do")
public class IntController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		IntService intService = new IntServiceImpl();
		
		IntListDao ild = new IntListDaoImpl();
		IntList il = new IntList();
		
		il.setWriter((String)request.getSession().getAttribute("username"));
		//현재 페이지
				String param = request.getParameter("curPage");
				
				int curPage = 0;
				if( param != null && !"".equals(param)) {
					curPage = Integer.parseInt(request.getParameter("curPage"));
				}
				
				
				
						int totalCount = ild.selectUserCntAll(il);
						
				// Paging Class 계산하기
					Paging paging = new Paging(totalCount, curPage);
					
//				IntList il = new IntList();
//				
//				il.setWriter((String)request.getSession().getAttribute("username"));
					
						
				// 게시글 조회 결과
				List<IntList> intList = intService.getUserPagingList(paging, il);
						
				// JSP 에 전달할 MODEL 처리
				
				
				request.setAttribute("intList", intList);
				request.setAttribute("paging", paging);
				
				// 포워딩
				request.getRequestDispatcher("/mypage/itlist.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
