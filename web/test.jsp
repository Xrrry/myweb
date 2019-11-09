<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/9/27
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
</head>
<body>
<% request.setCharacterEncoding("utf-8"); %>
<% String account = request.getParameter("account");
    out.println("<br>姓名：" + account + "<br>");
    String password = request.getParameter("password");
    out.println("<br>密码：" + password + "<br>");
%>
<br>账号:${param.account}<br><br>密码:${param.password}<br>
</body>
</html>
