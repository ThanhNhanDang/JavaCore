package com.project.jdbcCountrUser.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jdbcCountrUser.util.*;
import com.project.jdbcCountrUser.model.User;
import com.project.jdbcCountrUser.service.*;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {
		ServiceConstant.PATH_COUNTRY,
		ServiceConstant.PATH_USER,
		ServiceConstant.PATH_USER_ADD,
		ServiceConstant.PATH_USER_DELETE,
		ServiceConstant.PATH_USER_EDIT,
		""
})
public class ProjectServlet extends HttpServlet{
	private ProjectService service;
	@Override
	public void init() throws ServletException {
		super.init();
		service = new ProjectService();
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		switch (req.getServletPath()) {
		case "":
			
			req.getRequestDispatcher(JSPConstant.URL_LOGIN).forward(req, resp);
			break;
		case ServiceConstant.PATH_COUNTRY:
			req.setAttribute("listCountry", service.getAllCountry());
			req.getRequestDispatcher(JSPConstant.URL_HOMEPAGE).forward(req, resp);
			break;
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (req.getServletPath()) {
		case ServiceConstant.PATH_USER:
			User user = service.getUserAfterLoginSuccess(req.getParameter("userName"),
					                                     req.getParameter("password"));
			if (user != null) {
				req.setAttribute("userProfile", user);
				req.setAttribute("loginSuccess", true);
				req.getRequestDispatcher(JSPConstant.URL_HOMEPAGE).forward(req, resp);
			}
			else {
				resp.sendRedirect(req.getContextPath() + "");
			}
			break;	
		case ServiceConstant.PATH_COUNTRY:
			resp.sendRedirect(req.getContextPath() + ServiceConstant.PATH_COUNTRY);
			break;
		}
	}
}
