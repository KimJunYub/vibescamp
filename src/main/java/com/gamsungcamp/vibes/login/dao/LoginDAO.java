package com.gamsungcamp.vibes.login.dao;

import com.gamsungcamp.vibes.login.vo.LoginForm;
import com.gamsungcamp.vibes.user.vo.UserVO;

public interface LoginDAO {
	
	public UserVO selectloginUser(LoginForm paramForm) throws Exception; 
	
}
