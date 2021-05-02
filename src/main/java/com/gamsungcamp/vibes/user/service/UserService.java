package com.gamsungcamp.vibes.user.service;

import java.util.List;

import com.gamsungcamp.vibes.user.vo.UserVO;


public interface UserService {

	public List<UserVO> selectList(String userId) throws Exception;
	
}
