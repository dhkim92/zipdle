package contest.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contest.dto.ContestDto;
import contest.service.ContestService;
import contest.service.ContestServiceImpl;
import login.dto.UserDto;
import login.service.MemberService;
import login.service.MemberServiceImpl;
import reform.dto.CommentDto;
import reform.util.Paging;


@WebServlet("/community/contest.do")
public class ContestPagingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ContestService contestservice = new ContestServiceImpl();
	private MemberService memberservice = new MemberServiceImpl(); 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인테리어 자랑방 페이징 
		String param = request.getParameter("curPage");

		int curPage = 0;
		if(!"".equals(param) && param != null ) {
			curPage = Integer.parseInt(request.getParameter("curPage"));
		}

		// 총 게시물수
		int totalCount = contestservice .getTotal();

		Paging paging = new Paging(totalCount, curPage);

		List<ContestDto> conlist = contestservice.getPaging(paging);

		request.setAttribute("conlist", conlist);
		request.setAttribute("paging", paging);

		// 댓글 정보 가져오기   
		ContestDto condto = new ContestDto();
		List<CommentDto> commentlist = contestservice.getComment(condto); 
		request.setAttribute("commentlist", commentlist);  
		//--------
		
		// 유저 정보
		UserDto userdto = new UserDto();
		
		List<UserDto> userlist = new ArrayList<UserDto>();
		
		userlist = memberservice.userList();  
		
		request.setAttribute("userlist", userlist);

		request.getRequestDispatcher("/community/contest/con_table.jsp")
		.forward(request, response);   

	}  

}

