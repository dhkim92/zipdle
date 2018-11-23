package main.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import intspace.dto.Intspace;
import intspace.service.IntspaceService;
import intspace.service.IntspaceServiceImpl;
import reform.dto.ReformDto;
import reform.service.ReformService;
import reform.service.ReformServiceImpl;

@WebServlet("/zipdlee/main.do")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		IntspaceService iss = new IntspaceServiceImpl();
		ReformService rfs = new ReformServiceImpl();
		
		Intspace istop = iss.top1();
		ReformDto rftop = rfs.top();
		
		request.setAttribute("istop", istop);
		request.setAttribute("rftop", rftop);
		
		System.out.println(rftop);
		
		
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		// 응답객체 문서형식 설정(+인코딩)
		response.setContentType("text/html;charset=utf-8");
		
		
		
	}

}
