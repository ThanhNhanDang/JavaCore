package com.myclass.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class firstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*
	 * Khi nguoi dung truy cap duong dan website/welcome
	 * thi in ra dong chu "Welcome to my class" ra man hinh
	 * browser cua nguoi dung
	 * 
	 * yêu cầu thêm: Người dùng sẽ truyền lên tên của họ
	 * In ra dòng chữ "Welcome <Tên người dùng> to my class>"
	 * 
	 * 	+ Để truyền tên lên       --> Dùng query string
	 *
	 */

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = 	req.getParameter("username");
		PrintWriter writer = resp.getWriter();
		writer.print("<h1>Welcome " + name + " to  my class</h1>");
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
