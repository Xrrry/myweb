<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/signin.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <form name="loginForm" action="test.jsp" method="post" class="form-signin">
        <h2 class="form-signin-heading">请登录</h2>
        <label class="sr-only">账号</label>
        <input name="account" type="text" class="form-control" placeholder="账号" required autofocus><br>
        <label class="sr-only">密码</label>
        <input name="password" type="password" class="form-control" placeholder="密码" required>
        <label class="radio-inline">
        <input name="identity" type="radio" value="学生" checked>学生
        </label>
        <label class="radio-inline">
        <input name="identity" type="radio" value="教师" >教师
        </label>
        <input class="btn btn-lg btn-primary btn-block" style="margin-top: 30px;" type="submit" value="登录">
    </form>
</div>
</body>
</html>