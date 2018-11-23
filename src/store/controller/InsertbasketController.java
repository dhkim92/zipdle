package store.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basket.dto.Basket;
import store.dto.Store;
import store.service.StoreService;
import store.service.StoreServiceImpl;

@WebServlet("/store/insertbasket.do")
public class InsertbasketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StoreService stsvc = new StoreServiceImpl();
	private Store store = new Store();
	
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid =(String) request.getSession().getAttribute("userid");
		int itemamount = 1;
		
		int itemnoinstore = Integer.parseInt(request.getParameter("itemno"));
//		System.out.println(itemnoinstore); 
		
		store.setItemno(itemnoinstore);
		
		stsvc.insertbasket(store, userid, itemamount);
		
	
		request.getRequestDispatcher("/basket/basket.do").forward(request, response);
	}
	

}
