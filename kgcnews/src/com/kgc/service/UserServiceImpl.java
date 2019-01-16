package com.kgc.service;

import java.util.List;

import com.kgc.dao.UserDao;
import com.kgc.dao.UserDaoImpl;
import com.kgc.pojo.NewsUser;

public class UserServiceImpl implements UserService{
	private UserDao userDao = new UserDaoImpl();
	@Override
	public List<NewsUser> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public int addUser(NewsUser user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(NewsUser user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(long id) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(id);
	}

	@Override
	public NewsUser findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return userDao.count();
	}

}
