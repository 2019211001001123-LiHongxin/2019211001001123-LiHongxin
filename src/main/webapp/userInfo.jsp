<%@ page import="com.LiHongxin.model.user" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/4/12
  Time: 21:48
<%@ page import="com.WanZhimin.model.User" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/4/12
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>
<h1>UserInfo</h1>
<%
    user u = (user) session.getAttribute("user");
%>
<table>
    <tr><td>Username:</td><td><%=u.getUsername()%></td></tr>
    <tr><td>Password:</td><td><%=u.getPassword()%></td></tr>
    <tr><td>Email:</td><td><%=u.getEmail()%></td></tr>
    <tr><td>Gender:</td><td><%=u.getGender()%></td></tr>
    <tr><td>Birthdate:</td><td><%=u.getBirthDate()%></td></tr>
</table>
<%@include file="footer.jsp"%>
</body>
</html>