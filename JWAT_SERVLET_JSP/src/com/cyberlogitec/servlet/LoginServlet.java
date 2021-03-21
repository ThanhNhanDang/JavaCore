package com.cyberlogitec.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path 	= req.getContextPath();
		String email 	= req.getParameter("email");
		String password = req.getParameter("password");
		
		HttpSession session = req.getSession();
		
		if("admin".equals(email) && "admin".equals(password)) {
			session.setAttribute("USER", "ADMIN");
			session.setMaxInactiveInterval(60);
			resp.sendRedirect(path + "/home");
			return;
		}
		
		resp.sendRedirect(path + "/login");
	}
}
