package com.gamsungcamp.vibes.login.service;

import com.gamsungcamp.vibes.login.vo.LoginForm;
import com.gamsungcamp.vibes.user.vo.UserVO;


public interface LoginService {

	public UserVO selectloginUser(LoginForm paramForm) throws Exception;
	
}
