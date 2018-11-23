package mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interior.dto.IntList;
import login.dto.UserDto;
import login.service.MemberService;
import login.service.MemberServiceImpl;
import mypage.service.MyPageService;
import mypage.service.MyPageServiceImpl;


@WebServlet("/mypage/mypage.do")
public class MyPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 요청객체 한글 인코딩 UTF-8 설정
		request.setCharacterEncoding("utf-8");			
		// 응답객체 문서형식 설정 (+인코딩)
		response.setContentType("text/html;charset=utf-8");

		//객체 생성
		UserDto user = new UserDto(); 	//유저 dto
		IntList il = new IntList();		//인테리어 리스트 dto
		MemberService ms = new MemberServiceImpl();	// 유저 서비스
		MyPageService mys = new MyPageServiceImpl();// 마이페이지 서비스
	//--------------------- 회원정보 view----------------------
				
				// 세션에서 id값 가져오기 -> String 변수에 넣기
				String id = (String)request.getSession().getAttribute("userid");
				
				// userList 매개변수로 넣게 위해 UserDto 타입으로 변환
				user.setUserId(id);
				
				// Dao->DB를 통해 유저 정보 가져오기
				UserDto userdata = ms.userList(user);

				// 테스트 완료
//				System.out.println("userdata: "+userdata);
				
				// 회원정보 request에 담기
				request.setAttribute("userinfo", userdata); 
				
	//--------------------- 프로필 이미지 가져오기---------------------
				//이미지 경로 DB에서 가져오기
				String path = ms.getImgPath(user);
				
				// test
//				System.out.println(path);
				
				// 리퀘스트에 경로 저장
				request.setAttribute("imgPath", path);
			
	//-------------------------- 내견적 카운트------------------------
				String name = (String)request.getSession().getAttribute("username");
				// id 세션 IntList Dto에 넣기
				
				il.setWriter(name);
				
				// 카운트 메소드 서비스로 전달 해서 변수에 넣기
				int cntIntList = mys.cntIntlist(il);
				
				//테스트 - 완료
//				System.out.println(cntIntList);
				
				// 리퀘스트에 견적 리스트 카운트값 넣기 
				request.setAttribute("cntIntList", cntIntList);
				
				
	//------------------------- 장바구니 카운트-----------------------
				
				// id세션이 담긴 값을 전달
				// userDto에 위에서 담았기 때문에 아래에 바로 적용
				//카운트 메소드 서비스로 전달해서 변수에 넣기
				int cntCartList = mys.cntCartlist(user);
				
				// 테스트
				//System.out.println(cntCartList);
				
				// 리퀘스트에 장바구니 리스트 카운트값 넣기
				request.setAttribute("cntCartList", cntCartList);
				
				// 클라이언트 접근시 view 요청
				request.getRequestDispatcher("/mypage/mypage.jsp").forward(request, response);
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//객체 생성
		UserDto uip = new UserDto();
		MemberService ms = new MemberServiceImpl();
	
		// 유저 이미지 경로 멀티파트로 가져오기
		uip = ms.getProfilePath(request, response);
		
		uip.setUserId((String)request.getSession().getAttribute("userid"));
		
		//test
//		System.out.println(uip);
				
		//이미지 경로 DB에 등록
		ms.setImgPath(uip);

		
/* 	//Get에서 처리 
		
		//이미지 경로 DB에서 가져오기
//		String path = ms.getImgPath(uip);
		
		// test
//		System.out.println(path);
		
		// 리퀘스트에 경로 저장
//		request.setAttribute("imgPath", path);

*/		
		// Get으로 전달
		doGet(request, response);

	}

	
	
}
