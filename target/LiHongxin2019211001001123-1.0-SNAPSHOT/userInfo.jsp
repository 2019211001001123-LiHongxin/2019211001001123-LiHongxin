<%--
  Created by IntelliJ IDEA.
  User: LXXLC
  Date: 2021/4/14
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<table>
    <td><td>Username:</td><td><%=request.getAttribute("username")%></td></tr>
    <td><td>Password:</td><td><%=request.getAttribute("password")%></td></tr>
    <td><td>email:</td><td><%=request.getAttribute("email")%></td></tr>
    <td><td>gender:</td><td><%=request.getAttribute("gender")%></td></tr>
    <td><td>birthdate:</td><td><%=request.getAttribute("birthdate")%></td></tr>
</table>
<%@include file="footer.jsp"%>