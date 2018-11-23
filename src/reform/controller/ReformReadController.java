package reform.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.dto.UserDto;
import login.service.MemberService;
import login.service.MemberServiceImpl;
import reform.dto.CommentDto;
import reform.dto.ReformDto;
import reform.service.ReformService;
import reform.service.ReformServiceImpl;

@WebServlet("/community/reform/view.do") 
public class ReformReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ReformService reformservice = new ReformServiceImpl();
	private MemberService memberservice = new MemberServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 리폼 정보방 게시글 읽기
		
		// 클릭 게시물 idx정보 
		String param = request.getParameter("idx");

		int idx = 0;
		if(!"".equals(param) && param != null ) {
			idx = Integer.parseInt(param);
		} 
		
		// dto에 idx정보 저장
		ReformDto reform = new ReformDto(); 
		reform.setIdx(idx);
		
		// 해당 게시물 보기
		reform = reformservice.view(reform);  
		
		request.setAttribute("reform", reform); 
		
		// 추천수 
		ReformDto recommendDto = new ReformDto();
		recommendDto.setIdx(reform.getIdx());
		recommendDto.setId((String) request.getSession().getAttribute("userid"));
		
		// 추천여부 t,f 반환 
		request.setAttribute("recommend", reformservice.recommendCheck(recommendDto)); 
		 
		// 게시물 추천수 
		request.setAttribute("recommendTotal", reformservice.getRecommend(recommendDto));
		 
		// 댓글 불러오기  
		List<CommentDto> commentlist = reformservice.viewComment(reform);

		request.setAttribute("commentlist", commentlist); 
		
		// 유저 정보 가져오기 
		UserDto userdto = new UserDto();  
		List<UserDto> userlist = new ArrayList<>();
		
		userlist = memberservice.userList();    
		request.setAttribute("userlist", userlist);        
//		System.out.println("read controller:" + userlist);    
		  
		// 호출 페이지  
		request.getRequestDispatcher("/community/reform/proto/ref_read_content.jsp")
		.forward(request, response); 	   
		
	}
}
