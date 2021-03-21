package com.JAVA.JSP;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "HomeServlet", urlPatterns = "/home") 

public class HomeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//resp.sendRedirect("baiTap.jsp");	khi file nằm trong WRB-INF thi truy cập dùng forward()
		req.getRequestDispatcher("/WEB-INF/home.jsp").forward(req, resp);
	}
	
}
