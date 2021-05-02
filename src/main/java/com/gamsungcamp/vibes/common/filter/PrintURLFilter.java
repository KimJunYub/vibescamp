package com.gamsungcamp.vibes.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class PrintURLFilter implements Filter {

	FilterConfig filterConfig = null;
	
	@Override
	public void destroy() {
		this.filterConfig = null;
	}
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		//String FilterParam = config.getInitParameter("FilterParam");
//		System.out.println("FilterParam: " + FilterParam + " -----------------");
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
//		System.out.println("ø‰√ª URL: " + req.getRequestURI() + " --------------------------------");
		
//		if(excludeUrl(req)) {
//			chain.doFilter(request, response);
//		}else {
//			//chain.doFilter(new RequestWrapper((HttpServletRequest)req), response);
//		}
		chain.doFilter(request, response);
		
	}

	private boolean excludeUrl(HttpServletRequest req) {
		String uri = req.getRequestURI().toString().trim();
		
		if(uri.startsWith("/login")) {
			return true;
			
		}else {
			return false;
		}
	}
	
}