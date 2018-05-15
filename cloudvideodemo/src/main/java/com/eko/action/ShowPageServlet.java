package com.eko.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用于页面跳转处理的Servlet
 * @author sitinspring
 *
 * @date 2008-2-12
 */
public class ShowPageServlet extends HttpServlet {
	private static final long serialVersionUID = 56890894234786L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		request.setCharacterEncoding("UTF-8");
		
		String page=request.getParameter("page");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/page/"+page+".jsp");
		dispatcher.forward(request, response);
		return;
	}
		
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		doPost(request, response);
	}
}
