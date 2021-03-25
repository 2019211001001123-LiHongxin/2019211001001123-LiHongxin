<%--
  Created by IntelliJ IDEA.
  User: LXXLC
  Date: 2021/3/18
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/register">
    <tr><td>Username：<input name="username" type="text"></td></tr>
    <tr><td>Password：<input name="password" type="password" required placeholder="No less than 8 , No more than 30" pattern=".{8,16}"/></td></tr>
    <tr><td>Email:<input name="email" type="text"></td></tr>
    <tr><td>gender:<input type="radio" name="gender" value="male">Male<input type="radio" name="gender" value="Female">Female<br/></td></tr>&ensp; 	&ensp; 	&ensp; 	&ensp;
    <tr><td>Birthdate:<input name="birthdate" type="text" required placeholder="yyyy-dd-mm"
                             pattern="\d{4}-((0[1-9])|(1\d)|(2\d)|(3[0-1]))-(0[1-9]|(1[0-2]))"/>
    <tr><td><input type=submit></td></tr>
</form>
</body>
</html>