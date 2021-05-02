package com.gamsungcamp.vibes.login.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gamsungcamp.vibes.common.util.EncoderUtil;
import com.gamsungcamp.vibes.controller.HomeController;
import com.gamsungcamp.vibes.login.service.LoginService;
import com.gamsungcamp.vibes.login.vo.LoginForm;
import com.gamsungcamp.vibes.user.service.UserService;
import com.gamsungcamp.vibes.user.vo.UserVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Resource(name="UserService")
	private UserService userService;
	
	@Resource(name="LoginService")
	private LoginService loginService;
	
	@RequestMapping(value = "/login.do")
	public ModelAndView index(HttpServletRequest req, HttpServletResponse res) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("login/login2");
		
		return mv;
	}
	
	@RequestMapping(value = "/loginProcess.do")
	public ModelAndView loginProcess(HttpServletRequest req, HttpServletResponse res, 
			@ModelAttribute("LoginForm") LoginForm paramForm) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		paramForm.setPassword(new EncoderUtil().encodingToSHA256(paramForm.getPassword()));
		
		UserVO user = (UserVO) loginService.selectloginUser(paramForm);
		
		if(user!=null) {

			HttpSession session = req.getSession();
			
			session.setAttribute("userId", user.getUserId());
			session.setAttribute("userGrade", user.getUserGrade());
			
			mv.setViewName("home");
		}else {
			mv.setViewName("login/login");
			mv.addObject("result", "FAIL");
		}
		
		return mv;
	}
	
}
