package com.gamsungcamp.vibes.user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.gamsungcamp.vibes.user.vo.UserVO;


@Repository("UserDAO")
public class UserDAOImpl implements UserDAO {
	
	String namespace = "com.gamsungcamp.vibes.dao.user.UserDAO";
	
	@Resource(name="sqlSessoinTemplate")
	private SqlSessionTemplate session;

	@Override
	public List<UserVO> selectList(String userId) throws Exception {
		return session.selectList(namespace + ".selectList", userId);
	}
	
}
