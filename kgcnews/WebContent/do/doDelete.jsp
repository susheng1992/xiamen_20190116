<%@page import="com.kgc.service.UserServiceImpl"%>
<%@page import="com.kgc.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String paramId = request.getParameter("id");
	long id = 0;
	if(paramId!=null){
		id = Long.parseLong(paramId);
	}else{
		id = 0;
	}
	UserService userService = new UserServiceImpl();
	int result = userService.deleteUser(id);
	if(result>0){
		request.setAttribute("message", "删除成功");
	}else{
		request.setAttribute("message", "删除失败");
	}
	request.getRequestDispatcher("../index.jsp").forward(request, response);
	//response.sendRedirect(request.getContextPath()+"/index.jsp");
%>
</body>
</html>