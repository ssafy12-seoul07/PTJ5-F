package com.ssafy.user.model.dao;

import com.ssafy.user.model.dto.User;

public interface UserDao {

	int insert(User user);
	
	User selectOne(String id);
		
}
