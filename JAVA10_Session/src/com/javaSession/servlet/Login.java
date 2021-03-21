package com.javaSession.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/home", "/login"})
public class Login extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		switch(req.getServletPath()) {
			case  "/home":
				req.getRequestDispatcher("/WEB-INF/dashboad.jsp").forward(req, resp);
				break;
			case  "/login":
				req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
				break;
		    }	
		}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch(req.getServletPath()) {
		case  "/login":
			String userName = req.getParameter("username");
			String password = req.getParameter("password");
			if("admin".equals(password)) {
				HttpSession session = req.getSession();
				session.setAttribute("user", userName);
				session.setMaxInactiveInterval(60);
				resp.sendRedirect(req.getContextPath() + "/home");
			}
			else {
				resp.sendRedirect(req.getContextPath() + "/login");
			}
		}
	}
}
