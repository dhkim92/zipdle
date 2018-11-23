package basket.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basket.dto.Basket;
import basket.service.BasketService;
import basket.service.BasketServiceImpl;

@WebServlet("/basket/delete.do")
public class BasketdeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BasketService basvc = new BasketServiceImpl();
	private Basket basket = new Basket();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String checked = request.getParameter("names");
		
		basvc.deletelist(checked);

		request.getRequestDispatcher("/basket/basket.do").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
