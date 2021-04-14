<%--
  Created by IntelliJ IDEA.
  User: LXXLC
  Date: 2021/4/8
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<form method="post" action="${pageContext.request.contextPath}/login">
    <tr><td>Username：<input name="username" type="text"></td></tr>
    <tr><td>Password：<input name="password" type="password" required placeholder="No less than 8 , No more than 30" pattern=".{8,16}"/></td></tr>
    <tr><td><input type=submit></td></tr>
</form>
<%@include file="footer.jsp"%>