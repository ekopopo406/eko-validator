package com.eko.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

 
public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 32432434327L;
	
	private static Logger logger = Logger.getLogger(BaseServlet.class
			.toString());
	public abstract void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException ; 
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		request.setCharacterEncoding("UTF-8");
		
		try{
			process(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	 
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		doPost(request, response);
	}
}
