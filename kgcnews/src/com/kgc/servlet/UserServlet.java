package com.kgc.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kgc.pojo.NewsUser;
import com.kgc.service.UserService;
import com.kgc.service.UserServiceImpl;

@WebServlet("/user.do")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService = new UserServiceImpl();
		List<NewsUser> userList = userService.findAll();
		Date date = new Date();
		request.setAttribute("date", date);
		request.setAttribute("userList", userList);
		//request.setAttribute("name", "zhangsan");
//		session.setAttribute("name", "lisi");
//		application.setAttribute("name", "wangwu");
//		pageContext.setAttribute("name", "zhaoliu");
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
