package com.kgc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.kgc.util.Configuration;

public class BaseDao {
	Connection conn = null;
	PreparedStatement ps = null;
	private ResultSet rs = null;

	/**
	 * ��������
	 * 
	 * @return
	 */
	public Connection getConn() {
//		String driver = Configuration.getConfig().getkey("driver");
//		String url = Configuration.getConfig().getkey("url");
//		String user = Configuration.getConfig().getkey("username");
//		String password = Configuration.getConfig().getkey("password");
//		;
//		try {
//			// 1����������
//			Class.forName(driver);
//			// 2����������
//			conn = DriverManager.getConnection(url, user, password);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return conn;
		Context initcontext;
		try {
			initcontext = new InitialContext();
			Context context=(Context) initcontext.lookup("java:comp/env");
			DataSource datasource=(DataSource)context.lookup("jdbc/news");
			conn=datasource.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}

	/**
	 * �ر���Դ
	 * 
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	public void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��Բ�ѯ
	 * 
	 * @param sql
	 * @param obj
	 * @return
	 */
	public ResultSet executeQuery(String sql, Object[] obj) {
		// ��������
		conn = this.getConn();
		try {
			// ��ִ��
			ps = conn.prepareStatement(sql);
			if (obj != null) {// �жϲ����Ƿ�Ϊnull�������Ϊnull������ѭ������
				for (int i = 0; i < obj.length; i++) {
					ps.setObject((i + 1), obj[i]);
				}
			}
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * �����ɾ��
	 * @param sql
	 * @param obj
	 * @return
	 */
	public int executeUpdate(String sql, Object[] obj) {
		int result = 0;
		// ��������
		conn = this.getConn();
		try {
			// ��ִ��
			ps = conn.prepareStatement(sql);
			if (obj != null) {// �жϲ����Ƿ�Ϊnull�������Ϊnull������ѭ������
				for (int i = 0; i < obj.length; i++) {
					ps.setObject((i + 1), obj[i]);
				}
			}
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeAll(conn, ps, null);
		}
		return result;
	}
}
