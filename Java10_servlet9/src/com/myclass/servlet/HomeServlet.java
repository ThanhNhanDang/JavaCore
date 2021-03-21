package com.myclass.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet{

	/*
	 * Cấu hình để khi người dùng gọi đến đường dẫn /home
	 * thì sẽ gọi đến HomeServlet
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html");
		String contextPath = req.getContextPath();
		writer.print("<form action=\""+ contextPath +"/home\" method=\"post\">\r\n"
				+ "      <input type=\"text\" name=\"username\" id=\"\" />\r\n"
				+ "      <input type=\"submit\" value=\"Submit\" />\r\n"
				+ "    </form>");
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Nhận username từ người dùng và hiển thị
		String userName = req.getParameter("username");
		System.out.println("user name: " + userName);
		
		//resp.sendRedirect(req.getContextPath() + "/welcome");//sendRedirect chỉ gọi đường dẫn /welcome thôi
															//khi dùng chuyển về trang chủ, sử dụng để chuyển trang và lưu username vào cookie...
															// chưa có gửi username
		RequestDispatcher dispatcher = req.getRequestDispatcher("/welcome");//khi dùng đăng nhập nhiều thông tin, nó sẽ đẩy mấy cái tab
		dispatcher.forward(req, resp);
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("init() method has been called");
	}
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1); // nếu không có dòng này thì nội dung xẽ bị xóa
		System.out.println("Service() method has been called");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("destroy() method has been called");
	}

}
