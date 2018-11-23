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

@WebServlet("/admin/EditStoreAdd.do")
public class StoreEditadditemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Store store = new Store();
       StoreService stsvc = new StoreServiceImpl();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/admin/editorStoreadd.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 응답 객체 MIME타입 설정 : HTML, 한글인코딩 UTF-8
		response.setContentType("text/html;charset=UTF-8");
				
		store = stsvc.getitemdata(request, response);
		
		stsvc.save(store);
				
		response.sendRedirect("/admin/EditStore.do");
	}

}
