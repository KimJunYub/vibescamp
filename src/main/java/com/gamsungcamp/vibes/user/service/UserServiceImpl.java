package com.gamsungcamp.vibes.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gamsungcamp.vibes.user.dao.UserDAO;
import com.gamsungcamp.vibes.user.vo.UserVO;

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {
	
	@Resource(name="UserDAO")
	private UserDAO userDao;
	
	public List<UserVO> selectList(String userId) throws Exception {
		return userDao.selectList(userId);
	}
	

}
