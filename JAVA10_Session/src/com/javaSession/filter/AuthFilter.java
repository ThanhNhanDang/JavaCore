package com.javaSession.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "authFilter", urlPatterns = "/*")
public class AuthFilter implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String path = req.getServletPath();
		if("/login".equals(path) || 
				path.startsWith("/assets")){
			chain.doFilter(request, response);
		}
		else {
			String username  = (String)req.getSession().getAttribute("user");
			if(username == null)
				resp.sendRedirect(req.getContextPath() + "/login");
			else
				chain.doFilter(request, response);
		}
		
	}
}
