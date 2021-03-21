package com.JAVA.JSP;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = "/login") 

public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userName = req.getParameter("username");
		String passWord = req.getParameter("password");
		
		if ("admin".equalsIgnoreCase(userName)
					&& "admin".equalsIgnoreCase(passWord)) {
			resp.sendRedirect(req.getContextPath() + "/home");
		}
		else {
			req.setAttribute("message", "Sai username hoặc password");
			req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
		}
		
		
	}
}
