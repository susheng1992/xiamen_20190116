package com.kgc.test;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Test {
	public Connection getConn() throws Exception {
		Context initcontext=new InitialContext();
		Context context=(Context) initcontext.lookup("java:comp/env");
		DataSource datasource=(DataSource)context.lookup("jdbc/news");
		Connection cn=datasource.getConnection();
		System.out.print("........................."+cn);
		return cn;
	}
}
