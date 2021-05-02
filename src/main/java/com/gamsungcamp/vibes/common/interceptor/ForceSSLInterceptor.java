package com.gamsungcamp.vibes.common.interceptor;

import java.net.InetAddress;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ForceSSLInterceptor extends HandlerInterceptorAdapter{
	 
	protected Log log = LogFactory.getLog(ForceSSLInterceptor.class);
	 
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
    	
    	String secureURL = request.getRequestURI().toString();
    	
//    	if(InetAddress.getLocalHost().getHostAddress().equals("150.0.0.80")) return true;
//    	
//    	if(request.getRequestURL().indexOf("https://") == -1 && request.getRequestURL().indexOf("http://") == 0) {
//    		secureURL = secureURL.replace("http://", "https://");
//    	}
//    	
//    	if(request.getServerPort() != 8080 && ! request.isSecure()) {
//    		
//    		String redirectURL = secureURL;
//    		
//    		if (request.getQueryString() != null) {
//				redirectURL +="?" + request.getQueryString();
//			}
//    		
//    		request.getSession(true);
//    		response.sendRedirect(redirectURL);
//    		return false;
//    		
//    	}
    	
    	return true;

    }
 
}