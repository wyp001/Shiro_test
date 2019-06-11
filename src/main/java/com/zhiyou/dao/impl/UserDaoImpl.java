package com.zhiyou.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhiyou.dao.UserDao;
import com.zhiyou.pojo.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{
	@Autowired
	SessionFactory sessionFactory;

	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User where name =:name");
		query.setParameter("name", name);
		User user = (User)query.uniqueResult();
		
		return user;
	}

	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(User.class,id);
	}

}
