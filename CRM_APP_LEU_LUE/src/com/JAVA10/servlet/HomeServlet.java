package com.JAVA10.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.JAVA10.util.*;

@WebServlet(urlPatterns = {Path.HOME, 
						   Path.ROOT,
						   Path.LOGIN})

public class HomeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	public void init() throws ServletException {
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (req.getServletPath()) {
		case Path.HOME: {
			req.getRequestDispatcher(Url.DASHBOARD).forward(req, resp);
		}
		case Path.LOGIN:
			req.getRequestDispatcher(Url.AUTH_LOGIN).forward(req, resp);
		default:
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch(req.getServletPath()) {
		case Path.LOGIN:
			String userName = req.getParameter("username");
			String password = req.getParameter("password");
			if("admin".equals(password)) {
				HttpSession session = req.getSession();
				session.setAttribute("user", userName);
				session.setMaxInactiveInterval(60);
				resp.sendRedirect(req.getContextPath() + Path.HOME);
			}
			else {
				resp.sendRedirect(req.getContextPath() + Path.LOGIN);
			}
			
			break;
		}
	}
}
