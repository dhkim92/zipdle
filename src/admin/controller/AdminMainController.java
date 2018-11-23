package admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.service.MemberService;
import login.service.MemberServiceImpl;


@WebServlet("/admin/adminmain.do")
public class AdminMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("/admin/adminMain.jsp").forward(request, response);
	}

	
	// 회원 등급 다운 post
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
				//객체 생성
				MemberService ms = new MemberServiceImpl();
				
				String userid = request.getParameter("down");
				
				String[] users = userid.split(",");
				
				for(int i=0;i<users.length;i++) {
					users[i] = "'"+users[i]+"'";
				}
				
				userid = arrJoin(",",users);
			
				// test 완료
				//System.out.println(userid);
			
				
				ms.downGrade(userid);
				
				request.setAttribute("userid", userid);
				request.setAttribute("grade", 1);
				
				
				
				request.getRequestDispatcher("/admin/userGradeResult.jsp").forward(request, response);
				
				
//				response.sendRedirect("/admin/usergrade.do");
		
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
