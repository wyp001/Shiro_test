package com.zhiyou.dao;

import com.zhiyou.pojo.User;

public interface UserDao {

	User getUserByName(String name);
	
	User getUserById(int id);
}
