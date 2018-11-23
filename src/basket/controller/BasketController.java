
package basket.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import basket.dto.Basket;
import basket.service.BasketService;
import basket.service.BasketServiceImpl;
import login.dao.MemberDao;
import login.dao.MemberDaoImpl;
import login.dto.UserDto;
import login.service.MemberService;
import login.service.MemberServiceImpl;
import store.dto.Store;

@WebServlet("/basket/basket.do")
public class BasketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private Store store = new Store();
	private Basket basket = new Basket();
	private BasketService bsksvc = new BasketServiceImpl();
	private MemberDao mbdao = new MemberDaoImpl();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//유저 아이디 확인==========
		String userid =(String) request.getSession().getAttribute("userid");
		
		
		if(userid!= null) {
			UserDto userdto = new UserDto();
			userdto.setUserId(userid);
			
			UserDto user = new UserDto();
			
			user = mbdao.selectUser(userdto);
			
			basket.setUserid(userid);
			
			
			//======================
			List basketList = bsksvc.selectAll(basket);
		
			//바스켓 조회 결과=============
//				System.out.println("basketList"+ basketList);
			//========================
				
			//바스켓 조회 결과 request입력, grade 입력===		
			request.setAttribute("grade", user);
			System.out.println(user);
			request.setAttribute("basketList", basketList);
			//=========================
			
			request.getRequestDispatcher("/basket/basket_main.jsp").forward(request, response);
			
		}
		
		if(userid== null) {
			request.getRequestDispatcher("/zipdlee/main.do").forward(request, response);
		}
	
	
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userid =(String) request.getSession().getAttribute("userid");
		
		int checker = Integer.parseInt(request.getParameter("checker"));
		int basketnoin = Integer.parseInt(request.getParameter("basketno"));
		int basketamountin = Integer.parseInt(request.getParameter("basketamount"));
		
		basket.setUserid(userid);
		basket.setBasketno(basketnoin);
		
		if(checker==1) {
			basket.setBasketamount(basketamountin+1);
		}else if(checker==2&&basketamountin>1) {
			basket.setBasketamount(basketamountin-1);
		}else if(checker==2&&basketamountin<=1) {
			basket.setBasketamount(basketamountin);
		}
	
		bsksvc.updateamount(basket);
		
		doGet(request, response);
	}

}
