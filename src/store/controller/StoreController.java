package store.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.dto.Store;
import store.service.StoreService;
import store.service.StoreServiceImpl;

@WebServlet("/store/store.do")
public class StoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private StoreService storeservice = new StoreServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<Store> storeList = storeservice.getList();
		
		
		request.setAttribute("storeList", storeList);
		
		System.out.println(storeList);
		
		request.getRequestDispatcher("/store/store_main.jsp")
		.forward(request,response);
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
