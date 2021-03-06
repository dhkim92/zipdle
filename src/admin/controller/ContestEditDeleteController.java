package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.ComunityEditDao;
import reform.dto.ReformDto;
import reform.service.ReformService;
import reform.service.ReformServiceImpl;

@WebServlet("/admin/contestDelete.do")
public class ContestEditDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ComunityEditDao rfeddao = new ComunityEditDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String check = request.getParameter("names");
		
		rfeddao.deleteContest(check);

		// 리 다이렉트
		request.getRequestDispatcher("/admin/editContest.do").forward(request, response);
	} 
}
