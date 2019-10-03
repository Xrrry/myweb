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
<%
    String str = request.getParameter("account");
    String str2 = request.getParameter("password");
    out.print(str+"<br>");
    out.print(str2);
%>
</body>
</html>
