package com.kgc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kgc.pojo.NewsUser;

public class UserDaoImpl extends BaseDao implements UserDao{
	ResultSet rs = null;
	@Override
	public List<NewsUser> findAll() {
		String sql = "select * from news_user";
		List<NewsUser> userList = new ArrayList<NewsUser>();
		NewsUser user = null;
		//Object[] obj = {index};
		try {
			rs = executeQuery(sql, null);
			while(rs.next()) {
				user = new NewsUser();
				user.setId(rs.getLong(1));
				user.setUserName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setUserType(rs.getInt(5));
				userList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, ps, rs);
		}
		return userList;
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
		Object[] obj = {id};
		return executeUpdate("delete from news_user where id=?", obj);
	}

	@Override
	public NewsUser findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		int count = 0;
		String sql = "select count(1) from news_user";
		rs = executeQuery(sql, null);
		try {
			while(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

}
