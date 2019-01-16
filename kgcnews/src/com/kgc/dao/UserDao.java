package com.kgc.dao;

import java.util.List;

import com.kgc.pojo.NewsUser;

public interface UserDao {
	public List<NewsUser> findAll();
	
	public int addUser(NewsUser user);
	
	public int updateUser(NewsUser user);
	
	public int deleteUser(long id);
	
	public NewsUser findById(long id);
	
	public int count();
}
