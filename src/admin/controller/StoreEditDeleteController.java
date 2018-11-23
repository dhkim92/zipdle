package admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.dto.Store;
import store.service.StoreService;
import store.service.StoreServiceImpl;

@WebServlet("/admin/StoreDelete.do")
public class StoreEditDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	Store store = new Store();
	StoreService stsvc = new StoreServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String checked = request.getParameter("names");
		
//		System.out.println("delete.do_checked"+checked);
		
		
		stsvc.Delete(checked);
				
		request.getRequestDispatcher("/admin/EditStore.do").forward(request, response);
	}

	
}
