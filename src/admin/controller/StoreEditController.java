package admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.dto.Store;
import store.service.StoreService;
import store.service.StoreServiceImpl;
import util.Paging;


@WebServlet("/admin/EditStore.do")
public class StoreEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StoreService storeservice = new StoreServiceImpl();
	private Store store = new Store();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 현재 페이지 
		String param = request.getParameter("curPage");
		
		List<Store> storeList = new ArrayList<Store>();
		
		int curPage = 0;
		if( !"".equals(param) && param != null ) {
			curPage = Integer.parseInt(
			request.getParameter("curPage") );
		}
		
		String search = request.getParameter("search");

		if(search== null){
			
		// 총 게시글 수
		int totalCount = storeservice.getTotal();

		// Paging Class 계산하기
		Paging paging = new Paging(totalCount, curPage , 6, 5);
		
		
		// 게시글 조회 결과
		
			storeList = storeservice.getPagingList(paging);

		// JSP에 전달할 MODEL 처리
		request.setAttribute("storeList", storeList);
		request.setAttribute("paging", paging);

		
		}else if (search!=null) {
			
			store.setHashtag(search);
			
			// 총 게시글 수
			int totalCount = storeservice.getidxcount(store);

			Paging paging = new Paging(totalCount, curPage,6 , 5);
			paging.setSearch(search);
			// Paging Class 계산하기
	
			// 게시글 조회 결과
			storeList= storeservice.getPagingidxList(paging);

			// JSP에 전달할 MODEL 처리
			request.setAttribute("storeList", storeList);
			request.setAttribute("paging", paging);

		
		}
		
		// 포워딩
		request.getRequestDispatcher("/admin/editorStore.jsp")
			.forward(request, response);
	}

}









