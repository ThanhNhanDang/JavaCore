package com.myclass.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{

	
	/*
	 * form do get
	 * Cấu hình LoginServlet sau cho
	 * 	- Khi người dùng vào đường dẫn "/login"
	 * 		hiện ra form đăng nhập yêu cầu
	 * 		nhập username, mật khẩu, nút submit
	 * 	- Khi người dùng ấn nút submit
	 *  	+ nếu username và mật khẩu là 
	 *  	"admin" / "admin"
	 *  	chuyển người dùng đến trang mới 
	 *  	hiển thị tiêu đề 
	 *  	"Welcome back." (tạo thêm WelcomeServlet)
	 *  	+ nếu nhập sai username, và mật khẩu
	 *  	hiển thị lại form đăng nhập (	sendRedirect(req.getContextPath()+/login)  )
	 */
	
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html");
		
		String contextPath = req.getContextPath(); // Lấy tên của project 
		writer.append("<form action=\"" + contextPath + "/login\" method=\"POST\">\r\n"
				+ "      <p>Username:</p>\r\n"
				+ "      <input type=\"text\" name=\"username\" id=\"\" />\r\n"
				+ "      <p>Password:</p>\r\n"
				+ "      <input type=\"password\" name=\"password\" id=\"\" />\r\n"
				+ "      <input type=\"submit\" value=\"Submit\" />\r\n"
				+ "    </form>");
		
		for (int i = 0; i < 5; i++) {
			writer.append("<h1> Number: "+ i +"</h1>");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Nhận username từ người dùng và hiển thị
		String userName = req.getParameter("username");
		String passWord = req.getParameter("password");
		
		String contextPath = req.getContextPath(); // Lấy tên của project 
		
		if ("admin".equalsIgnoreCase(userName)

					&& "admin".equalsIgnoreCase(passWord)) {
			resp.sendRedirect(contextPath + "/welcome_servlet");
		}
		else
			resp.sendRedirect(contextPath + "/login");
		
		//resp.sendRedirect(req.getContextPath() + "/welcome");//sendRedirect chỉ gọi đường dẫn /welcome thôi
															//khi dùng chuyển về trang chủ, sử dụng để chuyển trang và lưu username vào cookie...
															// chưa có gửi username
		
	}
}
