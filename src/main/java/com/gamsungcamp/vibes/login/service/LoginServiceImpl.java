package com.gamsungcamp.vibes.login.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gamsungcamp.vibes.login.dao.LoginDAO;
import com.gamsungcamp.vibes.login.vo.LoginForm;
import com.gamsungcamp.vibes.user.vo.UserVO;


@Service("LoginService")
@Transactional
public class LoginServiceImpl implements LoginService {
	
	@Resource(name="LoginDAO")
	private LoginDAO loginDao;
	
	public UserVO selectloginUser(LoginForm paramForm) throws Exception {
		return loginDao.selectloginUser(paramForm);
	}
	

}
