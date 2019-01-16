package com.kgc.test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends BaseDao{
	public List<NewsUser> findAll() throws SQLException, Exception{
		String sql = "select * from news_user";
		List<NewsUser> userList = new ArrayList<NewsUser>();
		NewsUser user = null;
		PreparedStatement ps = this.getConn().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			user = new NewsUser();
			user.setId(rs.getLong(1));
			userList.add(user);
		}
		return userList;
	}
}
