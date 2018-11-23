package admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.buf.StringUtils;

import login.dto.UserDto;
import login.service.MemberService;
import login.service.MemberServiceImpl;
import util.Paging;


@WebServlet("/admin/usergrade.do")
public class AdminUserGradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    // 유저 리스트 페이지 띄우기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//객체 생성
		MemberService ms = new MemberServiceImpl();
//		UserDto ud = new UserDto();
		List<UserDto> list = new ArrayList<>();
		
		
		// 현재 페이지
		String param = request.getParameter("curPage");
		
		// 페이지 카운트 변수
		int curPage = 0;
		
		// null이거나 공백이 아닐때
		if (param != null && !"".equals(param)) {
			curPage = Integer.parseInt(request.getParameter("curPage"));
		}
		
			// 유저 리스트 카운트 값 가져오기
			int ttc = ms.userListCnt();
			
			//test - 완료
//			System.out.println(ttc);
			
		// Paging 계산하기
			Paging paging = new Paging(ttc, curPage, 10);
			
			
			// 유저 리스트 불러오기
			list=ms.userPagingList(paging);
			// test - 완료
			//System.out.println(list);
			
			
		//리퀘스트에 유저 리스트 정보 담기
		request.setAttribute("paging", paging); // 페이징
		request.setAttribute("userlist", list);	// 유저 정보
		
		// view 띄우기
		request.getRequestDispatcher("/admin/userGrade.jsp").forward(request, response);
		
	}

	
	// 회원 등급 수정
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//객체 생성
		
		MemberService ms = new MemberServiceImpl();
		
		String userid = request.getParameter("up");
		
		//System.out.println(userid);
		
		String[] users = userid.split(",");
		
		for(int i=0;i<users.length;i++) {
			users[i] = "'"+users[i]+"'";
		}
		
		userid = arrJoin(",",users);
	
		// test 완료
		//System.out.println(userid);
		
		ms.upGrade(userid);
		
		request.setAttribute("userid", userid);
		request.setAttribute("grade", 2);
		
//		doGet(request,response);
		
		request.getRequestDispatcher("/admin/userGradeResult.jsp").forward(request, response);
		
		//response.sendRedirect("/admin/usergrade.do");
		
		
	}
	
	public String arrJoin(String glue, String[] users) {
		String result = "";
		for(int i=0;i<users.length;i++) {
			result += users[i];
			if(i < users.length -1) result += ",";
			}
		return result;
		}
}
