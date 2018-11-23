package store.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.dto.Store;
import store.service.StoreService;
import store.service.StoreServiceImpl;

@WebServlet("/store/view.do")
public class StoreviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StoreService stsvc = new StoreServiceImpl();
	private Store store = new Store();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param = request.getParameter("itemno");
		
		int itemno = 0;
		if(!"".equals(param)&&param != null) {
			itemno = Integer.parseInt(param);
			
		}
		
		store.setItemno(itemno);
		
		//view 조회 결과
		Store storeList = stsvc.view(store);
		
		//==================
		
		request.setAttribute("storeList", storeList);

		request.getRequestDispatcher("/store/store/proto/view.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid =(String) request.getSession().getAttribute("userid");
		int itemamount = 1;
		
		int itemno = Integer.parseInt(request.getParameter("itemno"));
//		String itemname = request.getParameter("itemname");
//		int itemprice = Integer.parseInt(request.getParameter("itemprice"));
//		String iteminfo = request.getParameter("iteminfo");
//		String imgpath = request.getParameter("imgpath");

//		System.out.println(imgpath);
		
		store.setItemno(itemno);
//		store.setItemname(itemname);
//		store.setItemprice(itemprice);
//		store.setIteminfo(iteminfo);
//		store.setImgpath(imgpath);
		
		stsvc.insertbasket(store, userid, itemamount);
		
		response.sendRedirect("/store/storepaging.do");
	}

}
