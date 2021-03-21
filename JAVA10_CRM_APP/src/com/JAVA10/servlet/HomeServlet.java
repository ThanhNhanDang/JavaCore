package com.JAVA10.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.JAVA10.util.*;


@WebServlet(name = "homeServlet", urlPatterns = {ServiceContant.SERVICE_HOME,
												ServiceContant.SERVICE_USER_LIST,
												ServiceContant.SERVICE_USER_ADD,
												ServiceContant.SERVICE_ROLE_ADD,
												ServiceContant.SERVICE_ROLE_LIST})
public class HomeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		 resp.addCookie(new Cookie("username", "TuanPhan"));
		 resp.addCookie(new Cookie("password", "1234"));
		 
		
		 HttpSession session = req.getSession();
		
		 Object user = session.getAttribute("user");
		if(user == null) { 
			 session.setAttribute("user", "admin");	
			 session.setMaxInactiveInterval(10);
			 System.out.println("Da setMaxInactivaInterval");
		}
		else
			System.out.println("User: " + user.toString());
		switch(req.getServletPath()) {
		case ServiceContant.SERVICE_HOME:
			req.getRequestDispatcher(URLContant.URL_HOME_PAGE).forward(req, resp);
			break;
		case ServiceContant.SERVICE_ROLE_ADD:
			req.getRequestDispatcher(URLContant.URL_ROLE_ADD).forward(req, resp);
			break;
		
		case ServiceContant.SERVICE_ROLE_LIST:
			req.getRequestDispatcher(URLContant.URL_ROLE_LIST).forward(req, resp);
			break;
			
		case ServiceContant.SERVICE_USER_ADD:
			req.getRequestDispatcher(URLContant.URL_USER_ADD).forward(req, resp);
			break;
			
		case ServiceContant.SERVICE_USER_LIST:
			req.getRequestDispatcher(URLContant.URL_USER_LIST).forward(req, resp);
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}

}
