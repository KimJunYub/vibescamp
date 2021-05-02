package com.gamsungcamp.vibes.login.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.gamsungcamp.vibes.login.vo.LoginForm;
import com.gamsungcamp.vibes.user.vo.UserVO;

@Repository("LoginDAO")
public class LoginDAOImpl implements LoginDAO {
	
	String namespace = "com.gamsungcamp.vibes.dao.login.LoginDAO";
	
	@Resource(name="sqlSessoinTemplate")
	private SqlSessionTemplate session;

	@Override
	public UserVO selectloginUser(LoginForm paramForm) throws Exception {
		return session.selectOne(namespace + ".selectloginUser", paramForm);
	}
	
}
