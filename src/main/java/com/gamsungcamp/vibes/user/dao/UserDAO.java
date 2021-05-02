package com.gamsungcamp.vibes.user.dao;

import java.util.List;

import com.gamsungcamp.vibes.user.vo.UserVO;


public interface UserDAO {
	
	public List<UserVO> selectList(String userId) throws Exception; 
	
}
