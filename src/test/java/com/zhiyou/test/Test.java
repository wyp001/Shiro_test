package com.zhiyou.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhiyou.dao.UserDao;
import com.zhiyou.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-*.xml")
public class Test {
	@Autowired
	UserDao userDao;
	
	@org.junit.Test
	public void test(){
		User user = userDao.getUserById(1);
		System.out.println("111111");
		//System.out.println(user);
	}
	
	
}
