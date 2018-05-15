package com.eko.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthViewerServlet extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8755204680803463473L;

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getParameter("name");
		System.out.println(str);
	}

}
