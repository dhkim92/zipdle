package reform.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reform.dto.ReformDto;
import reform.service.ReformService;
import reform.service.ReformServiceImpl;

@WebServlet("/community/reform/recommend.do")
public class ReformRecommendController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private ReformService reformservice = new ReformServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 리폼 정보방 좋아요 누르기 컨트롤러
		
		String param = request.getParameter("idx");

		int idx = 0; 
		if( !"".equals(param) && param != null ) {
			idx = Integer.parseInt(param);   
		}
		
		ReformDto reformdto = new ReformDto();
		reformdto.setIdx(idx); // 게시물 번호
		reformdto.setId((String) request.getSession().getAttribute("userid")); // 유저 아이디
		
		// t는 추천, f는 비추천 상태를 나타냄 
		boolean result = reformservice.recommend(reformdto);
		// 해당 게시물의 추천개수 가져오기 
		int recommendNum = reformservice.getRecommend(reformdto);
		 
		response.getWriter().println( 
				"{"
				+ "\"recommendNum\": "+recommendNum
				+ ", \"result\": "+result
				+ "}"); 
		} 
		 
	
}
