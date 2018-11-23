package store.controller;

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
import store.dto.Store;
import store.service.StoreService;
import store.service.StoreServiceImpl;
import util.Paging;

@WebServlet("/store/search.do")
public class StoreSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private StoreService stsvc = new StoreServiceImpl();
	private Store store = new Store();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid =(String) request.getSession().getAttribute("userid");
		
		String param = request.getParameter("curPage");
		
		List<Store> storeList = new ArrayList<Store>();
		
		int curPage = 0;
		if( !"".equals(param) && param != null ) {
			curPage = Integer.parseInt(
			request.getParameter("curPage") );
		}
		
		String search = request.getParameter("search");
		
		store.setHashtag(search);
		
		// 총 게시글 수
		int totalCount = stsvc.getidxcount(store);

		Paging paging = new Paging(totalCount, curPage,6,5);
		paging.setSearch(search);
		// Paging Class 계산하기
		
		request.setAttribute("searchChecker", totalCount);
		
		storeList = stsvc.getPagingidxList(paging);

		// JSP에 전달할 MODEL 처리
		request.setAttribute("storeList", storeList);
		request.setAttribute("paging", paging);
		request.setAttribute("search", search);

		request.getRequestDispatcher("/store/store_main.jsp").forward(request, response);
	// 포워딩

		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}




