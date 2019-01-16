<%@page import="com.kgc.pojo.NewsUser"%>
<%@page import="java.util.List"%>
<%@page import="com.kgc.service.UserServiceImpl"%>
<%@page import="com.kgc.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table border="1" cellspacing="0" cellpadding="10" align="center">
		<tr align="center" height="40px">
			<td width="50px">编号</td>
			<td width="120px">用户名</td>
			<td width="200px">用户类型</td>
			<!-- <td width="200px">操作</td> -->
		</tr>
		<c:forEach items="${userList }" var="user">
		 <tr align="center" height="40px">
			<td width="50px">${user.id }</td>
			<td width="120px">${user.userName }</td>
			<td width="200px">
				<c:if test="${user.userType==0 }">
					系统管理员
				</c:if>
				<c:if test="${user.userType!=0 }">
					版主
				</c:if>
			</td>
			
			<%--<td width="200px">
			 <a href="">修改</a>&nbsp;&nbsp;
			<a href="do/doDelete.jsp?id=<%=user.getId() %>">删除</a> 
			</td>--%>
		</tr>
		</c:forEach>
	</table>
		<p><fmt:formatDate value="${date }" pattern="yyyy年MM月dd日 HH时mm分ss秒"/></p>
	<%-- <p align="center">
			<a href="index.jsp?currentPage=1">首页</a>
			<a href="index.jsp?currentPage=<%=current-1%>">上一页</a>
			第<%=current %>页/共<%=totalPage %>页
			<a href="index.jsp?currentPage=<%=current+1%>">下一页</a>
			<a href="index.jsp?currentPage=<%=totalPage%>">尾页</a>
		</p> --%>
		
		
		
		
		
		
		
		<h1>${name }</h1>
		
		
		
		
</body>
</html>