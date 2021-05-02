package com.gamsungcamp.vibes.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.gamsungcamp.vibes.common.bean.SessionInfo;
import com.gamsungcamp.vibes.common.util.StringUtil;

public class CommonInterceptor extends HandlerInterceptorAdapter{
	 
	protected Log log = LogFactory.getLog(CommonInterceptor.class);
	 
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
    	
    	HttpSession session = request.getSession();
    	SessionInfo sessionInfo = (SessionInfo) session.getAttribute("SessionInfo");
    	String accsIpAddr = "";
    	String reqURI = request.getRequestURI();
    	String proxyIp = request.getHeader("Proxy-Client-IP");
    	String forwardedIp = request.getHeader("X-Forwarded-For");
    	
    	if(proxyIp == null || proxyIp.length()==0) {
    		accsIpAddr = request.getRemoteAddr();
    		System.out.println("Çï2");
    	}else {
    		accsIpAddr = proxyIp;
    	}
    	
    	if(forwardedIp == null|| forwardedIp.length() == 0) {
    		forwardedIp = "127.0.0.1";
    	}
    	
//    	if(reqURI.equals("")) {
//    		return true;
//    	}
//    	
//    	if(sessionInfo==null||StringUtil.isEmpty(sessionInfo.getUserId())) {
//    		request.getRequestDispatcher("").forward(request, response);
//    		return false;
//    	}
    	
    	
        if (log.isDebugEnabled()) {
//            log.debug("===================       START       ===================");
//            log.debug(" Request URI \t:  " + request.getRequestURI());
        }
        return super.preHandle(request, response, handler);
    }
 
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        if (log.isDebugEnabled()) {
//            log.debug("===================        END        ===================\n");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub
        super.afterCompletion(request, response, handler, ex);
    }
 
}